package com.microsoft.hsg;

import java.net.URI;

public class HVInstance {

    private String id;
    private String name;
    private String description;
    private URI shellUri;
    private URI platformUri;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public URI getShellUri() {
        return shellUri;
    }
    
    public void setShellUri(URI shellUri) {
        this.shellUri = shellUri;
    }
    
    public URI getPlatformUri() {
        return platformUri;
    }
    
    public void setPlatformUri(URI platformUri) {
        this.platformUri = platformUri;
    }
}
