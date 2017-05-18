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


public class HealthVaultRestClient {

	/** The instance. */
	private static MicrosoftHealthVaultRestApiImpl instance;
	private static DateTime lastRefreshedSessionCredential = DateTime.now();;
	private static final int SessionCredentialCallThresholdMinutes = 5;
	private static Retrofit retrofit;
	private static String restURL;
	private static OkHttpClient.Builder okBuilder;
	private static Connection hvConnection;
	private static Record currentRecord;

	public HealthVaultRestClient (HealthVaultSettings settings, Connection connection, Record currentRecord){
		InitInstance(settings, connection, currentRecord);
	}

	private void InitInstance(HealthVaultSettings settings, Connection connection, Record currentRecord){
		if (connection == null){
			throw new HVException("connection is null");
		}
		restURL = settings.getRestUrl();
		OkHttpClient.Builder okBuilder = getOkHttp(connection, currentRecord);
		Retrofit retrofit = getRetrofit(restURL);
		instance = new MicrosoftHealthVaultRestApiImpl(restURL, okBuilder, retrofit.newBuilder());
	}

	public static MicrosoftHealthVaultRestApiImpl getInstance(HealthVaultSettings settings, Connection connection, Record currentRecord) {
		if (instance == null) {
			tokenRefreshCheck(connection);
			OkHttpClient.Builder okBuilder = getOkHttp(connection, currentRecord);
			instance = new MicrosoftHealthVaultRestApiImpl(restURL, okBuilder, retrofit.newBuilder());
		}

		return instance;
	}

	private static Retrofit getRetrofit(String url){
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(url)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();
		return retrofit;
	}

	private static OkHttpClient.Builder getOkHttp(Connection connection, Record currentRecord){
		final String token = getAuthToken(connection, currentRecord);
		OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
		clientBuilder.connectionPool(new ConnectionPool(3, 5, TimeUnit.SECONDS));
		clientBuilder.addInterceptor(new Interceptor() {
			@Override
			public okhttp3.Response intercept(Chain chain) throws IOException {
				Request request = chain.request();
				Request.Builder newRequest = request.newBuilder().header("Authorization", token);
				newRequest.build();

				return chain.proceed(newRequest.build());
			}
		});
		return clientBuilder;
	}

	private static String getAuthToken (Connection connection, Record currentRecord){
		String token =  "MSH-V1 app-token=" + connection.getSessionToken().toString() +
				",offline-person-id=" + currentRecord.getPersonId() +
				",record-id=" + currentRecord.getId();
		return token;
	}

	public static void tokenRefreshCheck(Connection connection){
		if (Minutes.minutesBetween(DateTime.now(), lastRefreshedSessionCredential).isGreaterThan(Minutes.minutes(SessionCredentialCallThresholdMinutes))) {
			connection.getAuthenticator().authenticate(connection, true);
			lastRefreshedSessionCredential = DateTime.now();
		}
	}
}
