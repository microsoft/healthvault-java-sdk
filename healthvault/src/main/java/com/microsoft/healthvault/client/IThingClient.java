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

package com.microsoft.healthvault.client;

import com.microsoft.healthvault.thingtypes.AbstractThing;
import com.microsoft.healthvault.thingtypes.HealthVaultThing;
import com.microsoft.healthvault.thingtypes.Thing2;
import com.microsoft.healthvault.thingtypes.ThingKey;
import com.microsoft.healthvault.types.Guid;

import java.util.ArrayList;
import java.util.List;

public interface IThingClient extends IClient {
    /**
     * Gets a ThingBase by its unique identifier
     * @param recordId The health record's ID.
     * @param thingId The unique identifier of the thing
     * @return
     */
    <T extends AbstractThing> T getThingAsync(Guid recordId, Guid thingId);

    /**
     * Creates a new collection of things, and updates each item with a Key that has its thing id and version id.
     * @param recordId The health record's ID.
     * @param things The collection of things to create.
     * @return a list of {@link ThingKey} containing information about the created Things.
     */
    <T extends AbstractThing> List<ThingKey> createThingsAsync(Guid recordId, List<T> things);

    /**
     * Updates a collection of things that already exists.
     * @param recordId The health record's ID.
     * @param things The health record's ID.
     */
    <T extends AbstractThing> void updateThingsAsync(Guid recordId, List<T> things);

    /**
     * Removes a collection of things.
     * @param recordId The health record's ID.
     * @param things The collection of things to remove.
     */
    <T extends AbstractThing> void removeThingsAsync(Guid recordId, List<T> things);
}
