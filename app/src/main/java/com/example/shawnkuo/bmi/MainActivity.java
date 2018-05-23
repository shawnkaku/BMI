package com.example.shawnkuo.bmi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    private EditText ed_weight;
    private EditText ed_height;
    private Button btn_help;
    private Button btn_calculate;
    private Button btn_result;
    private Bundle bag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage(fbmi()+"")
                        .setTitle("BMI Calcuate")
                        .setPositiveButton("OK",null)
                        .show();
            }
        });
    }

    public void showReslut(View v){
        Intent intent= new Intent(this, ResultActivity.class);
//        intent.putExtra("BMI_EXTRA", fbmi());
        bag = new Bundle();
        bag.putFloat("BMI_EXTRA", fbmi());
        bag.putString("NAME_EXTRA", "Shawn");
        intent.putExtras(bag);
        startActivity(intent);
    }
    public void bmi(View v){
        new AlertDialog.Builder(this)
                .setMessage(fbmi()+"")
                .setTitle("BMI Calcuate")
                .setPositiveButton("OK",null)
                .show();
//        Toast.makeText(this, String.valueOf(bmi), Toast.LENGTH_LONG).show();
//        Log.d("BMI", String.valueOf(bmi));
    }
    private float fbmi(){
        String w = ed_weight.getText().toString();
        String h = ed_height.getText().toString();
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight /(height*height);
        return bmi;
    }
    private void findViews() {
        ed_weight = (EditText)findViewById(R.id.ed_weight);
        ed_height = (EditText)findViewById(R.id.ed_height);
        btn_help = (Button)findViewById(R.id.btn_help);
        btn_calculate = (Button)findViewById(R.id.btn_calculate);
        btn_result = (Button)findViewById(R.id.btn_result);
    }
}
