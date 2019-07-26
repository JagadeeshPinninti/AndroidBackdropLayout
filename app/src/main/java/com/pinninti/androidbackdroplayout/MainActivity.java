package com.pinninti.androidbackdroplayout;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.roacult.backdrop.BackdropLayout;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    BackdropLayout backdropLayout;

    RadioButton rdi_apple, rdi_orange, rdi_watermelon,rdi_picture_one,rdi_picture_two;

    TextView txt_result;
    ImageView img_result;

    View back_layout,front_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backdropLayout=(BackdropLayout) findViewById(R.id.container);

        back_layout=backdropLayout.getChildAt(0);
        front_layout=backdropLayout.getChildAt(1);

        rdi_apple=findViewById(R.id.rdi_apple);
        rdi_orange=findViewById(R.id.rdi_orange);
        rdi_watermelon=findViewById(R.id.rdi_watermelon);
        rdi_picture_one=findViewById(R.id.rdi_picture_one);
        rdi_picture_two=findViewById(R.id.rdi_picture_two);

        txt_result=front_layout.findViewById(R.id.txt_result);
        img_result=front_layout.findViewById(R.id.img_result);

        rdi_watermelon.setOnCheckedChangeListener(this);
        rdi_orange.setOnCheckedChangeListener(this);
        rdi_apple.setOnCheckedChangeListener(this);

        MyImageChecked myImageChecked=new MyImageChecked();
        rdi_picture_one.setOnCheckedChangeListener(myImageChecked);
        rdi_picture_two.setOnCheckedChangeListener(myImageChecked);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){
            txt_result.setText(buttonView.getText());
        }
    }

    private class MyImageChecked implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(buttonView.getId()==R.id.rdi_picture_one){
                img_result.setImageResource(R.drawable.ic_launcher_background);
            }
            else {
                img_result.setImageResource(R.drawable.ic_launcher_foreground);
            }
        }
    }
}

//https://www.youtube.com/watch?v=mLpHRUZ3iTo

//Backdrop Layout

//A backdrop appears behind all other surfaces in an app, displaying contextual and actionable content.