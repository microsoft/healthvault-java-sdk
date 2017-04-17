package com.microsoft.hsg.android.hvsample;

import java.util.List;

import android.app.Activity;
import android.app.ListFragment;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.microsoft.hsg.android.simplexml.HealthVaultApp;
import com.microsoft.hsg.android.simplexml.client.HealthVaultClient;
import com.microsoft.hsg.android.simplexml.localvault.SynchronizedView;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.ThingRequestGroup2;
import com.microsoft.hsg.android.simplexml.store.SynchronizedViewLoader;
import com.microsoft.hsg.android.simplexml.things.types.types.Record;
import com.microsoft.hsg.android.simplexml.things.types.weight.Weight;

public class LocalVaultActivity extends Activity {
	private HealthVaultClient hvClient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		hvClient = new HealthVaultClient();
		setContentView(R.layout.activity_localvault);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new SimpleListFragment()).commit();
		}
	}

	public SynchronizedView getSynchronizedView() {
			Record currentRecord = HealthVaultApp.getInstance().getCurrentRecord();
			SynchronizedView syncView = SynchronizedView.getView(this, "weights", currentRecord);

			if (syncView == null) {
				ThingRequestGroup2 query = ThingRequestGroup2.thingTypeQuery(Weight.ThingType);
				query.setMax(300);
				
				syncView = SynchronizedView.makeView(
					this,
					currentRecord,
					"weights",
					query);
			}

			return syncView;
		}

	protected void onStart() {
		hvClient.start();
		super.onStart();
	}
	
	protected void onStop() {
		hvClient.stop();
		super.onStop();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_localvault, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.clear) {
			getSynchronizedView().delete();
			return true;
		}
	
		if (id == R.id.sync) {
			Record currentRecord = HealthVaultApp.getInstance().getCurrentRecord();
			SynchronizedView syncView = getSynchronizedView();
			if (syncView != null) {
                hvClient.asyncRequest(syncView.synchronizeAsync(), null);
			}
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}
	

	public static class SimpleListFragment extends ListFragment  
		implements LoaderCallbacks<List<String>>
	{  
		private HealthVaultClient hvClient = new HealthVaultClient();
		private SynchronizedView syncView;
		
        @Override  
        public void onListItemClick(ListView l, View v, int position, long id) {  
        }  

        @Override  
        public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {  
        	View v = super.onCreateView(inflater, container, savedInstanceState);  
        	//v.setBackgroundColor(Color.BLACK);
        	return v;	
        }

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			syncView = ((LocalVaultActivity)getActivity()).getSynchronizedView(); 

			setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1) {  
				@Override
				public View getView(int position, View convertView, ViewGroup parent) {
					View row;
			 
					if (null == convertView) {
				        LayoutInflater vi = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
						row = vi.inflate(android.R.layout.simple_list_item_1, parent, false);
					} else {
						row = convertView;
					}
			 
					TextView tv = (TextView) row.findViewById(android.R.id.text1);
					String id = getItem(position);
					Weight w = (Weight)syncView.getThingById(id);	

					if (w != null) {
						tv.setText(String.valueOf(w.getValue().getKg()));
					} else {
						tv.setText("...");
					}
			 
					return row;
				}
			});
 
            hvClient.start();
            hvClient.asyncRequest(
            		syncView.synchronizeAsync(),
            		null);

            getLoaderManager().initLoader(42, null, SimpleListFragment.this);
        }
		
		@Override
		public Loader<List<String>> onCreateLoader(int id, Bundle args) {
			return new SynchronizedViewLoader(getActivity(), syncView);
		}

		@Override
		public void onLoadFinished(Loader<List<String>> loader, List<String> things) {
	         ArrayAdapter adapter = (ArrayAdapter)this.getListAdapter();
	         adapter.clear();
	         adapter.addAll(things);
	         adapter.notifyDataSetChanged();
		}

		@Override
		public void onLoaderReset(Loader<List<String>> loader) {
	         ArrayAdapter adapter = (ArrayAdapter)this.getListAdapter();
	         adapter.clear();
		}
	} 
}
