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

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Unit test for simple App.
 */
@RunWith(JMock.class)
public class DefaultSendStrategyTest 
{ 
	private Mockery context = new JUnit4Mockery() {{
        setImposteriser(ClassImposteriser.INSTANCE);
    }};


	private Sender sender =  
        context.mock(Sender.class); 

	private Connection connection =
		context.mock(Connection.class);
	
    /**
     * Create the test case
     *
     */
    public DefaultSendStrategyTest( )
    {
    }

    /**
     * Ensure Authentication exception triggers re-auth
     * and resend.
     */
    @Test
    public void testApp()
    {
    	DefaultSendStrategy sendStrategy = new DefaultSendStrategy();
    	context.checking(new Expectations() {{
            oneOf(sender).send();
            will(throwException(new HVApplicationSessionExpiredException("dummy")));
            oneOf(connection).authenticate(true);
            oneOf(sender).send();
        }});
    	sendStrategy.doWithSender(connection, sender);
    }
}
