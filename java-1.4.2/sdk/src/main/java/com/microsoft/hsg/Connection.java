/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg;

import java.io.InputStream;
import java.security.MessageDigest;
import java.util.GregorianCalendar;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.time.DateFormatUtils;

/**
 * The connection serves as the main pipe to HealthVault.  It
 * formats requests into a HealthVault envelope ensuring any
 * security handshakes occur properly.  It uses underlying 
 * Transport and Authenticator classes to help.
 */
public class Connection 
{
    private byte[] sharedSecret;
    private String sessionToken; 
    private String appId;
    private Transport transport;
    private Authenticator authenticator;

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
	 * Gets the authenticator.
	 * 
	 * @return the authenticator
	 */
	public Authenticator getAuthenticator()
	{
		return authenticator;
	}

	/**
	 * Sets the authenticator.
	 * 
	 * @param authenticator the new authenticator
	 */
	public void setAuthenticator(Authenticator authenticator)
	{
		this.authenticator = authenticator;
	}

	/**
	 * Gets the shared secret.
	 * 
	 * @return the shared secret
	 */
	public byte[] getSharedSecret() {
		return sharedSecret;
	}

	/**
	 * Sets the shared secret.
	 * 
	 * @param sharedSecret the new shared secret
	 */
	public void setSharedSecret(byte[] sharedSecret) {
		this.sharedSecret = sharedSecret;
	}	
	/**
	 * Gets the transport.
	 * 
	 * @return the transport
	 */
	public Transport getTransport()
	{
		return transport;
	}

	/**
	 * Sets the transport.
	 * 
	 * @param transport the new transport
	 */
	public void setTransport(Transport transport)
	{
		this.transport = transport;
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
     * Sets the session token.
     * 
     * @param sessionToken the new session token
     */
    public void setSessionToken(String sessionToken)
    {
        this.sessionToken = sessionToken;
    }

    /**
     * Send.
     * 
     * @param request the request
     * 
     * @return the input stream
     */
    public void send(Request request, ResponseHandler responseHandler) 
    {
    	try
    	{
			String requestString = buildRequestString(request);
    		makeRequest(requestString, responseHandler);
    	}
    	catch(HVException hve)
    	{
    		throw hve;
    	}
    	catch (Exception e)
    	{
    		throw new HVSystemException("Could not make request", e);
    	}
    }
    
    /**
     * Authenticate.
     * 
     * @param force the force
     */
    public void authenticate(boolean force)
    {
    	if (authenticator != null)
    	{
        	authenticator.authenticate(this, force);
    	}
    }
    
    /**
     * Authenticate.
     */
    public void authenticate()
    {
    	authenticate(false);
    }

    private void makeRequest(String request, ResponseHandler responseHandler) 
    {
    	transport.doRequest(request, responseHandler);
    }

    private String buildHeader(Request request) throws Exception
    {
        StringBuffer sb = new StringBuffer();
        sb.append("<header><method>");
        sb.append(request.getMethodName());
        sb.append("</method><method-version>");
        sb.append(request.getMethodVersion());
        sb.append("</method-version>");
        if (request.getRecordId() != null) 
        {
            sb.append("<record-id>");
            sb.append(request.getRecordId());
            sb.append("</record-id>");
        }
        
        if (sessionToken != null)
        {
            sb.append("<auth-session><auth-token>");
            sb.append(sessionToken);
            sb.append("</auth-token>");
    
            if (request.getUserAuthToken() != null)
            {
                sb.append("<user-auth-token>");
                sb.append(request.getUserAuthToken());
                sb.append("</user-auth-token>");
            }
            else if (request.getOfflineUserId() != null)
        	{
        		sb.append("<offline-person-info><offline-person-id>");
        		sb.append(request.getOfflineUserId());
        		sb.append("</offline-person-id></offline-person-info>");
        	}
           
            sb.append("</auth-session>");
        }
        else
        {
        	sb.append("<app-id>");
        	sb.append(appId);
        	sb.append("</app-id>");
        }
        
        sb.append("<language>en</language><country>US</country><msg-time>");
        sb.append(DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(new GregorianCalendar()));
        sb.append("</msg-time><msg-ttl>");
        sb.append(request.getTtl());
        sb.append("</msg-ttl><version>Java/1.3 JDK-1.4.2</version>");
        
        if (sessionToken != null)
        {
        	sb.append("<info-hash><hash-data algName=\"SHA1\">");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            // TODO: avoid getting Bytes twice, here + later
            md.update(request.getInfo().getBytes("UTF-8"));
            byte[] result = md.digest();       
            sb.append(new String(Base64.encodeBase64(result)));
            sb.append("</hash-data></info-hash>");
        }
        sb.append("</header>"); 
        
        return sb.toString();
    } 

    private String buildRequestString(Request request) throws Exception
    {
    	String header = buildHeader(request);   
        
        StringBuffer sb = new StringBuffer();
        sb.append("<wc-request:request xmlns:wc-request=\"urn:com.microsoft.wc.request\">");
        if (sessionToken != null)
        {
        	SecretKeySpec sks = new SecretKeySpec(sharedSecret, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(sks);
                     
            byte[] result = mac.doFinal(header.getBytes("UTF-8"));
        	sb.append("<auth><hmac-data algName=\"HMACSHA1\">");
        	sb.append(new String(Base64.encodeBase64(result)));
        	sb.append("</hmac-data></auth>");
        }
        sb.append(header);
        sb.append(request.getInfo());
        sb.append("</wc-request:request>");
        
        return sb.toString();
    }
}

