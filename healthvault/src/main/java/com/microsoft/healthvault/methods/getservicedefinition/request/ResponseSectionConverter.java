package com.microsoft.healthvault.methods.getservicedefinition.request;


import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

public class ResponseSectionConverter implements Converter<ResponseSection>
{
    @Override
    public ResponseSection read(InputNode node) throws Exception
    {
        ResponseSection rtn = ResponseSection.fromValue(node.getNext().getValue());
        return rtn;
    }

    @Override
    public void write(OutputNode node, ResponseSection value) throws Exception
    {
        node.setValue(value.value());
    }
}