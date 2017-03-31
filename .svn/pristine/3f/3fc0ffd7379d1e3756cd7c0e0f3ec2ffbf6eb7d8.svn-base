/*
 * (c) Copyright Microsoft Corporation. 
 * This source is subject to the Microsoft Public License.
 * See http://www.microsoft.com/opensource/licenses.mspx#Ms-PL       
 */
package com.microsoft.hsg.applications;

/**
 * The Request Context is available while the thread is
 * processing a request for an user.
 */
public class RequestCtx {
	
	/** The _person info. */
	private static ThreadLocal _personInfo = new ThreadLocal();

    /**
     * Gets the person info.
     * 
     * @return the person info
     */
    public static PersonInfo getPersonInfo() {
        return ((PersonInfo) (_personInfo.get()));
    }
    
    /**
     * Sets the person info.
     * 
     * @param personInfo the new person info
     */
    public static void setPersonInfo(PersonInfo personInfo) {
    	_personInfo.set(personInfo);
    }

}
