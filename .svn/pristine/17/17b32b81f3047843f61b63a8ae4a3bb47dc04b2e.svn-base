package com.microsoft.hsg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.microsoft.hsg.request.RequestMarshaller;
import com.microsoft.hsg.request.SimpleRequestTemplate;

public class PutThingsTest {
    
    public static final String WeightType = "3d34d87e-7fc1-4153-800f-f56592cb0d17";
    public static final String PersonalImageType = "a5294488-f865-4ce3-92fa-187cd3b58930";
    
    @Test
    public void UpdateWeightTest()
    {
        Calendar calendar = Calendar.getInstance();
        
        ThingId version = getLatestVersion(WeightType);
        
        StringBuilder infoBuilder = new StringBuilder(256);
        infoBuilder.append("<info><thing>");
        infoBuilder.append("<thing-id version-stamp=\"");
        infoBuilder.append(version.Version);
        infoBuilder.append("\">" + version.Id + "</thing-id>");
        infoBuilder.append("<type-id>");
        infoBuilder.append(WeightType);
        infoBuilder.append("</type-id><data-xml><weight><when><date><y>");
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
        infoBuilder.append("38");
        infoBuilder.append("</kg><display units=\"lb\" units-code=\"lb\">");
        infoBuilder.append(String.valueOf(38*2.2));
        infoBuilder.append("</display></value></weight>");
        infoBuilder.append("<common/></data-xml></thing></info>");
        
        Request request = new Request();
        request.setMethodName("PutThings");
        request.setInfo(infoBuilder.toString());
        
        SimpleRequestTemplate template = new SimpleRequestTemplate(
            ConnectionFactory.getConnection(),
            "75ac2c6c-c90e-4f7e-b74d-bb7e81787beb",
            "8c390004-3d41-4f5c-8f24-4841651579d6"
        );
        template.makeRequest(request);
    }
    
    @Test
    public void UpdatePersonalImageTest()
    {   
        ThingId version = getLatestVersion(PersonalImageType);
        
        StringBuilder infoBuilder = new StringBuilder(256);
        infoBuilder.append("<info><thing>");
        infoBuilder.append("<thing-id version-stamp=\"");
        infoBuilder.append(version.Version);
        infoBuilder.append("\">" + version.Id + "</thing-id>");
        infoBuilder.append("<type-id>");
        infoBuilder.append(PersonalImageType);
        infoBuilder.append("</type-id>");
        infoBuilder.append("<data-xml><personal-image/><common/></data-xml></thing></info>");
        
        Request request = new Request();
        request.setMethodName("PutThings");
        request.setInfo(infoBuilder.toString());
        
        SimpleRequestTemplate template = new SimpleRequestTemplate(
            ConnectionFactory.getConnection(),
            "75ac2c6c-c90e-4f7e-b74d-bb7e81787beb",
            "8c390004-3d41-4f5c-8f24-4841651579d6"
        );
        template.makeRequest(request);
    }
    
    private ThingId getLatestVersion(String type) {
        Request request = new Request();
        request.setMethodName("GetThings");
        request.setInfo(
            "<info><group max=\"30\">" +
            "<filter><type-id>" + type + "</type-id></filter>" +
            "<format><section>core</section><xml/></format></group></info>");
        
        SimpleRequestTemplate template = new SimpleRequestTemplate(
                ConnectionFactory.getConnection(),
                "75ac2c6c-c90e-4f7e-b74d-bb7e81787beb",
                "8c390004-3d41-4f5c-8f24-4841651579d6"
            );
        
        return (ThingId)template.makeRequest(request, new RequestMarshaller() {
            public Object marshal(InputStream istream) throws Exception {
                InputSource isource = new InputSource(istream);
                XPath xpath = XPathFactory.newInstance().newXPath();
                String exp = "//thing";
                NodeList things = (NodeList)xpath.evaluate(exp,
                        isource,
                        XPathConstants.NODESET);  
                
                Node thing = things.item(0);
                  
                ThingId t = new ThingId();
                t.Id = xpath.evaluate("thing-id/text()", thing);
                t.Version = xpath.evaluate("thing-id/@version-stamp", thing);
                       
                return t;
            }
        });       
    }
    
    private class ThingId
    {
        public String Id;
        public String Version;
    }
    
    @Test
    public void PutCCDTest() throws Exception {
    	InputStream in = getClass().getResourceAsStream("/TestCCD.txt");
    	String rawCCD = streamToString(in);
    	
    	StringBuilder infoBuilder = new StringBuilder(256);
        infoBuilder.append("<info><thing>");
        infoBuilder.append("<type-id>9c48a2b8-952c-4f5a-935d-f3292326bf54</type-id>");
        infoBuilder.append("<data-xml>");
        infoBuilder.append(rawCCD);
        infoBuilder.append("</data-xml></thing></info>");
        
        Request request = new Request();
    	request.setMethodName("PutThings");
        request.setInfo(infoBuilder.toString());
        
        SimpleRequestTemplate template = new SimpleRequestTemplate(
            ConnectionFactory.getConnection(),
            "75ac2c6c-c90e-4f7e-b74d-bb7e81787beb",
            "8c390004-3d41-4f5c-8f24-4841651579d6"
        );
        template.makeRequest(request); 
    }
    
    private String streamToString(InputStream in) throws IOException {
    	StringBuilder out = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(in));
    	
    	for(String line = br.readLine(); line != null; line = br.readLine()) {
    		out.append(line);
    	}
    	br.close();
    	
    	return out.toString();
    }
}
