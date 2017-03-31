/*
 * Copyright 2011 Microsoft Corp.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
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
    
