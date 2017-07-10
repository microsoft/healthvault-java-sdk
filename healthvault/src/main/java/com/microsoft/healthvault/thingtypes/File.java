package com.microsoft.healthvault.thingtypes;

import com.microsoft.healthvault.HttpStreamer;
import com.microsoft.healthvault.types.blob.BlobInfo;
import com.microsoft.healthvault.types.blob.BlobPayloadItem;
import com.microsoft.healthvault.types.CodableValue;
import com.microsoft.healthvault.types.String255;
import com.microsoft.healthvault.types.Record;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.concurrent.Callable;

@Order(elements = {
	"name",
	"size",
	"content-type"
})

@Root(name = "file")
public class File extends AbstractThing {

	public static final String ThingType = "bd0403c5-4ae2-4b0e-a8db-1888678e4528";
	
	@Element(name= "name", required= true)
	protected String255 name;
	
	@Element(name= "size", required= true)
	protected long size;
	
	@Element(name= "content-type", required= false)
	protected CodableValue contentType;
	
	public File() {
	}

	public File(String name, String contentType) {
		this.name = new String255(name);
		this.contentType = new CodableValue(contentType);
	}

	public String getName() {
		return name == null ? null : name.getValue();
	}

	public void setName(String name) {
		this.name = new String255(name);
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public CodableValue getContentType() {
		return contentType;
	}

	public void setContentType(CodableValue contentType) {
		this.contentType = contentType;
	}

	@Override
	public String getThingType() {
		return ThingType;
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
	
	public Boolean download(Record record,
				OutputStream destination) 
			throws URISyntaxException, 
			IOException {
		
		BlobPayloadItem blob = refreshAndGetDefault(record);
		
		if(blob == null) {
			return false;
		}
		
		blob.download(record, destination);
		return true;
	}
	
	public Callable<Void> uploadAsync(final Record record,
			final String contentType,
			final InputStream source)
		throws IOException, URISyntaxException {
		return new Callable<Void>() {
    		public Void call() throws IOException, URISyntaxException {
    			upload(record, contentType, source);
    			return null;
    		}
    	};
	}
		
	public void upload(Record record,
			String contentType,
			InputStream source)
		throws IOException, URISyntaxException {
		
		if(contentType == null || contentType.trim() == "") {
			contentType = HttpStreamer.OctetStreamMimeType;
		}
		
		setContentType(new CodableValue(contentType));
		
		BlobInfo blobInfo = new BlobInfo(getName(), contentType);
		record.putBlobInItem(this.getThing(), blobInfo, source);
	}
	
	private BlobPayloadItem refreshAndGetDefault(Record record) {
		   Thing2 thing = getThing();
		   
		   thing.refreshBlobData(record);
		   if (!thing.hasBlobData())
		   {
			   return null;
		   }
		   
		   return thing.getBlobPayload().getDefaultBlob();
	}
}
