package getpaybucks.paybucks_consumer.demo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.InjectView;
import butterknife.OnClick;
import getpaybucks.paybucks_consumer.R;
import getpaybucks.paybucks_consumer.demo.Util.Connectivity;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.wallet_payment) Button mWallet;
    @InjectView(R.id.card_payment) Button mCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Connectivity.isConnected(getApplicationContext())) {
            mWallet.setVisibility(View.VISIBLE);
        }
        else{
            mWallet.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.wallet_payment)
    public void wallet(){
        // TODO Redirect to wallet payment
    }
    @OnClick(R.id.card_payment)
    public void card() {
        Intent intent = new Intent(getApplicationContext(), CardDetailsActivity.class);
        startActivity(intent);
    }
}
