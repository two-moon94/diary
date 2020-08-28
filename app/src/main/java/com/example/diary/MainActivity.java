package com.example.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final int REQ_ADD_CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_add = (Button) findViewById(R.id.bt_add);
        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivityForResult(intent, REQ_ADD_CONTACT);
            }
        });
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if(requestCode == REQ_ADD_CONTACT) {
            if(resultCode == RESULT_OK) {
                TextView tv_no = (TextView) findViewById(R.id.tv_no);
                int no = intent.getIntExtra("contact_no", 0);
                tv_no.setText(Integer.toString(no));

                TextView tv_name = (TextView) findViewById(R.id.tv_name);
                String name = intent.getStringExtra("contact_name");
                if (name != null)
                    tv_name.setText(name);

                TextView tv_phone = (TextView) findViewById(R.id.tv_phone);
                String phone = intent.getStringExtra("contact_phone");
                if (phone != null)
                    tv_name.setText(phone);

                TextView tv_over= (TextView) findViewById(R.id.tv_over) ;
                boolean over20 = intent.getBooleanExtra("contact_over", false) ;
                if (over20)
                    tv_over.setText("Over 20") ;
                else
                    tv_over.setText("Not over 20") ;
            }
        }
    }
}