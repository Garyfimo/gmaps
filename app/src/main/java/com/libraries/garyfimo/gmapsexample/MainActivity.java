package com.libraries.garyfimo.gmapsexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.libraries.garyfimo.gmapsexample.gaddressmapexample.AddressActivity;
import com.libraries.garyfimo.gmapsexample.groutemapsexample.BasicExampleActivity;
import com.libraries.garyfimo.gmapsexample.groutemapsexample.ConfigurationExampleActivity;
import com.libraries.garyfimo.gmapsexample.groutemapsexample.WaypointsExampleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.basic_example_button)
    Button mButtonBasicExample;

    @BindView(R.id.configuration_example_button)
    Button mButtonConfigurationExample;

    @BindView(R.id.waypoints_example_button)
    Button mButtonWaypointsExample;

    @BindView(R.id.address_button)
    Button mButtonAddressExample;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.basic_example_button)
    public void onClickBasicExampleButton() {
        startActivity(new Intent(this, BasicExampleActivity.class));
    }

    @OnClick(R.id.configuration_example_button)
    public void onClickconfigurationExampleButton() {
        startActivity(new Intent(this, ConfigurationExampleActivity.class));
    }

    @OnClick(R.id.waypoints_example_button)
    public void onClickWaypointsExampleButton() {
        startActivity(new Intent(this, WaypointsExampleActivity.class));
    }

    @OnClick(R.id.address_button)
    public void onClickAddressExampleButton() {
        startActivity(new Intent(this, AddressActivity.class));
    }
}
