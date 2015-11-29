package getpaybucks.paybucks_consumer.demo.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Toast;

import com.vinaygaba.creditcardview.CreditCardView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import getpaybucks.paybucks_consumer.R;
import getpaybucks.paybucks_consumer.demo.Util.PreferenceUtils;

public class CardDetailsActivity extends AppCompatActivity {

    private Context mContext;

    @InjectView(R.id.card)
    CreditCardView mCreditCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);

        ButterKnife.inject(this);

        mContext = getApplicationContext();
    }

    @OnClick(R.id.proceed)
    public void proceed(){

        String cardNumber = mCreditCardView.getCardNumber();
        String cardName = mCreditCardView.getCardName();
        String cardExpiry = mCreditCardView.getExpiryDate();

        if(!(cardNumber.equals("") && cardName.equals("") && cardExpiry.equals("MM/YY"))) {

            PreferenceUtils.setPrefCurrentCardNumber(mContext, cardNumber);
            PreferenceUtils.setPrefCurrentCardName(mContext, cardName);
            PreferenceUtils.setPrefCurrentCardExpiry(mContext, cardExpiry);

            Intent intent = new Intent(getApplicationContext(), OtherDetailsActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(mContext, "Please fill in all the details and then proceed",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Formats the watched EditText to a credit card number
     */
    public static class FourDigitCardFormatWatcher implements TextWatcher {

        // Change this to what you want... ' ', '-' etc..
        private static final char space = ' ';

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            // Remove spacing char
            if (s.length() > 0 && (s.length() % 5) == 0) {
                final char c = s.charAt(s.length() - 1);
                if (space == c) {
                    s.delete(s.length() - 1, s.length());
                }
            }
            // Insert char where needed.
            if (s.length() > 0 && (s.length() % 5) == 0) {
                char c = s.charAt(s.length() - 1);
                // Only if its a digit where there should be a space we insert a space
                if (Character.isDigit(c) && TextUtils.split(s.toString(), String.valueOf(space)).length <= 3) {
                    s.insert(s.length() - 1, String.valueOf(space));
                }
            }
        }
    }
}
