package com.getcoregroup.mkulima.services;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by ley on 3/30/15.
 */
public class SiteClient {

    private static final String BASE_URL = "http://pambanet.getcoregroup.com/upload";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(), params, responseHandler);
    }

    public static void post(RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(), params, responseHandler);
    }

    private static String getAbsoluteUrl() {
        return BASE_URL;
    }

}
