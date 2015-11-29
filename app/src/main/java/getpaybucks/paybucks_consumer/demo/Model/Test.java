package getpaybucks.paybucks_consumer.demo.Model;

/**
 * Created by javed on 11/29/15.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Test {

    @SerializedName("msg")
    @Expose
    private Msg msg;
    @SerializedName("status")
    @Expose
    private int status;

    /**
     *
     * @return
     * The msg
     */
    public Msg getMsg() {
        return msg;
    }

    /**
     *
     * @param msg
     * The msg
     */
    public void setMsg(Msg msg) {
        this.msg = msg;
    }

    /**
     *
     * @return
     * The status
     */
    public int getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    public class Msg {

        @SerializedName("_id")
        @Expose
        private String Id;
        @SerializedName("user_device_id")
        @Expose
        private String userDeviceId;
        @SerializedName("user_email")
        @Expose
        private String userEmail;
        @SerializedName("user_mobile_number")
        @Expose
        private String userMobileNumber;
        @SerializedName("user_name")
        @Expose
        private String userName;
        @SerializedName("__v")
        @Expose
        private int V;
        @SerializedName("user_vendors")
        @Expose
        private List<String> userVendors = new ArrayList<String>();
        @SerializedName("user_id")
        @Expose
        private String userId;

        /**
         *
         * @return
         * The Id
         */
        public String getId() {
            return Id;
        }

        /**
         *
         * @param Id
         * The _id
         */
        public void setId(String Id) {
            this.Id = Id;
        }

        /**
         *
         * @return
         * The userDeviceId
         */
        public String getUserDeviceId() {
            return userDeviceId;
        }

        /**
         *
         * @param userDeviceId
         * The user_device_id
         */
        public void setUserDeviceId(String userDeviceId) {
            this.userDeviceId = userDeviceId;
        }

        /**
         *
         * @return
         * The userEmail
         */
        public String getUserEmail() {
            return userEmail;
        }

        /**
         *
         * @param userEmail
         * The user_email
         */
        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        /**
         *
         * @return
         * The userMobileNumber
         */
        public String getUserMobileNumber() {
            return userMobileNumber;
        }

        /**
         *
         * @param userMobileNumber
         * The user_mobile_number
         */
        public void setUserMobileNumber(String userMobileNumber) {
            this.userMobileNumber = userMobileNumber;
        }

        /**
         *
         * @return
         * The userName
         */
        public String getUserName() {
            return userName;
        }

        /**
         *
         * @param userName
         * The user_name
         */
        public void setUserName(String userName) {
            this.userName = userName;
        }

        /**
         *
         * @return
         * The V
         */
        public int getV() {
            return V;
        }

        /**
         *
         * @param V
         * The __v
         */
        public void setV(int V) {
            this.V = V;
        }

        /**
         *
         * @return
         * The userVendors
         */
        public List<String> getUserVendors() {
            return userVendors;
        }

        /**
         *
         * @param userVendors
         * The user_vendors
         */
        public void setUserVendors(List<String> userVendors) {
            this.userVendors = userVendors;
        }

        /**
         *
         * @return
         * The userId
         */
        public String getUserId() {
            return userId;
        }

        /**
         *
         * @param userId
         * The user_id
         */
        public void setUserId(String userId) {
            this.userId = userId;
        }

    }
}