package com.microsoft.hsg;

import java.net.URI;
import java.net.URLEncoder;

public class ShellUrlBuilder {
    
    public static final String CREATE_RECORD = "CREATERECORD";
    public static final String AUTH = "AUTH";
    public static final String APP_AUTH = "APPAUTH";
    public static final String APP_SIGNOUT = "APPSIGNOUT";
    public static final String CONNECT = "CONNECT";
    public static final String CREATE_APPLICATION = "CREATEAPPLICATION";
    public static final String EDIT_RECORD = "EDITRECORD"; 
    public static final String HELP = "HELP";
    public static final String MANAGE_ACCOUNT = "MANAGEACCOUNT"; 
    public static final String PICKUP = "PICKUP"; 
    public static final String RECONCILE = "RECONCILE";
    public static final String RECORD_LIST = "RECORDLIST"; 
    public static final String SHARE_RECORD = "SHARERECORD";
    public static final String VIEW_ITEMS = "VIEWITEMS"; 

    private String target;
    private String targetqs;
    private String actionqs;
    private URI returnUrlOverride;
    private Boolean isMra;
    private Boolean allowInstanceBounce;
    private String appId;
    private String culture;
    private String extRecordId;
    private URI shellURI;
    
    public String getTarget() {
        return target;
    }
    
    public void setTarget(String target) {
        this.target = target;
    }

    public String getTargetqs() {
        return targetqs;
    }

    public void setTargetqs(String targetqs) {
        this.targetqs = targetqs;
    }

    public String getActionqs() {
        return actionqs;
    }

    public void setActionqs(String actionqs) {
        this.actionqs = actionqs;
    }

    public URI getReturnUrlOverride() {
        return returnUrlOverride;
    }

    public void setReturnUrlOverride(URI returnUrlOverride) {
        this.returnUrlOverride = returnUrlOverride;
    }

    public boolean isMra() {
        return this.isMra == null 
                ? false
                : isMra.booleanValue();
    }

    public void setMra(boolean isMra) {
        this.isMra = isMra;
    }

    public boolean isAllowInstanceBounce() {
        return this.allowInstanceBounce == null
                ? false
                : allowInstanceBounce.booleanValue();
    }

    public void setAllowInstanceBounce(boolean allowInstanceBounce) {
        this.allowInstanceBounce = allowInstanceBounce;
    }

    public String getAppId() {
        return appId;
    }


    public void setAppId(String appId) {
        this.appId = appId;
    }


    public String getCulture() {
        return culture;
    }


    public void setCulture(String culture) {
        this.culture = culture;
    }


    public String getExtRecordId() {
        return extRecordId;
    }


    public void setExtRecordId(String extRecordId) {
        this.extRecordId = extRecordId;
    }
    
    public URI getShellURI() {
        return shellURI;
    }

    public void setShellURI(URI shellURI) {
        this.shellURI = shellURI;
    }
    
    public void setShellInstance(String instanceId) {
        setShellURI(
            HVInstanceResolver
                .getInstanceResolver()
                .getInstanceForId(instanceId)
                .getShellUri());
    }

    private static void appendStringIf(
            StringBuilder buffer,
            String paramName,
            Object obj)
    {
        if (obj == null)
        {
            return;
        }
        
        appendStringIf(
            buffer,
            paramName,
            obj.toString());
    }
        
    private static void appendStringIf(
            StringBuilder buffer,
            String paramName,
            String s)
    {
        if (s == null)
        {
            return;
        }
        
        if(s.length() > 0)
        {
            buffer.append(paramName);
            buffer.append("=");
            buffer.append(s);
            buffer.append("&");
        }
    }
    
    public String toString() {
        StringBuilder targetqs = new StringBuilder();
        appendStringIf(targetqs, "appid", appId);
        appendStringIf(targetqs, "redirect", returnUrlOverride);
        appendStringIf(targetqs, "isMra", isMra);
        appendStringIf(targetqs, "aib", allowInstanceBounce);
        appendStringIf(targetqs, "culture", culture);
        appendStringIf(targetqs, "extRecordId", extRecordId);
        appendStringIf(targetqs, "actionqs", 
                actionqs == null
                ? null
                : URLEncoder.encode(actionqs));
        appendStringIf(targetqs, "trm", "post");
        
        if (targetqs != null)
        {
            targetqs.append(this.targetqs);
        }
        
        StringBuilder url = new StringBuilder();
        
        url.append("/redirect.aspx?target=");
        url.append(target);
        url.append("&targetqs=?");
        url.append(URLEncoder.encode(targetqs.toString()));
        
        URI uri = shellURI == null
                ? ApplicationConfig.HV_SHELL_URI
                : shellURI;
              
        return uri.resolve(url.toString()).toString();
    }
}
