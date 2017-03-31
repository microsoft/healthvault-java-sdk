/*
 * Copyright 2011 Microsoft Corp.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.microsoft.hsg.android;

import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import com.microsoft.hsg.HVException;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonInfo.
 */
public class PersonInfo {

    /** The person id. */
    private String personId;
    
    /** The name. */
    private String name;
    
    /** The records. */
    private List<Record> records = new ArrayList<Record>();
    
    /**
     * Instantiates a new person info.
     * 
     * @param parser the parser
     */
    public PersonInfo(XmlPullParser parser) {
        try
        {
            int depth = parser.getDepth();
            while (parser.nextTag() == XmlPullParser.START_TAG
                    && depth < parser.getDepth()) {
                if ("person-id".equals(parser.getName())) {
                    personId = parser.nextText();
                } else if ("name".equals(parser.getName())) {
                    name = parser.nextText();
                } else if ("record".equals(parser.getName())) {
                    records.add(new Record(personId, parser));
                }
                    
                else
                {
                    XmlUtils.skipSubTree(parser);
                }
            }
        }
        catch(Exception e)
        {
            throw new HVException(e);
        }
    }
    
    /**
     * Gets the person id.
     * 
     * @return the person id
     */
    public String getPersonId() {
        return personId;
    }
    
    /**
     * Gets the records.
     * 
     * @return the records
     */
    public List<Record> getRecords() {
        return records;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return name;
    }
}
