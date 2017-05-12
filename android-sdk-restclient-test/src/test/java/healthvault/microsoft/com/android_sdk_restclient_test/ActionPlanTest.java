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

import com.google.common.reflect.TypeToken;
import com.microsoft.hsg.android.simplexml.client.HealthVaultClient;
import com.microsoft.hsg.android.simplexml.client.HealthVaultRestClient;
import org.joda.time.DateTime;
import com.microsoft.hsg.android.simplexml.HealthVaultApp;
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

import javax.inject.Inject;

import dagger.Provides;

import healthvault.client.implementation.MicrosoftHealthVaultRestApiImpl;

public class ActionPlanTest {
	private HealthVaultApp service;
	private HealthVaultClient hvClient;
	private HealthVaultRestClient restClient;

	@Test
	public void CreateRestClient(){
		SetupTest();
		final MicrosoftHealthVaultRestApiImpl restClient = HealthVaultRestClient.getInstance(service.getSettings(), service.getConnection());
		assertNotEquals(restClient, null);
	}

	private void SetupTest(){
		service = provideHealthVaultApp();
	}

	@Provides static HealthVaultApp provideHealthVaultApp() {

		return HealthVaultApp.getInstance();
	}
}
