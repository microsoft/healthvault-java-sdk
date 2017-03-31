/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

import java.security.PrivateKey;
import java.security.Signature;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.codec.binary.Base64;
import org.xml.sax.InputSource;


/**
 * ApplicationAuthenticator authenticates a connection
 * for an application with a certificate.  When the connection
 * requests it, retrieve an authenticated session token from
 * HealthVault. 
 */
public class ApplicationAuthenticator implements Authenticator
{
	private String appId;
	private SharedSecretGenerator sharedSecretGenerator;
	private byte[] sharedSecret;
	private String sessionToken;
	private PrivateKey privateKey;
	private String thumbprint;
	private PrivateKeyStore keyStore;
	private HVAccessor accessor;
	
	/**
	 * Instantiates a new application authenticator.
	 */
	public ApplicationAuthenticator()
	{
		accessor = new HVAccessor();
		accessor.setSendStrategy(new SimpleSendStrategy());
	}
	
	/**
	 * Gets the session token.
	 * 
	 * @return the session token
	 */
	public String getSessionToken()
	{
		return sessionToken;
	}

	/**
	 * Gets the shared secret generator.
	 * 
	 * @return the shared secret generator
	 */
	public SharedSecretGenerator getSharedSecretGenerator()
	{
		return sharedSecretGenerator;
	}

	/**
	 * Sets the shared secret generator.
	 * 
	 * @param sharedSecretGenerator the new shared secret generator
	 */
	public void setSharedSecretGenerator(SharedSecretGenerator sharedSecretGenerator)
	{
		this.sharedSecretGenerator = sharedSecretGenerator;
	}

	/**
	 * Gets the app id.
	 * 
	 * @return the app id
	 */
	public String getAppId()
	{
		return appId;
	}

	/**
	 * Sets the app id.
	 * 
	 * @param appId the new app id
	 */
	public void setAppId(String appId)
	{
		this.appId = appId;
	}
	/**
	 * Gets the key store.
	 * 
	 * @return the key store
	 */
	public PrivateKeyStore getKeyStore()
	{
		return keyStore;
	}

	/**
	 * Sets the key store.
	 * 
	 * @param keyStore the new key store
	 */
	public void setKeyStore(PrivateKeyStore keyStore)
	{
		this.keyStore = keyStore;
	}

	/* (non-Javadoc)
	 * @see com.microsoft.hsg.Authenticator#authenticate(com.microsoft.hsg.Connection, boolean)
	 */
	public synchronized void authenticate(Connection connection, boolean force)
	{
		connection.setAppId(appId);
		
		if( !force &&
			sharedSecret != null &&
			sessionToken != null  )
		{
			connection.setSharedSecret(sharedSecret);
			connection.setSessionToken(sessionToken);
		}
		else
		{
			authenticate(connection);
		}
	}
	
	private  void authenticate(Connection connection)
	{
	
		ensurePrivateKey();
		
		connection.setSharedSecret(null);
		connection.setSessionToken(null);
		sharedSecret = sharedSecretGenerator.generateSharedSecret();
		Request castRequest = createAuthenticatedSessionTokenRequest(sharedSecret);
		accessor.send(castRequest, connection);
		Response response = accessor.getResponse();
		
		try
		{
	        XPath xpath = XPathFactory.newInstance().newXPath();
	        String exp = "//token";
	        sessionToken = xpath.evaluate(exp, new InputSource(response.getInputStream()));
		}
		catch(Exception e)
		{
			throw new HVSystemException("XPath failed to get token", e);
		}
		
        if (sessionToken == null)
        {
        	throw new HVSystemException( "Application session token not found");
        }
        
        connection.setSessionToken(sessionToken);
        connection.setSharedSecret(sharedSecret);
	
    }

	private Request createAuthenticatedSessionTokenRequest(
			byte[] sharedSecret) 
    {
		try 
		{
	        StringBuffer contentBuilder = new StringBuffer();
	        contentBuilder.append("<content><app-id>");
	        contentBuilder.append(appId);
	        contentBuilder.append("</app-id><shared-secret><hmac-alg algName=\"HMACSHA1\">");
	        contentBuilder.append(new String(Base64.encodeBase64(sharedSecret)));
	        contentBuilder.append("</hmac-alg></shared-secret></content>");
	        String content = contentBuilder.toString();
	          
	        StringBuffer infoBuilder = new StringBuffer();
	        infoBuilder.append("<info><auth-info><app-id>");
	        infoBuilder.append(appId);
	        infoBuilder.append("</app-id><credential><appserver><sig digestMethod=\"SHA1\" sigMethod=\"RSA-SHA1\" thumbprint=\"");
	        infoBuilder.append(thumbprint);
	        infoBuilder.append("\">");
	        infoBuilder.append(new String(Base64.encodeBase64(signContent(content.getBytes("UTF-8")))));
	        infoBuilder.append("</sig>");
	        infoBuilder.append(content);
	        infoBuilder.append("</appserver></credential></auth-info></info>");
	        
	        //TODO: create CASTRequest extends Request to include specific details
	    	Request castRequest = new Request();
	    	castRequest.setMethodName("CreateAuthenticatedSessionToken");
	    	castRequest.setInfo(infoBuilder.toString());
	    	
	    	return castRequest;
		}
		catch(Exception e)
		{
			throw new HVSystemException("Could not build CAST request", e);
		}
    }
	
	private byte[] signContent(byte[] content) 
    {
		try
		{
	        Signature dsa = Signature.getInstance("SHA1withRSA");
	        dsa.initSign(privateKey);
	        dsa.update(content);
	        return dsa.sign();
		} catch (Exception e)
		{
			throw new HVSystemException("Could not sign request", e);
		}
    }
	
    private void ensurePrivateKey()
    {
    	if (keyStore == null)
    	{
    		throw new HVSystemException("KeyStore not set on Authenticator");
    	}
    	
    	privateKey = keyStore.getPrivateKey();
    	thumbprint = keyStore.getThumbprint();
    }
}
