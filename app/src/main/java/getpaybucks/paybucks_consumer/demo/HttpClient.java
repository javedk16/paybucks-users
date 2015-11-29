package getpaybucks.paybucks_consumer.demo;

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;

import java.util.HashMap;
import java.util.Map;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Singleton Http client which will be used for all
 * interaction with api.
 */
public class HttpClient {

    /**
     * Base API Url configured as build config field.
     */
    private static final String API_URL = "https://secret-river-1096.herokuapp.com/api/v1";

    /**
     * Singleton instance of this
     */
    private static HttpClient mHttpClient;

    private static RestAdapter mRestAdapter;

    private Map<String, Object> mClients = new HashMap<>();

    private static Context mContext;

    private RestAdapter.Builder mBuilder;

    /**
     * Private constructor prevents new instances creation with new command.
     */
    private HttpClient() {

    }

    /**
     * Get HttpClient instance
     * @param context activity context
     * @return HttpClient
     */
    public static HttpClient getInstance(Context context) {
        if (mHttpClient == null) {
            mHttpClient = new HttpClient();
        }

        if (mContext == null) {
            mContext = context;
        }

        return mHttpClient;
    }

    /**
     * Returns client based on the generic type.
     * Creates resource adapter if does not exist in
     * clients array and adds it to the array for future use so
     * client is created only once for every resource.
     *
     * @param tClass Resource interface
     * @param <T> Type of resource interface
     * @return configure retrofit client.
     */
    @SuppressWarnings("unchecked")
    public <T> T getClient(Class<T> tClass) {

        OkHttpClient okHttpClient = new OkHttpClient();

        String hostURL = API_URL;

        if (mRestAdapter == null) {

            mBuilder = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(hostURL)
                    .setClient(new OkClient(okHttpClient))
                    .setRequestInterceptor(new RequestInterceptor() {
                        @Override
                        public void intercept(RequestFacade request) {

                            request.addHeader("Content-Type", "text/plain");
                        }
                    });

            mRestAdapter = mBuilder.build();
        }

        // TODO: Suppressing unchecked cast warning.
        T client = (T) mClients.get(tClass.getCanonicalName());
        if (client != null) {
            return client;
        }

        client = mRestAdapter.create(tClass);
        mClients.put(tClass.getCanonicalName(), client);

        return client;
    }
}
