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

package com.microsoft.hsg.android.simplexml.client;

import java.io.IOException;
import java.net.URL;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.Minutes;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Base64;

import com.microsoft.hsg.Authenticator;
import com.microsoft.hsg.Connection;
import com.microsoft.hsg.HVException;
import com.microsoft.hsg.Transport;
import com.microsoft.hsg.URLConnectionTransport;
import com.microsoft.hsg.android.simplexml.HealthVaultSettings;
import com.microsoft.hsg.android.simplexml.HealthVaultFileSettings;
import com.google.common.reflect.TypeToken;
import com.microsoft.hsg.android.simplexml.things.types.types.Record;
import com.microsoft.rest.RestClient;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceClient;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.Validator;

import healthvault.client.implementation.MicrosoftHealthVaultRestApiImpl;

import healthvault.client.models.ActionPlan;
import healthvault.client.models.ActionPlansResponseActionPlanInstance;
import healthvault.client.models.Objective;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;


public class HealthVaultRestClient implements IHealthVaultRestClient {

	private static MicrosoftHealthVaultRestApiImpl instance;
	private static DateTime mLastRefreshedSessionCredential = DateTime.now();;
	private static Retrofit mRetrofit;
	private static String mRestURL;
	private static OkHttpClient.Builder mOkBuilder;
	private static Connection mConnection;
	private static Record mCurrentRecord;
	private static HealthVaultSettings mSettings;
	private static final int mSessionCredentialCallThresholdMinutes = 5;
	private static final String osVersion = Build.VERSION.RELEASE;
	private static final String category = "HV-Android";
	private static final String fileVersion = "hv-sdk-1.6";

	public HealthVaultRestClient (HealthVaultSettings settings, Connection connection, Record currentRecord){
		Initialize(settings, connection, currentRecord);
	}

	private void Initialize(HealthVaultSettings settings, Connection connection, Record currentRecord){
		if (connection == null){
			throw new HVException("connection is null");
		}
		mSettings = settings;
		mRestURL = settings.getRestUrl();
		mCurrentRecord = currentRecord;
		mConnection = connection;
		mOkBuilder = getOkHttp(connection, currentRecord);
		mRetrofit = getRetrofit(mRestURL);
	}

	public MicrosoftHealthVaultRestApiImpl getClient() {
		return new MicrosoftHealthVaultRestApiImpl(mRestURL, mOkBuilder, mRetrofit.newBuilder());
	}

	private Retrofit getRetrofit(String url){
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(url)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();
		return retrofit;
	}

	public OkHttpClient.Builder getOkHttp(final Connection connection, final Record currentRecord){
		OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
		clientBuilder.connectionPool(new ConnectionPool(3, 5, TimeUnit.SECONDS));
		clientBuilder.addInterceptor(new Interceptor() {
			@Override
			public okhttp3.Response intercept(Chain chain) throws IOException {
				String token = getAuthToken(connection, currentRecord);
				Request request = chain.request();
				Request.Builder newRequest = request.newBuilder().addHeader("Authorization", token);
				newRequest.addHeader("x-ms-version", getVersion());
				newRequest.build();

				return chain.proceed(newRequest.build());
			}
		});
		return clientBuilder;
	}

	private String getVersion() {
		StringBuilder sb = new StringBuilder();
		sb.append(category + "/");
		sb.append(fileVersion + " ");
		sb.append(osVersion);
		return sb.toString();
	}

	private String getAuthToken (Connection connection, Record currentRecord){
		DateTime dateTime= mSettings.getSessionExpiration();
		if(dateTime.isBeforeNow()) {
			tokenRefresh(connection);
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("MSH-V1 app-token=");
		stringBuilder.append(connection.getSessionToken().toString());
		stringBuilder.append(",offline-person-id=");
		stringBuilder.append(currentRecord.getPersonId());
		stringBuilder.append(",record-id=");
		stringBuilder.append(currentRecord.getId());

		return stringBuilder.toString();
	}

	public void tokenRefresh(Connection connection){
			if (Minutes.minutesBetween(DateTime.now(), mLastRefreshedSessionCredential).isGreaterThan(Minutes.minutes(mSessionCredentialCallThresholdMinutes))) {
				connection.getAuthenticator().authenticate(connection, true);
				mLastRefreshedSessionCredential = DateTime.now();
				mSettings.setSessionExpiration();
			}
	}
}
