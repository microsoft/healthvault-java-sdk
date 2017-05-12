package com.microsoft.hsg.android.simplexml.client;

import java.io.IOException;
import java.net.URL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.TimeUnit;

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

	/** The settings. */
	private static String restURL;
	private static Connection hvConnection;

	public static MicrosoftHealthVaultRestApiImpl getInstance(HealthVaultSettings settings, Connection connection) {
		if (instance == null) {
			restURL = settings.getRestUrl();
			hvConnection = connection;
			instance = new MicrosoftHealthVaultRestApiImpl(restURL, GetOkHttp(), GetRetrofit().newBuilder());
		}

		return instance;
	}

	private static Retrofit GetRetrofit(){
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(restURL)
				.addConverterFactory(GsonConverterFactory.create())
				.addConverterFactory(JacksonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();
		return retrofit;
	}

	private static OkHttpClient.Builder GetOkHttp(){
			OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
		clientBuilder.connectionPool(new ConnectionPool(3, 3, TimeUnit.SECONDS));
		clientBuilder.addInterceptor(new Interceptor() {
			@Override
			public okhttp3.Response intercept(Chain chain) throws IOException {
				Request request = chain.request();
				Request.Builder newRequest = request.newBuilder().header("Authorization", hvConnection.getSessionToken().toString());
				newRequest.build();

				return chain.proceed(newRequest.build());
			}
		});
		return clientBuilder;
	}

}
