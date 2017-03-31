package com.microsoft.hsg.android.simplexml.methods.getauthorizedpeople.response;

import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.Order;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.core.Commit;

import com.microsoft.hsg.android.simplexml.things.types.types.PersonInfo;
import com.microsoft.hsg.android.simplexml.things.types.types.Record;


/**
 * <p>Java class for GetAuthorizedPeopleResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetAuthorizedPeopleResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="person-info" type="{urn:com.microsoft.wc.types}PersonInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="more-results" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@Order(elements = {
    "person-info",
    "more-results"
})
public class GetAuthorizedPeopleResponseResults {

    @ElementList(required=false, inline = true, entry="person-info")
    protected ArrayList<PersonInfo> personInfo;

    @Element(name = "more-results", required=false)
    protected boolean moreResults;

    /**
     * Gets the value of the personInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the object.
     * This is why there is not a <CODE>set</CODE> method for the personInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonInfo }
     * 
     * 
     */
    public List<PersonInfo> getPersonInfoList() {
        if (personInfo == null) {
            personInfo = new ArrayList<PersonInfo>();
        }
        return this.personInfo;
    }

    /**
     * Gets the value of the moreResults property.
     * 
     */
    public boolean isMoreResults() {
        return moreResults;
    }
    
    /**
     * Sets the value of the moreResults property.
     * 
     */
    public void setMoreResults(boolean value) {
        this.moreResults = value;
    }

    @Commit
    private void FixupRecordPersonIds() {
    	for (PersonInfo pi : getPersonInfoList()) {
    		String personId = pi.getPersonId();
    		
    		for (Record r : pi.getRecords()) {
    			r.setPersonId(personId);
    		}
    	}
    }
}
