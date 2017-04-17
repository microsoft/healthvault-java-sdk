package com.microsoft.hsg.android.simplexml;

import org.simpleframework.xml.convert.Converter;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Visitor;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;

import android.util.Log;

public class SimpleXMLStringConverter implements Converter<String> {

		@Override
		public String read(InputNode node) throws Exception {
			String value = node.getValue();
				if(value == null) {
					value = "";
				}
				return value;
		}

		@Override
		public void write(OutputNode node, String value) throws Exception {
			node.setValue(value);
		}
}
