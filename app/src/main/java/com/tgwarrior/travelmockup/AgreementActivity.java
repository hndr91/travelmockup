package com.tgwarrior.travelmockup;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class AgreementActivity extends ActionBarActivity {

    @BindView(R.id.okBtn) Button okBtn;
    @BindView(R.id.cancelBtn) Button cancelBtn;
    @BindView(R.id.title) TextView title;
    @BindView(R.id.rate_content) TextView rateContent;

    @BindString(R.string.car) String carTitle;
    @BindString(R.string.rate_content_car) String contentCar;
    @BindString(R.string.bike) String bikeTitle;
    @BindString(R.string.rate_content_bike) String contentBike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        int message = bundle.getInt(MainActivity.FROM);

        if(message == 0) {
            title.setText(carTitle);
            rateContent.setText(contentCar);
        } else {
            title.setText(bikeTitle);
            rateContent.setText(contentBike);
        }
    }
}