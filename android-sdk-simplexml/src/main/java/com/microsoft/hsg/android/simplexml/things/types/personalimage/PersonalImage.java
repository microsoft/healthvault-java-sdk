package com.microsoft.hsg.android.simplexml.things.types.personalimage;

import com.microsoft.hsg.android.simplexml.things.thing.AbstractThing;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.concurrent.Callable;

import org.simpleframework.xml.Root;

import com.microsoft.hsg.android.simplexml.HttpStreamer;
import com.microsoft.hsg.android.simplexml.things.thing.BlobInfo;
import com.microsoft.hsg.android.simplexml.things.thing.BlobPayloadItem;
import com.microsoft.hsg.android.simplexml.things.thing.HealthVaultThing;
import com.microsoft.hsg.android.simplexml.things.thing.Thing2;
import com.microsoft.hsg.android.simplexml.things.types.types.Record;
import com.microsoft.hsg.android.simplexml.things.thing.ThingType;

import android.text.TextUtils;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:pi="urn:com.microsoft.wc.thing.personal-image" xmlns:t="urn:com.microsoft.wc.thing.types"&gt;
 *                         An image that represents the person.
 *                     &lt;/summary&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:pi="urn:com.microsoft.wc.thing.personal-image" xmlns:t="urn:com.microsoft.wc.thing.types"&gt;
 *                         This type has no XML data associated with it. All data
 *                         is stored as base64 encoded binary data in the "other
 *                         data" section of the thing.
 *                     &lt;/remarks&gt;
 * </pre>
 * 
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class PersonalImage extends AbstractThing {
	public static final String ThingType = "a5294488-f865-4ce3-92fa-187cd3b58930";
	
	public String getThingType() {
		return ThingType;
	}
		
	public void upload(Record record, String contentType, InputStream stream) 
			throws IOException,
				URISyntaxException {
		
		if(TextUtils.isEmpty(contentType)) {
			contentType = HttpStreamer.OctetStreamMimeType;
		}
		
		BlobInfo blobInfo = new BlobInfo(contentType);
		
		record.putBlobInItem(getThing(), blobInfo, stream);
	}
	
	public Callable<Void> uploadAsync(final Record record,
			final String contentType,
			final InputStream source)
		throws IOException,
			URISyntaxException {
		return new Callable<Void>() {
    		public Void call() throws IOException, URISyntaxException {
    			upload(record, contentType, source);
    			return null;
    		}
    	};
	}
	
	public Callable<Boolean> downloadAsync(final Record record, 
				final OutputStream destination) 
			throws URISyntaxException,
			IOException {
		return new Callable<Boolean>() {
    		public Boolean call() throws IOException, URISyntaxException {
    			return download(record, destination);
    		}
    	};
	}
	
	public boolean download(Record record, OutputStream destination) 
			throws URISyntaxException,
			IOException {
		
		BlobPayloadItem blob = refreshAndGetDefaultBlob(record);
		
		if(blob == null) {
			return false;
		}
		
		blob.download(record, destination);
		return true;
	}
	
	private BlobPayloadItem refreshAndGetDefaultBlob(Record record) {
		Thing2 thing = getThing();
		thing.refreshBlobData(record);
		if(!thing.hasBlobData()) {
			return null;
		}
		
		return thing.getBlobPayload().getDefaultBlob();
	}	
}