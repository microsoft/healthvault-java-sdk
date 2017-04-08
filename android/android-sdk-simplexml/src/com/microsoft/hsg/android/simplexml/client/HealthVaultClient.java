package com.microsoft.hsg.android.simplexml.client;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import android.os.Handler;
import android.util.Log;

import com.microsoft.hsg.HVException;
import com.microsoft.hsg.android.simplexml.methods.request.HVRequestInfo;
import com.microsoft.hsg.android.simplexml.methods.request.RequestTemplate;

public class HealthVaultClient {
	
	private ExecutorService executor;
	private Handler responseHandler;
	
	public void start() {
		if (executor == null) {
			executor = Executors.newFixedThreadPool(3);
			responseHandler = new Handler();
		}
	}
	
	public <T> Future<T> asyncRequest(Callable<T> request, RequestCallback<T> callback) {			
		AsyncCallbackHandler<T> callbackHandler = new AsyncCallbackHandler<T>(
				responseHandler,
				callback);
		return executor.submit(new Runner<T>(request, callbackHandler));
	}
	
	public <T> Future<T> asyncRequest(
			final RequestTemplate template,
			final HVRequestInfo requestInfo,
			final Class<T> responseClass,
			final RequestCallback<T> callback) {
		return asyncRequest( 
			new Callable<T>() {
				public T call() {
					return template.makeRequest(requestInfo, responseClass);
                }
			},
			callback);
	}
	
	private static class Runner<T> implements Callable<T> {
		private Callable<T> delegate;
		private AsyncCallbackHandler<T> handler;

		public Runner(Callable<T> delegate, AsyncCallbackHandler<T> handler) {
			this.delegate = delegate;
			this.handler = handler;
		}
		
		@Override
		public T call() throws Exception {
			T result = null;
			try 
			{
				result = delegate.call();
				if (handler != null) {
					handler.onSuccess(result);
				}
			} catch(Exception e) {
				Log.d("hv", "onError", e);
				if (handler != null ) {
					handler.onError(new HVException(e));
				}
			}
			
			return result;
		}
	}
	
	public void stop() {
		executor.shutdown();
		executor = null;
		
		responseHandler.removeCallbacksAndMessages(null);
		responseHandler = null;
	}
}
