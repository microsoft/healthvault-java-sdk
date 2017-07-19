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

package com.microsoft.healthvault;

import org.joda.time.DateTime;

/**
 * The authenticated session token.
 * The token has a limited time-to-live.
 * When the token expires, requests will fail with access denied.
 * Connections will automatically refresh the token when expired.
 */
public class SessionCredential {
    private String token;
    private String sharedSecret;
    private DateTime expirationUtc;

    /**
     * Gets the token
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token
     * @param token the token string
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Gets the shared secret
     * @return the shared secret
     */
    public String getSharedSecret() {
        return sharedSecret;
    }

    /**
     * Sets the shared secret
     * @param sharedSecret the shared secret
     */
    public void setSharedSecret(String sharedSecret) {
        this.sharedSecret = sharedSecret;
    }

    /**
     * Gets the expiration time of the token
     * @return the expiration time of the token
     */
    public DateTime getExpirationUtc() {
        return expirationUtc;
    }

    /**
     * Sets the expiration time of the token
     * @param expirationUtc the expiration time of the token
     */
    public void setExpirationUtc(DateTime expirationUtc) {
        this.expirationUtc = expirationUtc;
    }
}
