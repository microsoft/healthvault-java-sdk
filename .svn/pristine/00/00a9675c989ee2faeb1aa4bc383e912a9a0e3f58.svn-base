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
package com.microsoft.hsg.android.demo.weight;

import java.util.Calendar;

import org.xmlpull.v1.XmlPullParser;

import com.microsoft.hsg.HVException;
import com.microsoft.hsg.android.XmlUtils;

public class Weight {

    public static String TYPE = "3d34d87e-7fc1-4153-800f-f56592cb0d17";
    
    private Calendar calendar;
    private double value;
    
    public Weight(double value)
    {
        calendar = Calendar.getInstance();
        this.value = value;
    }
    
    public double getValue() {
        return value;
    }
    
    public String toXml()
    {    
        StringBuilder infoBuilder = new StringBuilder(256);
        infoBuilder.append("<weight><when><date><y>");
        infoBuilder.append(calendar.get(Calendar.YEAR));
        infoBuilder.append("</y><m>");
        infoBuilder.append(calendar.get(Calendar.MONTH) + 1);
        infoBuilder.append("</m><d>");
        infoBuilder.append(calendar.get(Calendar.DATE));
        infoBuilder.append("</d></date><time><h>");
        infoBuilder.append(calendar.get(Calendar.HOUR_OF_DAY));
        infoBuilder.append("</h><m>");
        infoBuilder.append(calendar.get(Calendar.MINUTE));
        infoBuilder.append("</m><s>");
        infoBuilder.append(calendar.get(Calendar.SECOND));
        infoBuilder.append("</s></time></when><value><kg>");
        infoBuilder.append(value);
        infoBuilder.append("</kg><display units=\"lb\" units-code=\"lb\">");
        infoBuilder.append(value);
        infoBuilder.append("</display></value></weight>");
        
        return infoBuilder.toString();
    }
    
    public static Weight createFromXml(XmlPullParser parser) throws Exception
    {
        String value = "";
        int depth = parser.getDepth();
        while (parser.nextTag() == XmlPullParser.START_TAG
            && parser.getDepth() > depth) {
            if ("value".equals(parser.getName())) {
                int valueDepth = parser.getDepth();
                while (parser.nextTag() == XmlPullParser.START_TAG
                        && parser.getDepth() > valueDepth) {
                    if ("kg".equals(parser.getName())) {
                        value = parser.nextText();
                    }
                    else {
                        XmlUtils.skipSubTree(parser);
                    }
                }
            }
            else {
                XmlUtils.skipSubTree(parser);
            }
        }
        
        return new Weight(Double.parseDouble(value));
    }
}
