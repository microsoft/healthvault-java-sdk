package com.microsoft.hsg.jaxb;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.microsoft.hsg.ConnectionFactory;
import com.microsoft.hsg.methods.jaxb.SimpleRequestTemplate;
import com.microsoft.hsg.methods.jaxb.geteventsubscriptions.request.GetEventSubscriptionsRequest;
import com.microsoft.hsg.methods.jaxb.geteventsubscriptions.response.GetEventSubscriptionsResponse;
import com.microsoft.hsg.methods.jaxb.subscribetoevent.request.SubscribeToEventRequest;
import com.microsoft.hsg.methods.jaxb.subscribetoevent.response.SubscribeToEventResponse;
import com.microsoft.hsg.methods.jaxb.subscription.Common;
import com.microsoft.hsg.methods.jaxb.subscription.HVEventingSharedKey;
import com.microsoft.hsg.methods.jaxb.subscription.HttpNotificationChannel;
import com.microsoft.hsg.methods.jaxb.subscription.NotificationAuthenticationInfo;
import com.microsoft.hsg.methods.jaxb.subscription.NotificationChannel;
import com.microsoft.hsg.methods.jaxb.subscription.RecordItemChangedEvent;
import com.microsoft.hsg.methods.jaxb.subscription.RecordItemChangedEventFilter;
import com.microsoft.hsg.methods.jaxb.subscription.RecordItemChangedEventFilters;
import com.microsoft.hsg.methods.jaxb.subscription.Subscription;
import com.microsoft.hsg.methods.jaxb.subscription.Subscriptions;
import com.microsoft.hsg.methods.jaxb.subscription.TypeIds;
import com.microsoft.hsg.methods.jaxb.unsubscribetoevent.request.UnsubscribeToEventRequest;
import com.microsoft.hsg.methods.jaxb.updateeventsubscription.request.UpdateEventSubscriptionRequest;

@RunWith(JMock.class)
public class EventSubscriptionsTest {

	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};
	
	@Test
    public void GetEventSubscriptions() throws Exception
    {
    	Subscription subscription = CreateSubscription();
    	subscription.getRecordItemChangedEvent()
    		.getFilters()
    		.getFilter()
    		.get(0)
    		.getTypeIds()
    		.getTypeId()
    		.add("52bf9104-2c5e-4f1f-a66d-552ebcc53df7");
    	
    	UpdateSubscription(subscription);
  
    	Subscriptions subscriptions = GetSubscriptions();
    	for (Subscription sub : subscriptions.getSubscription()) {
    		RemoveSubscription(sub.getCommon().getId());
    	}
    }
	
	private void RemoveSubscription(String id) throws Exception {
		SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
		
		UnsubscribeToEventRequest request = new UnsubscribeToEventRequest();
		request.setSubscriptionId(id);
		
		requestTemplate.makeRequest(request);
	}
	
	private Subscriptions GetSubscriptions() throws Exception {
		SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
		
		GetEventSubscriptionsRequest request = new GetEventSubscriptionsRequest();
		
		GetEventSubscriptionsResponse response = 
			(GetEventSubscriptionsResponse)requestTemplate.makeRequest(
	    		request);
		
		return response.getSubscriptions();
	}
	
	private void UpdateSubscription(Subscription subscription) 
	throws Exception {
		SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
		
		UpdateEventSubscriptionRequest request = new UpdateEventSubscriptionRequest();
		request.setSubscription(subscription);
		
		requestTemplate.makeRequest(request);
	}
	
	private Subscription CreateSubscription() throws Exception {
		
		SimpleRequestTemplate requestTemplate = new SimpleRequestTemplate(
    			ConnectionFactory.getConnection());
    	
    	HVEventingSharedKey sharedKey = new HVEventingSharedKey();
    	sharedKey.setNotificationKey("MTIzNDU2Nzg5MDEyMzQ1Njc4OTAxMjM0NTY3ODkwMTIzNDU2Nzg5MDEyMzQ1Njc4OTAxMjM0NTY3ODkwMTIzNA==");
    	sharedKey.setNotificationKeyVersionId("1");
    	
    	NotificationAuthenticationInfo authInfo =
    		new NotificationAuthenticationInfo();
    	authInfo.setHvEventingSharedKey(sharedKey);
    	
    	HttpNotificationChannel httpChannel = new HttpNotificationChannel();
    	httpChannel.setUrl("https://nobody.contoso.com/notif");
    	
    	NotificationChannel notificationChannel = new NotificationChannel();
    	notificationChannel.setHttpNotificationChannel(httpChannel);
    	
    	Common common = new Common();
    	common.setNotificationAuthenticationInfo(authInfo);
    	common.setNotificationChannel(notificationChannel);
    	
    	TypeIds typeIds = new TypeIds();
    	typeIds.getTypeId().add("3b3e6b16-eb69-483c-8d7e-dfe116ae6092");
    	
    	RecordItemChangedEventFilter filter = new RecordItemChangedEventFilter();
    	filter.setTypeIds(typeIds);
    	
    	RecordItemChangedEventFilters filters = new RecordItemChangedEventFilters();
    	filters.getFilter().add(filter);
    	
    	RecordItemChangedEvent event = new RecordItemChangedEvent();
    	event.setFilters(filters);
    	
    	Subscription subscription = new Subscription();
    	subscription.setCommon(common);
    	subscription.setRecordItemChangedEvent(event);
    	
    	SubscribeToEventRequest request = new SubscribeToEventRequest();
    	request.setSubscription(subscription);
    	
    	SubscribeToEventResponse response = 
    		(SubscribeToEventResponse)requestTemplate.makeRequest(
    			request);
    	
    	subscription.getCommon().setId(response.getSubscriptionId());
    	
    	return subscription;
	}	
}
