/*
 *  Copyright (c) Microsoft Corporation
 *
 *	All rights reserved. 
 *
 *	MIT License
 *	Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 *  and associated documentation files (the ""Software""), to deal in the Software without
 *  restriction, including without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom
 *  the Software is furnished to do so, subject to the following conditions:
 *
 *	The above copyright notice and this permission notice shall be included in all copies or
 *  substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 *  BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.microsoft.hsg.applications.weight;

import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.util.value.ValueMap;

import com.microsoft.hsg.ConnectionFactory;

/**
 * Homepage
 */
public class WeightPage extends WebPage {
	
	private static final String WeightType = "3d34d87e-7fc1-4153-800f-f56592cb0d17";
	private ListView thingList;
	
	public WeightPage(final PageParameters parameters) {
		add(new BookmarkablePageLink("signoff", SignOff.class));
        add(new Label("message", "Enter weight data"));
		add(new WeightForm("weight"));
		
		//Add weights
		List<WeightInfo> weightList = getWeights();	
		thingList = new ListView("weightList", weightList) {
			protected void populateItem(ListItem item) {
				WeightInfo wi = (WeightInfo)item.getModelObject();
				item.add(new Label("id", wi.getId()));
				item.add(new Label("weight", wi.getValue()));
			}
		};
		add(thingList);
    }
	
	private List<WeightInfo> getWeights()
	{
		WeightDAO dao = new WeightDAO(ConnectionFactory.getConnection());
		return dao.getWeights();
	}
  
    private final class WeightForm extends Form
    {	
   	
    	public WeightForm(String id)
        {
    		super(id, new CompoundPropertyModel(new ValueMap()));
    		add(new TextField("value"));
        }
    	
    	protected void onSubmit()
    	{
	    	ValueMap map = (ValueMap)getModelObject();
    		String weightInput = (String)map.get("value");
    		
    		WeightInfo wi = new WeightInfo();
    		wi.setValue(weightInput);
    		WeightDAO dao = new WeightDAO(ConnectionFactory.getConnection());
    		dao.putWeight(wi);
    		thingList.setList(getWeights());
    	}
    }
}  
    
