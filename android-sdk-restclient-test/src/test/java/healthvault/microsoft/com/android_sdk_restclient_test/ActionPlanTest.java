package healthvault.microsoft.com.android_sdk_restclient_test;

import android.content.Context;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.reflect.TypeToken;
import com.microsoft.hsg.Connection;
import com.microsoft.hsg.android.simplexml.ConnectionFactory;
import com.microsoft.hsg.android.simplexml.client.HealthVaultClient;
import com.microsoft.hsg.android.simplexml.client.HealthVaultRestClient;
import org.joda.time.DateTime;
import com.microsoft.hsg.android.simplexml.HealthVaultApp;
import com.microsoft.hsg.android.simplexml.client.IHealthVaultRestClient;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.BlobFormatSpec;
import com.microsoft.hsg.android.simplexml.methods.getthings3.request.ThingRequestGroup2;
import com.microsoft.hsg.android.simplexml.things.thing.BlobInfo;
import com.microsoft.hsg.android.simplexml.things.thing.BlobPayload;
import com.microsoft.hsg.android.simplexml.things.thing.BlobPayloadItem;
import com.microsoft.hsg.android.simplexml.things.thing.Thing2;
import com.microsoft.hsg.android.simplexml.things.thing.ThingKey;
import com.microsoft.hsg.android.simplexml.things.types.allergy.Allergy;
import com.microsoft.hsg.android.simplexml.things.types.base.CodableValue;
import com.microsoft.hsg.android.simplexml.things.types.types.PersonInfo;
import com.microsoft.hsg.android.simplexml.things.types.types.Record;

import healthvault.client.implementation.MicrosoftHealthVaultRestApiImpl;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ActionPlanTest {
	private static HealthVaultApp service;
	private static HealthVaultClient hvClient;
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
