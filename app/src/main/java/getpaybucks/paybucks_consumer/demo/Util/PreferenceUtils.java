package getpaybucks.paybucks_consumer.demo.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Utilities and constants related to app preferences.
 */
public class PreferenceUtils {

    private static final String TAG = "PrefUtils";

    private static final String PREF_CARD_DETAILS = "pref_card_details";

    private static final String PREF_CURRENT_CARD_NAME = "pref_card_name";

    private static final String PREF_CURRENT_CARD_NUMBER = "pref_card_number";

    private static final String PREF_CURRENT_CARD_EXPIRY= "pref_card_expiry";

    private static final String PREF_CURRENT_CARD_CVV = "pref_card_cvv";

    private static final String PREF_PHONE_NUMBER = "pref_phone_number";

    public static String getPrefCardDetails(Context context){
        return getString(context, PREF_CARD_DETAILS, null);
    }

    public static void setPrefCardDetails(Context context, String json){
        setString(context, PREF_CARD_DETAILS, json);
    }

    public static String getPrefCurrentCardName(Context context){
        return getString(context, PREF_CURRENT_CARD_NAME, null);
    }

    public static void setPrefCurrentCardName(Context context, String string){
        setString(context, PREF_CURRENT_CARD_NAME, string);
    }

    public static String getPrefCurrentCardNumber(Context context){
        return getString(context, PREF_CURRENT_CARD_NUMBER, null);
    }

    public static void setPrefCurrentCardNumber(Context context, String string){
        setString(context, PREF_CURRENT_CARD_NUMBER, string);
    }

    public static String getPrefCurrentCardExpiry(Context context){
        return getString(context, PREF_CURRENT_CARD_EXPIRY, null);
    }

    public static void setPrefCurrentCardExpiry(Context context, String string){
        setString(context, PREF_CURRENT_CARD_EXPIRY, string);
    }

    public static String getPrefCurrentCardCvv(Context context){
        return getString(context, PREF_CURRENT_CARD_CVV, null);
    }

    public static void setPrefCurrentCardCvv(Context context, String string){
        setString(context, PREF_CURRENT_CARD_CVV, string);
    }

    public static String getPrefPhoneNumber(Context context){
        return getString(context, PREF_PHONE_NUMBER, null);
    }

    public static void setPrefPhoneNumber(Context context, String string){
        setString(context, PREF_PHONE_NUMBER, string);
    }

    // Helper methods
    public static void setString(Context context, String key, String value){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putString(key, value).apply();
    }

    public static String getString(Context context,String key, String defaultValue){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getString(key, defaultValue);
    }

    public static void setLong(Context context, String key, long value){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putLong(key, value).apply();
    }

    public static long getLong(Context context,String key, long defaultValue){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getLong(key,defaultValue);
    }

    public static void setBoolean(Context context,String key,boolean value){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putBoolean(key, value).apply();
    }

    public static boolean getBoolean(Context context,String key){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(key,false);
    }

    public static boolean getBoolean(Context context,String key,boolean defaultValue){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(key,defaultValue);
    }

    public static void setInt(Context context,String key,int value){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putInt(key, value).apply();
    }

    public static int getInt(Context context,String key){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getInt(key,0);
    }

    public static void setFloat(Context context,String key,float value){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putFloat(key, value).apply();
    }

    public static float getFloat(Context context,String key){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getFloat(key,0);
    }
}
