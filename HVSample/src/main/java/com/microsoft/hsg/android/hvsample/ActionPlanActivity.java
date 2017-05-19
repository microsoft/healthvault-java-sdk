package com.microsoft.hsg.android.hvsample;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.microsoft.hsg.Connection;
import com.microsoft.hsg.HVException;
import com.microsoft.hsg.android.simplexml.HealthVaultApp;
import com.microsoft.hsg.android.simplexml.HealthVaultSettings;
import com.microsoft.hsg.android.simplexml.ShellActivity;
import com.microsoft.hsg.android.simplexml.client.HealthVaultClient;
import com.microsoft.hsg.android.simplexml.client.HealthVaultRestClient;
import com.microsoft.hsg.android.simplexml.client.RequestCallback;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.ThingRequestGroup2;
import com.microsoft.hsg.android.simplexml.methods.getthings3.response.ThingResponseGroup2;
import com.microsoft.hsg.android.simplexml.things.thing.Thing2;
import com.microsoft.hsg.android.simplexml.things.types.types.PersonInfo;
import com.microsoft.hsg.android.simplexml.things.types.types.Record;
import com.microsoft.hsg.android.simplexml.things.types.weight.Weight;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import healthvault.client.implementation.MicrosoftHealthVaultRestApiImpl;
import healthvault.client.models.ActionPlan;
import healthvault.client.models.ActionPlansResponseActionPlanInstance;

import healthvault.client.models.Objective;
import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Subscriber;
import rx.Subscription;
import rx.schedulers.Schedulers;

public class ActionPlanActivity  extends Activity {
	private HealthVaultApp service;
	private HealthVaultClient hvClient;
	private Record currentRecord;
	private static ActionPlansResponseActionPlanInstance actionPlanInstance;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_actionplan);
		service = HealthVaultApp.getInstance();
		hvClient = new HealthVaultClient();

		if (service.isAppConnected()) {
			currentRecord = HealthVaultApp.getInstance().getCurrentRecord();
			getActionPlan();
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		hvClient.start();
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		currentRecord = HealthVaultApp.getInstance().getCurrentRecord();
		getActionPlan();
	}

	@Override
	protected void onStop() {
		hvClient.stop();
		super.onStop();
	}

	@SuppressWarnings("unchecked")
	private void getActionPlan(){
		service.getSettings().setRestUrl("https://data.ppe.microsofthealth.net/");
		HealthVaultSettings settings = service.getSettings();
		Connection connection = service.getConnection();

		final MicrosoftHealthVaultRestApiImpl restClient = new HealthVaultRestClient(settings, connection, currentRecord).getInstance();

		restClient.getActionPlansAsync()
				.subscribeOn(Schedulers.io())
				.observeOn(Schedulers.newThread())
				.subscribe(new Subscriber<Object>() {
					@Override
					public final void onCompleted() {
					}

					@Override
					public final void onError(final Throwable e) {
						Log.e("error", e.getMessage());
					}

					@Override
					public final void onNext(final Object response) {
						actionPlanInstance = (ActionPlansResponseActionPlanInstance) response;
					}
				});
		renderActionPlans();
	}

	private void renderActionPlans() {
		List<String> actionplans = new ArrayList<String>();
		if (actionPlanInstance != null) {
			int size = actionPlanInstance.plans().size();
			for (int index = 0; index < size; ++index) {
				actionplans.add("Plan: " + actionPlanInstance.plans().get(index).name().toString() +
						"     Category:" + actionPlanInstance.plans().get(index).category().toString());
			}
			ListView lv = (ListView) findViewById(R.id.actionPlanList);
			lv.setAdapter(new ArrayAdapter<String>(
					ActionPlanActivity.this,
					android.R.layout.simple_list_item_1,
					actionplans));
		}
		else {
			Toast.makeText(
					ActionPlanActivity.this,
					"No Action plans!",
					Toast.LENGTH_SHORT).show();
		}
	}
}
