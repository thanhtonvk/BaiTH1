package com.tondz.baith1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edt_phonenumber,edt_content,edt_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},123);
        edt_phonenumber= findViewById(R.id.edt_phonenumber);
        edt_content = findViewById(R.id.edt_content);
        edt_email = findViewById(R.id.edt_email);
        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriSms = Uri.parse("smsto:"+edt_phonenumber.getText().toString());
                Intent intent = new Intent(Intent.ACTION_SENDTO,uriSms);
                intent.putExtra("sms_body",edt_content.getText().toString());
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_sendemail).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to = edt_email.getText().toString();
                String subject= "E cu";
                String body=edt_content.getText().toString();
                String mailTo = "mailto:" + to +
                        "?&subject=" + Uri.encode(subject) +
                        "&body=" + Uri.encode(body);
                Intent emailIntent = new Intent(Intent.ACTION_VIEW);
                emailIntent.setData(Uri.parse(mailTo));
                startActivity(emailIntent);
            }
        });
        findViewById(R.id.btn_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+edt_phonenumber.getText().toString()));
                startActivity(intent);
            }
        });
    }
}