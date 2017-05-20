package com.microsoft.hsg.android.hvsample;

import com.microsoft.hsg.android.simplexml.HealthVaultApp;
import com.microsoft.hsg.android.simplexml.client.HealthVaultClient;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RecordPickerActivity extends ListActivity {
	
	private HealthVaultClient mClient;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recordpicker);

		mClient = new HealthVaultClient();

		RecordPickerArrayAdapter adapter =
				new RecordPickerArrayAdapter(this,
						HealthVaultApp.getInstance().getRecordList(),
						mClient);

		setListAdapter(adapter);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		mClient.start();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onStop() {
		mClient.stop();
		super.onStop();
	}
}
