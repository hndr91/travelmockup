package com.tgwarrior.travelmockup;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends ActionBarActivity {

    public static final String FROM = "from";

    @BindView(R.id.getTaxi) LinearLayout getTaxi;
    @BindView(R.id.getBike) LinearLayout getBike;
    @BindView(R.id.driverBtn) Button driverBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), AgreementActivity.class);
                i.putExtra(FROM, Constants.FROM_TAXI);
                startActivity(i);
            }
        });

        getBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), AgreementActivity.class);
                i.putExtra(FROM, Constants.FROM_BIKE);
                startActivity(i);
            }
        });

        driverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
