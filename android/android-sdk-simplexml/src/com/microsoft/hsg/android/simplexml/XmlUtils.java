package com.microsoft.hsg.android.simplexml;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


/**
 * The Class XmlUtils.
 */
public class XmlUtils {

    /**
     * Instantiates a new xml utils.
     */
    private XmlUtils() {}

    /**
     * Skip sub tree.
     * 
     * @param parser the parser
     * 
     * @throws XmlPullParserException the xml pull parser exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void skipSubTree(XmlPullParser parser)
        throws XmlPullParserException, IOException
    {
        parser.require(XmlPullParser.START_TAG, null, null);
        int level = 1;
        while (level > 0) {
            int eventType = parser.next();
            if (eventType == XmlPullParser.END_TAG) {
                --level;
            } else if (eventType == XmlPullParser.START_TAG) {
                ++level;
            }
        }
    }

    
    /**
     * Next start tag.
     * 
     * @param parser the parser
     * 
     * @throws XmlPullParserException the xml pull parser exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void nextStartTag(XmlPullParser parser)
        throws XmlPullParserException, IOException
    {
        if (parser.nextTag() != XmlPullParser.START_TAG) {
            throw new XmlPullParserException(
                "expected START_TAG but found: " + parser.getPositionDescription());
        }
    }

    /**
     * Next start tag.
     * 
     * @param parser the parser
     * @param name the name
     * 
     * @throws XmlPullParserException the xml pull parser exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void nextStartTag(XmlPullParser parser, String name)
        throws XmlPullParserException, IOException
    {
        parser.nextTag();
        parser.require(XmlPullParser.START_TAG, null, name);
    }

    /**
     * Next start tag.
     * 
     * @param parser the parser
     * @param namespace the namespace
     * @param name the name
     * 
     * @throws XmlPullParserException the xml pull parser exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void nextStartTag(XmlPullParser parser, String namespace, String name)
        throws XmlPullParserException, IOException
    {
        parser.nextTag();
        parser.require(XmlPullParser.START_TAG, namespace, name);
    }

    
    /**
     * Next text.
     * 
     * @param parser the parser
     * @param namespace the namespace
     * @param name the name
     * 
     * @return the string
     * 
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws XmlPullParserException the xml pull parser exception
     */
    public static String nextText(XmlPullParser parser, String namespace, String name)
        throws IOException, XmlPullParserException
    {
        if (name == null) {
            throw new XmlPullParserException("name for element can not be null");
        }
        
        parser.require(XmlPullParser.START_TAG, namespace, name);
        return parser.nextText();
    }

    /**
     * Call parser nextTag() and check that it is END_TAG, throw exception if not.
     * 
     * @param parser the parser
     * 
     * @throws XmlPullParserException the xml pull parser exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void nextEndTag(XmlPullParser parser) throws XmlPullParserException, IOException
    {
        if (parser.nextTag() != XmlPullParser.END_TAG) {
            throw new XmlPullParserException(
                "expected END_TAG and not"+parser.getPositionDescription());
        }
    }
}


