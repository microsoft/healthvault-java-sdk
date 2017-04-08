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

package com.microsoft.hsg.android.demo.weight;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.microsoft.hsg.HVException;
import com.microsoft.hsg.android.simplexml.HealthVaultApp;
import com.microsoft.hsg.android.simplexml.ShellActivity;
import com.microsoft.hsg.android.simplexml.client.HealthVaultClient;
import com.microsoft.hsg.android.simplexml.client.RequestCallback;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.ThingRequestGroup2;
import com.microsoft.hsg.android.simplexml.methods.getthings3.response.ThingResponseGroup2;
import com.microsoft.hsg.android.simplexml.things.thing.Thing2;
import com.microsoft.hsg.android.simplexml.things.types.types.PersonInfo;
import com.microsoft.hsg.android.simplexml.things.types.types.Record;
import com.microsoft.hsg.android.simplexml.things.types.weight.Weight;

public class WeightActivity extends Activity {

	private HealthVaultApp service;
    private HealthVaultClient hvClient;
    private Record selectedRecord;
    
    public class WeightCallback<Object> implements RequestCallback {
    	public final static int UpdateWeights = 0;
    	public final static int PutWeights = 1;
    	public final static int UpdateRecords = 2;
    
    	private int event;
    	
    	public WeightCallback(int event) {
            WeightActivity.this.setProgressBarIndeterminateVisibility(true);
    		this.event = event;
    	}

        @Override
        public void onError(HVException exception) {
            WeightActivity.this.setProgressBarIndeterminateVisibility(false);
            Toast.makeText(
                WeightActivity.this, 
                "An error occurred.  " + exception.getMessage(), 
                Toast.LENGTH_LONG).show();
        }

		@Override
		public void onSuccess(java.lang.Object obj) {
            WeightActivity.this.setProgressBarIndeterminateVisibility(false);
            switch(event) {
            case PutWeights:
            	getWeights();
            	break;
            case UpdateWeights:
                updateWeights(((ThingResponseGroup2)obj).getThing());
                break;
            case UpdateRecords:
                updateRecords((List<Record>)obj);
                break;
            }
        }
    }
    
    private void updateWeights(List<Thing2> things) {
    	List<String> weights = new ArrayList<String>();
        for(Thing2 thing : things) {
        	Weight w = (Weight)thing.getData();
        	weights.add(String.valueOf(w.getValue().getKg()));	
        }
        ListView lv = (ListView)findViewById(R.id.weightList);
        lv.setAdapter(new ArrayAdapter<String>(
            WeightActivity.this,
            android.R.layout.simple_list_item_1,
            weights));    
    }
   
    private void updateRecords(List<Record> records) {
        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<Record> adapter = new ArrayAdapter<Record>(
            WeightActivity.this, 
            android.R.layout.simple_spinner_item,
            records);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }

    /**
     * Called when the activity is first created.
     * 
     * @param savedInstanceState the saved instance state
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.weight);
        service = HealthVaultApp.getInstance();
        hvClient = new HealthVaultClient();

        Button startAuth = (Button) findViewById(R.id.auth);
        startAuth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(ShellActivity.createAppAuthIntent(
                    WeightActivity.this, service.getAppId()));
            }
        });
        
        Button newApp = (Button) findViewById(R.id.newapp);
        newApp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                service.reset();
                Intent i = new Intent(WeightActivity.this, Welcome.class);
                startActivity(i);
                finish();
            }
        });
        
        Button putThing = (Button) findViewById(R.id.putThing);
        putThing.setOnClickListener(new View.OnClickListener() {
             public void onClick(View view) {
                EditText text = (EditText) findViewById(R.id.weightInput);
                putWeight(text.getText().toString());
             }
        });
        
        Spinner s = (Spinner) findViewById(R.id.spinner);
        s.setOnItemSelectedListener( new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                View view, int pos, long id) {
                selectedRecord = (Record)parent.getItemAtPosition(pos);
                getWeights();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }
    
 
	@Override
	protected void onStart() {
		hvClient.start();
		super.onStart();
	}   
    
    @Override
    protected void onResume()
    {
    	InitializeControls();
        super.onResume();
    }
    
    private void InitializeControls() {
    	getRecords();
    }
    
    private void getRecords() {
    	hvClient.asyncRequest(new Callable<List<Record>>() {
    		public List<Record> call() {
                ArrayList<Record> records = new ArrayList<Record>();
                List<PersonInfo> personInfos = service.getPersonInfoList();
                for (PersonInfo personInfo : personInfos) {
                    for (Record record : personInfo.getRecords()) {
                        records.add(record);
                    }
                }
                
                if (records.size() > 0) {
                    selectedRecord = records.get(0);
                }
                
                return records;
    		}
    	}, 
    	new WeightCallback(WeightCallback.UpdateRecords));
    }
    
    private void putWeight(String value) {
        final Thing2 thing = new Thing2();
		thing.setData(new Weight(Double.parseDouble(value)));
		hvClient.asyncRequest(
				selectedRecord.putThingAsync(thing),
				new WeightCallback(WeightCallback.PutWeights));
    }
    
    @SuppressWarnings("unchecked")
    private void getWeights()
    {
    	hvClient.asyncRequest(
    			selectedRecord.getThingsAsync(ThingRequestGroup2.thingTypeQuery(Weight.ThingType)),
    			new WeightCallback(WeightCallback.UpdateWeights));
    }        

    @Override
	protected void onStop() {
    	hvClient.stop();
		super.onStop();
	}
}
