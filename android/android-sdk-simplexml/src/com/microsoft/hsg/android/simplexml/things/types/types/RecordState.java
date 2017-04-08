package com.microsoft.hsg.android.simplexml.things.types.types;

/**
 * <p>Java class for RecordState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RecordState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="ReadOnly"/>
 *     &lt;enumeration value="Suspended"/>
 *     &lt;enumeration value="Deleted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
public enum RecordState {
    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.types"&gt;
     *                             The authorization is active and the authenticated
     *                             person can access the record with as much rights
     *                             as was granted to the person.
     *                         &lt;/summary&gt;
     * </pre>
     * 
     * 
     */
    Active,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.types"&gt;
     *                             The authorization is in question and the
     *                             authenticated person can read data in the record
     *                             but cannot write to the record even if they 
     *                             were previously granted write privileges.
     *                         &lt;/summary&gt;
     * </pre>
     * 
     * 
     */
    ReadOnly,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.types"&gt;
     *                             The authorization was used in a fraudulent manor
     *                             and can no longer be used.
     *                         &lt;/summary&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.types"&gt;
     *                             In most cases attempts to use a suspended record
     *                             will result in INVALID_RECORD_STATE being returned
     *                             from the method.
     *                         &lt;/remarks&gt;
     * </pre>
     * 
     * 
     */
    Suspended,

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;summary xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.types"&gt;
     *                             The record authorization has been deleted and can
     *                             no longer be used to access the record.
     *                         &lt;/summary&gt;
     * </pre>
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;remarks xmlns="http://www.w3.org/2001/XMLSchema" xmlns:this="urn:com.microsoft.wc.types"&gt;
     *                             In most cases attempts to use a deleted record
     *                             will result in INVALID_RECORD_STATE being returned
     *                             from the method.
     *                         &lt;/remarks&gt;
     * </pre>
     * 
     * 
     */
    Deleted
}
