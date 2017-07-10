package com.microsoft.healthvault.restapi;

import com.microsoft.healthvault.restapi.implementation.MicrosoftHealthVaultRestApiImpl;

import org.junit.Test;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static org.junit.Assert.assertNotEquals;

public class ActionPlanTest {

	private String restHealthVaultUrl = "https://data.microsofthealth.net/";

	@Test
	public void createDefaultRestClient(){
		final MicrosoftHealthVaultRestApiImpl restClient = new MicrosoftHealthVaultRestApiImpl(restHealthVaultUrl);
		assertNotEquals(restClient, null);
	}

	@Test
	public void createRestClient(){
		final MicrosoftHealthVaultRestApiImpl restClient = new MicrosoftHealthVaultRestApiImpl(restHealthVaultUrl, getOkHttp(), getRetrofit(restHealthVaultUrl).newBuilder());
		Retrofit retrofit = restClient.retrofit();
		assertNotEquals(retrofit, null);
	}

	private Retrofit getRetrofit(String url){
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(url)
				.addConverterFactory(GsonConverterFactory.create())
				.addConverterFactory(JacksonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();
		return retrofit;
	}

	private OkHttpClient.Builder getOkHttp(){
		OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

		return clientBuilder;
	}
}
