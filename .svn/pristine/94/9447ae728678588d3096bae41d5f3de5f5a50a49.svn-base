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
package com.microsoft.hsg;

/**
 * The class HVRequestException is the base class for
 * all exception resulting from received HealthVault responses
 * where the status code != 0.
 */
public class HVRequestException extends HVException
{
	private StatusCode code;
	private int responseCode;
	
	/**
	 * Instantiates a new hV request exception.
	 * 
	 * @param code the code
	 */
	public HVRequestException(StatusCode code, String message)
	{
		super(message);
		this.code = code;
		this.responseCode = code.getCode();
	}
	
	public HVRequestException(StatusCode code, int responseCode, String message)
	{
		this(code, message);
		this.responseCode = responseCode;
	}
	
	/**
	 * Gets the code.
	 * 
	 * @return the code
	 */
	public StatusCode getCode()
	{
		return code;
	}
	
	/**
	 * Gets the response code.
	 * 
	 * @return the response code
	 */
	public int getResponseCode()
	{
		return responseCode;
	}
}
