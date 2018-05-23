package com.example.shawnkuo.bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView tx_Result = (TextView)findViewById(R.id.tx_Result);
        Intent intent = getIntent();
//        float bmi = intent.getFloatExtra("BMI_EXTRA", 0);
        Bundle bag = intent.getExtras();
        float bmi = bag.getFloat("BMI_EXTRA", 0);
        String name = bag.getString("NAME_EXTRA", null);
        tx_Result.setText("Hi~" + name + "   您的BMI值為：" + bmi);
//        tx_Result.setText("您的BMI值為："+bmi);
    }
}
