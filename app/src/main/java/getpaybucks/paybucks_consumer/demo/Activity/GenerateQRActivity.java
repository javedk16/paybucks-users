package getpaybucks.paybucks_consumer.demo.Activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import getpaybucks.paybucks_consumer.R;
import getpaybucks.paybucks_consumer.demo.Util.Constants;
import getpaybucks.paybucks_consumer.demo.Util.PreferenceUtils;

public class GenerateQRActivity extends Activity {

    private Context mContext;

    private int amount;
    private String qrString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr);

        mContext = getApplicationContext();

        ImageView qrCode = (ImageView) findViewById(R.id.qr_code_image);

        amount = getIntent().getExtras().getInt(Constants.AMOUNT);

        qrString = PreferenceUtils.getPrefCurrentCardName(mContext) + "$"
                + PreferenceUtils.getPrefCurrentCardNumber(mContext) + "$"
                + PreferenceUtils.getPrefCurrentCardExpiry(mContext) + "$"
                + PreferenceUtils.getPrefCurrentCardCvv(mContext) + "$"
                + PreferenceUtils.getPrefPhoneNumber(mContext) + "$"
                + amount;

        QRCodeWriter wr = new QRCodeWriter();
        BitMatrix bm = new BitMatrix(700, 700);
        try {
            bm = wr.encode(qrString, BarcodeFormat.QR_CODE, 700, 700);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        int height = bm.getHeight();
        int width = bm.getWidth();
        Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bmp.setPixel(x, y, bm.get(x, y) ? Color.BLACK : Color.WHITE);
            }
        }
        qrCode.setImageBitmap(bmp);
    }

    public void parseString(String s){

        String splitArray[] = s.split("$");

        String cardName = splitArray[0];
        String cardNumber = splitArray[1];
        String cardExpiry = splitArray[2];
        String cardCvv = splitArray[3];
        String phoneNumber = splitArray[4];
        String amount = splitArray[5];

    }
}
