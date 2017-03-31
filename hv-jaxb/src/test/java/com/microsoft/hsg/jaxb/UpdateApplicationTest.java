package com.microsoft.hsg.jaxb;

import org.apache.commons.codec.binary.Base64;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.methods.jaxb.SimpleRequestTemplate;
import com.microsoft.hsg.methods.jaxb.application.AppLargeLogoInfo;
import com.microsoft.hsg.methods.jaxb.application.CultureSpecificAppLargeLogo;
import com.microsoft.hsg.methods.jaxb.application.PublicKeys;
import com.microsoft.hsg.methods.jaxb.auth.Auth;
import com.microsoft.hsg.methods.jaxb.auth.AuthXml;
import com.microsoft.hsg.methods.jaxb.auth.Rule;
import com.microsoft.hsg.methods.jaxb.auth.Rules;
import com.microsoft.hsg.methods.jaxb.auth.Set;
import com.microsoft.hsg.methods.jaxb.updateapplication.request.UpdateApplicationRequest;
import com.microsoft.hsg.thing.oxm.jaxb.types.CultureSpecificString1024;
import com.microsoft.hsg.thing.oxm.jaxb.types.CultureSpecificString255;
import com.microsoft.hsg.thing.oxm.jaxb.types.CultureSpecificStringnz;
import com.microsoft.hsg.thing.oxm.jaxb.types.Permission;

@RunWith(JMock.class)
public class UpdateApplicationTest {
	
    private static String MasterAppId = "092da348-7845-4519-a174-fcc403915a30";
    private static String PublicKeyHexEncoded = "3082025b30820209a0030201020210b5524af99915d6b8439781d4cc765ba0300906052b0e03021d05003016311430120603550403130b526f6f74204167656e6379301e170d3037303731363138353934395a170d3339313233313233353935395a303a313830360603550403132f57696c646361744170702d62616662313331332d643465302d343231632d623362352d34653361353536333963313930820122300d06092a864886f70d01010105000382010f003082010a02820101009f8e3748b82926fe0443d980a9ca9d3d5470fc9a3234005ae75f665adad86724aa0a357c44a57049848a4ba1acef066f938f71627e63d7eda197831034e9da3d081d45d96834fb24a83bef90a7a19609560575e1917b6ccf40ca553703c0e6500443b08fb0e04c762963a227bdb936ef96fb59c15bc941a7e6a306337a3ba62f3753b6dfb367dbf26bb7840723fb28257b56fe3eee6c4136bd38d03f6d1d263ac973036a4f9ccd28db3c206c2d5a56be0791380c16a4bb70e7d6f0c5b2a2eb4d9119acf7f6af51ca349a189f2b932793796755856b2a84645b4bed300fa9de8a35c22347210ebd3fd7f60eb0a329e88e41989699c7f4dec8268028082b4633a70203010001a34b304930470603551d010440303e801012e4092d061d1d4f008d6121dc166463a1183016311430120603550403130b526f6f74204167656e6379821006376c00aa00648a11cfb8d4aa5c35f4300906052b0e03021d05000341003445577fa2f8b4f7fea2e3eba11d05808eee4b890d97e4c3991556da932c9cf7aa40630d6bccbc5347e3bc4b2296e97e9a929fd071511696a98b5fa41e970cd1";
    private static String LogoBase64 = "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";
    private static String ChildAppId = "8b31bf22-3a17-478c-9381-46d1fb8b4ef4";
    
	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};

	/**
     * Create the test case
     *
     */
    public UpdateApplicationTest()
    {
    }
    
    @Test
    public void UpdateApplication() throws Exception
    {
    	SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    		ConnectionFactory.getConnection(
    		    MasterAppId));
    	
    	UpdateApplicationRequest request = new UpdateApplicationRequest();
    	request.setId(ChildAppId);
    	request.getName()
    	    .add(new CultureSpecificString255("My Application"));
    	
    	PublicKeys keys = new PublicKeys();
    	keys.getPublicKey().add(PublicKeyHexEncoded);
    	request.setPublicKeys(keys);
    	
    	Set thingTypes = new Set();
    	thingTypes.getTypeId().add("3d34d87e-7fc1-4153-800f-f56592cb0d17"); 
    	
        Rule rule = new Rule();
        rule.setName("default");
        rule.getReason().add(
                new CultureSpecificString1024("Required Access"));
        rule.getPermission().add(Permission.ALL);
        rule.getTargetSet().add(thingTypes);
        
        Rules rules = new Rules();
        rules.getRule().add(rule);
        
        Auth auth = new Auth();
        auth.setRules(rules);
        
        AuthXml authXml = new AuthXml();
        authXml.setAuth(auth);
        
    	request.setPersonOnlineBaseAuth(authXml);
    	request.setPersonOfflineBaseAuth(authXml);
    	
    	request.setMethods("GetThings, PutThings");
    	request.setActionUrl("https://contoso.com/myendpoint");
    	request.getDescription().add(
    	    new CultureSpecificStringnz("Test Child App--unit test"));
    	request.getAuthReason().add(
    	    new CultureSpecificStringnz("Authorization Reason Here"));
    	request.setDomainName("contoso.com");
    	
    	AppLargeLogoInfo largeLogoInfo = new AppLargeLogoInfo();
        CultureSpecificAppLargeLogo largeLogo = new CultureSpecificAppLargeLogo();
        largeLogo.setValue(Base64.decodeBase64(LogoBase64.getBytes("ASCII")));
    	largeLogoInfo.getLogo().add(largeLogo);
    	largeLogoInfo.setContentType("image/png");
    	
    	request.setLargeLogo(largeLogoInfo);
        
    	requestTemplate.makeRequest(request);
    }
}
