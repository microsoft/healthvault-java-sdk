package com.microsoft.healthvault.methods.getservicedefinition.response;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Order;

import java.util.ArrayList;
import java.util.Date;

@Default
public class GetServiceDefinitionResponseInfo {
    protected Platform platform;

    protected Shell shell;

    @ElementList(name = "xml-method", inline = true)
    protected ArrayList<XmlMethod> xmlMethod;

    @Element(name = "meaningful-use")
    protected MeaningfulUse meaningfulUse;

    @Element(name = "updated-date")
    protected Date updatedDate;

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Shell getShell() {
        return shell;
    }

    public void setShell(Shell shell) {
        this.shell = shell;
    }

    public ArrayList<XmlMethod> getXmlMethod() {
        return xmlMethod;
    }

    public void setXmlMethod(ArrayList<XmlMethod> xmlMethod) {
        this.xmlMethod = xmlMethod;
    }

    public MeaningfulUse getMeaningfulUse() {
        return meaningfulUse;
    }

    public void setMeaningfulUse(MeaningfulUse meaningfulUse) {
        this.meaningfulUse = meaningfulUse;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
