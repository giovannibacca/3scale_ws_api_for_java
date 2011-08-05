package net.threescale.api.v2;

import java.util.HashMap;

/**
 * Version 2 of the 3Scale API.
 * <p/>
 * This version is not compatible with Version 1.
 * See http://www.3scale.net/support/api-service-management-v2-0/ for more details
 */
public interface Api2 {

    /**
      * Authorize access and fetch the current statistics for an application.
      *
      * @param app_id   Application Id give by user
      * @param app_key  Optional Application Key (or null)
      * @param referrer Optional referrer ip address (or null)'
      * @return AuthorizeResponse containing the current usage metrics.
      * @throws ApiException if there is an error connection to the server
      */
     AuthorizeResponse authorize(String app_id, String app_key, String referrer) throws ApiException;

    /**
      * Authorize access and fetch the current statistics for an application for specific metrics
      *
      * @param app_id   Application Id give by user
      * @param app_key  Optional Application Key (or null)
      * @param referrer Optional referrer ip address (or null)'
      * @param usage_metrics Optional set of key:value pairs of metrics to be checked
      * @return AuthorizeResponse containing the current usage metrics.
      * @throws ApiException if there is an error connection to the server
      */
     AuthorizeResponse authorize(String app_id, String app_key, String referrer, HashMap<String, String> usage_metrics) throws ApiException;

    /**
     * Send a set of usage data to the server
     *
     * @param transactions Usage data to be recorded
     * @throws ApiException if there is an error connection to the server
     */
    void report(ApiTransaction[] transactions) throws ApiException;

    /**
     * `get the url of the 3scale server
     * @return  The current server url
     */
    String getServerUrl();
}
