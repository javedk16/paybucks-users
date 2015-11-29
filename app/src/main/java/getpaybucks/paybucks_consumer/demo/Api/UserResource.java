package getpaybucks.paybucks_consumer.demo.Api;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by javed on 11/29/15.
 */
public interface UserResource {

    @FormUrlEncoded
    @POST("/users")
    public void sendUserDataToServer(@Field("user_name") String name,
                                     @Field("user_mobile_number") String phone,
                                     @Field("user_vendors[0]") String vendor,
                                     @Field("user_email") String email,
                                     @Field("user_device_id") String deviceId);
}
