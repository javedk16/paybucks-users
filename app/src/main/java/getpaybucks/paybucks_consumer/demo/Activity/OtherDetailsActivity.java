package getpaybucks.paybucks_consumer.demo.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import getpaybucks.paybucks_consumer.R;
import getpaybucks.paybucks_consumer.demo.Util.Constants;
import getpaybucks.paybucks_consumer.demo.Util.PreferenceUtils;

public class OtherDetailsActivity extends AppCompatActivity {

    @InjectView(R.id.amount) EditText mAmount;
    @InjectView(R.id.phone) EditText mPhone;
    @InjectView(R.id.cvv) EditText mCvv;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_details);

        ButterKnife.inject(this);

        mContext = getApplicationContext();
    }

    @OnClick(R.id.proceed)
    public void proceed(){

        int amount = 0;

        if(!mAmount.getText().toString().equals("")){
            amount = Integer.parseInt(mAmount.getText().toString());
        }

        if(!mPhone.getText().toString().equals("")){
            PreferenceUtils.setPrefPhoneNumber(mContext, mPhone.getText().toString());
        }

        if(!mCvv.getText().toString().equals("")){
            PreferenceUtils.setPrefCurrentCardCvv(mContext, mCvv.getText().toString());
        }

        if(!mAmount.getText().toString().equals("")
            && !mPhone.getText().toString().equals("")
            && !mCvv.getText().toString().equals("")) {
            Intent intent = new Intent(getApplicationContext(), GenerateQRActivity.class);
            intent.putExtra(Constants.AMOUNT, amount);
            startActivity(intent);
        }
        else{
            Toast.makeText(mContext, "Please fill in all the details", Toast.LENGTH_LONG).show();
        }
    }
}
