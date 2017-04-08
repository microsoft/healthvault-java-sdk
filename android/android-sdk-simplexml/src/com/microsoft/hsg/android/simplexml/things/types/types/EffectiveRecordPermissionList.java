package com.microsoft.hsg.android.simplexml.things.types.types;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.types"&gt;
 *                     A list of the effective permissions the calling application has for the
 *                     specified record.
 *                 &lt;/summary&gt;
 * </pre>
 * 
 * 
 * <p>Java class for EffectiveRecordPermissionList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EffectiveRecordPermissionList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="effective-record-permission" type="{urn:com.microsoft.wc.types}EffectiveRecordPermission" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "effective-record-permission"
})
public class EffectiveRecordPermissionList {

    @ElementList(required=true, inline = true, entry="effect-record-permission")
    protected ArrayList<EffectiveRecordPermission> effectiveRecordPermissionList;

    /**
     * Gets the value of the effectiveRecordPermission property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the object.
     * This is why there is not a <CODE>set</CODE> method for the effectiveRecordPermission property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEffectiveRecordPermission().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EffectiveRecordPermission }
     * 
     * 
     */
    public List<EffectiveRecordPermission> getEffectiveRecordPermissions() {
        if (effectiveRecordPermissionList == null) {
            effectiveRecordPermissionList = new ArrayList<EffectiveRecordPermission>();
        }
        return this.effectiveRecordPermissionList;
    }
}
