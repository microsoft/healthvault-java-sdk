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

package com.microsoft.hsg.android.simplexml;

import java.net.URLEncoder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.microsoft.hsg.Connection;
import com.microsoft.hsg.HVInstance;
import com.microsoft.hsg.HVInstanceResolver;
import com.microsoft.hsg.android.simplexml.HealthVaultApp.ConnectionStatus;
import com.microsoft.hsg.android.simplexml.methods.getauthorizedpeople.request.GetAuthorizedPeopleParameters;
import com.microsoft.hsg.android.simplexml.methods.getauthorizedpeople.request.GetAuthorizedPeopleRequest;
import com.microsoft.hsg.android.simplexml.methods.getauthorizedpeople.response.GetAuthorizedPeopleResponse;
import com.microsoft.hsg.android.simplexml.methods.request.RequestTemplate;

// TODO: Auto-generated Javadoc
/**
 * The Class ShellActivity.
 */
public class ShellActivity extends Activity {

	/** The web view. */
	private WebView webView;

	/**
	 * Creates the app auth intent.
	 *
	 * @param ctx the ctx
	 * @param appId the app id
	 *
	 * @return the intent
	 */
	public static Intent createAppAuthIntent(Activity ctx, String appId) {
		String queryString =
			HealthVaultApp.getInstance().getSettings().getShellUrl()
			 + "/redirect.aspx?target=APPAUTH&targetqs="
			 + "?appid=" + appId;

		Intent intent = new Intent(ctx, ShellActivity.class);
		intent.putExtra("url", queryString);

		return intent;
	}

	/**
	 * Creates the create application intent.
	 *
	 * @param ctx the ctx
	 * @param appToken the app token
	 * @param appId the app id
	 *
	 * @return the intent
	 */
	public static Intent createCreateApplicationIntent(Context ctx, String appToken, String appId) {
		String queryString = String.format(
			 "?appCreationToken=%s&instanceName=%s&appid=%s&aib=%s&ismra=%s",
			 URLEncoder.encode(appToken),
			 URLEncoder.encode("Android Phone"),
			 appId,
			 HealthVaultApp.getInstance().getSettings().getIsMultiInstanceAware(),
			 HealthVaultApp.getInstance().getSettings().getIsMRA());  //TODO: phone name
		 queryString =
			 HealthVaultApp.getInstance().getSettings().getShellUrl()
			 + "/redirect.aspx?target=CREATEAPPLICATION&targetqs="
			 + URLEncoder.encode(queryString);

		 Intent intent = new Intent(ctx, ShellActivity.class);
		 intent.putExtra("url", queryString);

		 return intent;
	}

	/**
	 * Called when the activity is first created.
	 *
	 * @param savedInstanceState the saved instance state
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().requestFeature(Window.FEATURE_PROGRESS);

		// Makes Progress bar Visible
		getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);

		webView = new WebView(this);

		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		settings.setSupportZoom(true);

		webView.setWebViewClient(new ShellWebViewClient());
		webView.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress)  {
				setProgress(progress * 100);
			}

			@Override
			public void onReceivedTitle(WebView view, String title) {
				setTitle(title);
				super.onReceivedTitle(view, title);
			}
		});
		CookieManager.getInstance().removeAllCookie();

		setContentView(webView);
		Intent intent = getIntent();
		webView.loadUrl(intent.getStringExtra("url"));
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onKeyDown(int, android.view.KeyEvent)
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
			webView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	/**
	 * The Class ShellWebViewClient.
	 */
	private class ShellWebViewClient extends WebViewClient {
		/* (non-Javadoc)
		 * @see android.webkit.WebViewClient#onPageFinished(android.webkit.WebView, java.lang.String)
		 */
		@Override
		public void onPageFinished(WebView view, String url) {
			if (url.indexOf("complete") > 0) {
				Uri uri = Uri.parse(url);
				final String instanceId = uri.getQueryParameter("instanceid");

				new AsyncTask<Void, Void, Void>() {
					protected Void doInBackground(Void... v) {
						resolveInstance(instanceId);
						resolveRecords();
						return null;
				   }

				   @Override
				   protected void onPostExecute(Void v) {
					  finish();
				   }
				}.execute();
			}
			super.onPageFinished(view, url);
		}

		private void resolveInstance(String instanceId) {
			Connection connection = ConnectionFactory.getUnauthenticatedConnection();
			connection.setAppId(HealthVaultApp.getInstance().getSettings().getMasterAppId());
			HVInstance instance = new HVInstanceResolver(connection)
					.getInstanceForId(instanceId);
			HealthVaultSettings settings = HealthVaultApp.getInstance().getSettings();
			settings.setServiceUrl(instance.getPlatformUri().toString());
			settings.setShellUrl(instance.getShellUri().toString());
			settings.setConnectionStatus(ConnectionStatus.Connected);
			settings.save();
		}

		private void resolveRecords() {
			HealthVaultApp hvApp = HealthVaultApp.getInstance();

			RequestTemplate requestTemplate = new RequestTemplate(
					hvApp.getConnection());

			GetAuthorizedPeopleRequest request = new GetAuthorizedPeopleRequest(
					new GetAuthorizedPeopleParameters());

			GetAuthorizedPeopleResponse response = requestTemplate.makeRequest(
					request,
					GetAuthorizedPeopleResponse.class);

			hvApp.resolvePersonInfoList();
		}

		/* (non-Javadoc)
		 * @see android.webkit.WebViewClient#shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String)
		 */
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);

			return true;
		}
	}
}
