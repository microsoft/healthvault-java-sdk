package com.microsoft.healthvault;

import android.test.ProviderTestCase2;

import com.microsoft.healthvault.localvault.SynchronizedView;
import com.microsoft.healthvault.methods.getthings3.request.ThingRequestGroup2;
import com.microsoft.healthvault.store.HVContentContract;
import com.microsoft.healthvault.store.HVContentProvider;
import com.microsoft.healthvault.thingtypes.Weight;
import com.microsoft.healthvault.types.Record;

import junit.framework.Assert;

public class SynchronizedViewTest extends ProviderTestCase2<HVContentProvider> {
	
	HealthVaultApp app;
	
	public SynchronizedViewTest() {
		super(HVContentProvider.class, HVContentContract.AUTHORITY);
	}
	
	public void setUp() throws Exception {
		super.setUp();
		app = new TestApp().getHVApp();
	}
	
	public void testCreateView() {
		String viewName = "test-view";
		Record record = app.getPersonInfoList().get(0).getRecords().get(0);
		
		ThingRequestGroup2 query = ThingRequestGroup2.thingTypeQuery("42");
		
		clearView(viewName, record);
		
		SynchronizedView view = SynchronizedView.makeView(
			this.getMockContext(), 
			record,
			viewName,
			query);
	}
	
	public void testSynchronize() throws Exception {
		String viewName = "test-view";
		Record record = app.getPersonInfoList().get(0).getRecords().get(0);
		
		ThingRequestGroup2 query = ThingRequestGroup2.thingTypeQuery(Weight.ThingType);
		query.setMax(300);
		
		clearView(viewName, record);
		
		SynchronizedView view = SynchronizedView.makeView(
			this.getMockContext(), 
			record,
			viewName,
			query);
		
		view.synchronize();
	}
	
	public void testGetNonExistingView() throws Exception
	{
		Record record = app.getPersonInfoList().get(0).getRecords().get(0);

		SynchronizedView view = SynchronizedView.getView(
			this.getMockContext(),
			"does-not-exist",
			record);
		
		Assert.assertNull(view);
	}
	
	private void clearView(String name, Record record) {
		SynchronizedView view = SynchronizedView.getView(this.getMockContext(), name, record);
		if (view != null) {
			view.delete();
			view = SynchronizedView.getView(this.getMockContext(), name, record);

			Assert.assertTrue("View not deleted", view == null);
		}
	}
}
