package com.microsoft.hsg.android.simplexml.things.thing;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

import com.microsoft.hsg.android.simplexml.methods.getthings3.request.ThingSectionSpec2;
import com.microsoft.hsg.android.simplexml.things.types.types.Record;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:ds="" xmlns:this="urn:com.microsoft.wc.thing" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:d="urn:com.microsoft.wc.dates" xmlns:ds="" xmlns:this="urn:com.microsoft.wc.thing" xmlns:wc-auth="urn:com.microsoft.wc.auth" xmlns:wc-types="urn:com.microsoft.wc.types"/&gt;
 * </pre>
 * 
 * 
 * <p>Java class for BlobPayload complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BlobPayload">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="blob" type="{urn:com.microsoft.wc.thing}BlobPayloadItem" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "blob"
})
public class BlobPayload {

    @ElementList(required = true, inline=true, entry="blob")
    protected ArrayList<BlobPayloadItem> blob;

    /**
     * Gets the value of the blob property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the object.
     * This is why there is not a <CODE>set</CODE> method for the blob property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBlob().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BlobPayloadItem }
     * 
     * 
     */
    public List<BlobPayloadItem> getBlob() {
        if (blob == null) {
            blob = new ArrayList<BlobPayloadItem>();
        }
        return this.blob;
    }
    
    public Boolean hasBlobs() {
    	return blob != null && !blob.isEmpty();
    }
    
    public void addOrUpdateBlob(BlobPayloadItem blobItem) {
    	if(hasBlobs()) {
    		int index = this.indexOfBlobNamed(blobItem.getName());
        	
        	if(index > 0) {
        		blob.remove(index);
        	}
    	}
    	
    	getBlob().add(blobItem);
    }
    
    public BlobPayloadItem getDefaultBlob() {
    	return getBlobNamed(null);
    }
    
    public BlobPayloadItem getBlobNamed(String name) {
    	
    	if(!hasBlobs()) {
    		return null;
    	}
    	
    	int index = this.indexOfBlobNamed(name);
    	
    	if(index < 0) {
    		return null;
    	}
    	
    	return blob.get(index);
    }
    
    public static BlobPayload getBlobPayload(Record record, ThingKey key) {
    // Thing2 thing = record.getItem(key, ThingSectionSpec2.blobpayload);
    // return thing != null ? thing.getBlobPayload() : null;
    
    return null;
    }
    
    private int indexOfBlobNamed(String name) {
    	for(int i = 0; i< blob.size(); i++) {
			BlobPayloadItem item = blob.get(i);
			
			if(item.getName() != null && item.getName().equals(name) 
					|| name == null && item.getName() == null) {
				return i;
			}
		}
    	
    	return -1;
    }
}
