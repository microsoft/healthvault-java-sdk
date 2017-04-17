package com.microsoft.hsg.android.simplexml.store;

import java.util.List;

import com.microsoft.hsg.android.simplexml.localvault.SynchronizedView;
import com.microsoft.hsg.android.simplexml.things.thing.AbstractThing;
import com.microsoft.hsg.android.simplexml.things.thing.Thing2;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;

public class SynchronizedViewLoader extends AsyncTaskLoader<List<String>> {
	
	private Context context;
	private List<String> data;
	private SynchronizedView syncView;
	private ContentObserver observer;

    public SynchronizedViewLoader(Context context, SynchronizedView syncView) {
        super(context);
        this.context = context;
        this.syncView = syncView;
        observer = new ForceLoadContentObserver();
    	syncView.registerObserver(observer);
    	setUpdateThrottle(0);
    }

    @Override public List<String> loadInBackground() {
    	return syncView.getThingKeys();
    }
    
    @Override
    public void deliverResult(List<String> data) {
      if (isReset()) {
        // The Loader has been reset; ignore the result and invalidate the data.
        // releaseResources(data);
        return;
      }
      
      this.data = data;

      if (isStarted()) {
        // If the Loader is in a started state, deliver the results to the
        // client. The superclass method does this for us.
        super.deliverResult(data);
      }
    }
    
    @Override
    protected void onStartLoading() {
      if (data != null) {
        // Deliver any previously loaded data immediately.
        deliverResult(data);
      }

      // Begin monitoring the underlying data source.
      //if (mObserver == null) {
      //  mObserver = new SampleObserver();
      //}

      if (takeContentChanged() || data == null) {
        // When the observer detects a change, it should call onContentChanged()
        // on the Loader, which will cause the next call to takeContentChanged()
        // to return true. If this is ever the case (or if the current data is
        // null), we force a new load.
        forceLoad();
      }
    }

    @Override
    protected void onStopLoading() {
      // The Loader is in a stopped state, so we should attempt to cancel the 
      // current load (if there is one).
      cancelLoad();

      // Note that we leave the observer as is. Loaders in a stopped state
      // should still monitor the data source for changes so that the Loader
      // will know to force a new load if it is ever started again.
    }

    @Override
    protected void onReset() {
      // Ensure the loader has been stopped.
      onStopLoading();

      // At this point we can release the resources associated with 'mData'.
      //if (mData != null) {
      //  releaseResources(mData);
      data = null;
      //}
      
      syncView.unregisterObserver(observer);
    }
}


