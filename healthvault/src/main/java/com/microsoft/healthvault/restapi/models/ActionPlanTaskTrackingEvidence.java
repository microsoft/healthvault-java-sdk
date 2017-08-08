/**
 * Code generated by Microsoft (R) AutoRest Code Generator 1.1.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.healthvault.restapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * The evidence associated Action Plan Task Tracking.
 */
public class ActionPlanTaskTrackingEvidence {
    /**
     * The Tracking IDs as evidence.
     */
    @JsonProperty(value = "trackings")
    private List<String> trackings;

    /**
     * The HealthVault ThingIDs as evidence.
     */
    @JsonProperty(value = "hvThings")
    private List<String> hvThings;

    /**
     * Get the trackings value.
     *
     * @return the trackings value
     */
    public List<String> trackings() {
        return this.trackings;
    }

    /**
     * Set the trackings value.
     *
     * @param trackings the trackings value to set
     * @return the ActionPlanTaskTrackingEvidence object itself.
     */
    public ActionPlanTaskTrackingEvidence withTrackings(List<String> trackings) {
        this.trackings = trackings;
        return this;
    }

    /**
     * Get the hvThings value.
     *
     * @return the hvThings value
     */
    public List<String> hvThings() {
        return this.hvThings;
    }

    /**
     * Set the hvThings value.
     *
     * @param hvThings the hvThings value to set
     * @return the ActionPlanTaskTrackingEvidence object itself.
     */
    public ActionPlanTaskTrackingEvidence withHvThings(List<String> hvThings) {
        this.hvThings = hvThings;
        return this;
    }

}
