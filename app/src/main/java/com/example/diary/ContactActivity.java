package com.example.diary;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button bt_save = (Button) findViewById(R.id.bt_save);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                EditText et_no = (EditText) findViewById(R.id.et_no);
                String strNo = et_no.getText().toString();
                if(!strNo.isEmpty() && strNo.matches("^[0-9]")) {
                    intent.putExtra("contact_no", Integer.parseInt(strNo));
                } else {
                    intent.putExtra("contact_no", 0) ;
                }

                EditText et_name = (EditText) findViewById(R.id.et_name);
                intent.putExtra("contact_name", et_name.getText().toString());

                EditText et_phone = (EditText) findViewById(R.id.et_phone);
                intent.putExtra("contact_phone", et_phone.getText().toString());

                CheckBox cb_over = (CheckBox) findViewById(R.id.cb_over);
                intent.putExtra("contact_over", cb_over.isChecked());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}