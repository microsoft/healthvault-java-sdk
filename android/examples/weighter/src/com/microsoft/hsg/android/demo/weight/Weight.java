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
