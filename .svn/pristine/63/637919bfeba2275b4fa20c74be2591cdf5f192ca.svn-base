/*
 * Copyright 2011 Microsoft Corp.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.microsoft.hsg.request;



import com.microsoft.hsg.Request;

/**
 * The Interface RequestTemplate.  This interface represents
 * a template capable of sending requests and receiving responses
 * from HealthVault.  Examples of concrete templates are OnlineRequestTemplate
 * for making calls to HealthVault while the user is online, and OfflineRequestTemplate
 * for making calls to HealthVault while the user is offline.
 */
public interface RequestTemplate {

	/**
	 * Make request.
	 * 
	 * @param request the request
	 */
	public abstract void makeRequest(Request request);

	/**
	 * Make request.
	 * 
	 * @param request the request
	 * @param marshaller the marshaller
	 * 
	 * @return the object
	 */
	public abstract Object makeRequest(Request request, RequestMarshaller marshaller);

}