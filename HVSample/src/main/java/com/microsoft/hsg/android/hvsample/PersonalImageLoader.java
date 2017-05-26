package com.microsoft.hsg.android.hvsample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import android.widget.ImageView;
import android.widget.Toast;

import com.microsoft.hsg.HVException;
import com.microsoft.hsg.android.simplexml.HealthVaultApp;
import com.microsoft.hsg.android.simplexml.client.HealthVaultClient;
import com.microsoft.hsg.android.simplexml.client.RequestCallback;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.ThingRequestGroup2;
import com.microsoft.hsg.android.simplexml.methods.getthings3.response.ThingResponseGroup2;
import com.microsoft.hsg.android.simplexml.things.thing.Thing2;
import com.microsoft.hsg.android.simplexml.things.types.personalimage.PersonalImage;
import com.microsoft.hsg.android.simplexml.things.types.types.Record;

public class PersonalImageLoader implements ComponentCallbacks2 {

	private ImageLruCache mCache;
	private HealthVaultClient mClient;
	private WeakReference<Activity> mContext;

	public PersonalImageLoader(Activity context,
			HealthVaultClient client) {
		ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		int memSize = am.getMemoryClass() * 1024 * 1024;

		mCache = new ImageLruCache(memSize);
		mClient = client;
		mContext = new WeakReference<Activity>(context);
	}

	public void load(String id, ImageView imageView, int defaultresource) {
		imageView.setImageResource(defaultresource);
		Bitmap image = mCache.get(id);
		if (image != null) {
			imageView.setImageBitmap(image);
		} else {
			List<Record> records = HealthVaultApp.getInstance().getRecordList();
			Record record = null;

			for(Record rcd : records) {
				if(id == rcd.getId()) {
					record = rcd;
					break;
				}
			}

			mClient.asyncRequest(getImageAsync(record), new PersonalImageCallback(id, imageView));
		}
	}
	
	private Callable<Bitmap> getImageAsync(final Record record) {
		return new Callable<Bitmap>() {
			public Bitmap call() throws Exception {
				if (mContext == null) {
					throw new Exception("The activity can not be null");
				}
				// check if it exist in file
				File cacheDir = mContext.get().getCacheDir();;

				if(!cacheDir.exists()) {
					cacheDir.mkdirs();
				}

				File file = new File(cacheDir, "personalimage" + record.getId());

				if(file.exists()) {
					FileInputStream in = new FileInputStream(file);
					Bitmap bitmap = BitmapFactory.decodeStream(in);
					in.close();
					return bitmap;
				}

				// try to get from web
				ThingResponseGroup2 response = record.getThings(ThingRequestGroup2.thingTypeQuery(PersonalImage.ThingType));
				List<Thing2> things = response.getThing();

				if(things != null && !things.isEmpty()) {
					Thing2 thing = things.get(0);
					PersonalImage image = (PersonalImage)thing.getData();
					FileOutputStream destination = null;
					FileInputStream inputStream = null;
					Bitmap bitmap;

					try {
						destination = new FileOutputStream(file);
						image.download(record, destination);

						inputStream = new FileInputStream(file);
						bitmap = BitmapFactory.decodeStream(inputStream);
						return bitmap;

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						if (destination != null) {
							destination.close();
						}
						if (inputStream != null) {
							inputStream.close();
						}
					}
				}

				return null;
			}
		};
	}

	@Override
	public void onConfigurationChanged(Configuration arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTrimMemory(int level) {
		 if (level >= TRIM_MEMORY_MODERATE) {
			 mCache.evictAll();
		 }
		else if (level >= TRIM_MEMORY_BACKGROUND) {
			 mCache.trimToSize(mCache.size() / 2);
		}
	}
	
	private class ImageLruCache extends LruCache<String, Bitmap> {
		public ImageLruCache(int maxSize) {
			super(maxSize);
		}
	}
	
	private class PersonalImageCallback implements RequestCallback<Bitmap> {
		
		private ImageView mImageView;
		private String id;
		
		public PersonalImageCallback(String id, ImageView imageView) {
			this.id = id;
			mImageView = imageView;
		}

		@Override
		public void onError(HVException exception) {
			if (mContext != null) {
				Toast.makeText(
						mContext.get(), "An error occurred.  " + exception.getMessage(), Toast.LENGTH_LONG).show();
			}
		}

		@Override
		public void onSuccess(Bitmap image) {
			if(image != null) {
				mCache.put(id, image);
				mImageView.setImageBitmap(image);
			}
		}
	}
}
