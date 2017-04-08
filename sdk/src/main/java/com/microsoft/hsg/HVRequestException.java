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
