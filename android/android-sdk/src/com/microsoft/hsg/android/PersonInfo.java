/*
 *  Copyright (c) Microsoft Corporation
 *
 *	All rights reserved. 
 *
 *	MIT License
 *	Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 *  and associated documentation files (the ""Software""), to deal in the Software without
 *  restriction, including without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 *  the Software is furnished to do so, subject to the following conditions:
 *
 *	The above copyright notice and this permission notice shall be included in all copies or
 *  substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 *  BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
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
