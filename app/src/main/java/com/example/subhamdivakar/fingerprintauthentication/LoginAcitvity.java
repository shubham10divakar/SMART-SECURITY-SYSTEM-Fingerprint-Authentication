package com.example.subhamdivakar.fingerprintauthentication;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import led.DeviceList;

public class LoginAcitvity extends AppCompatActivity {
    EditText password1;
    int p=0;
    int ar[] = new int[100000], i;
    static final int REQUEST_VIDEO_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acitvity);
        password1 = (EditText) findViewById(R.id.editText);
        Button btn;
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "AUTHENCATING", Toast.LENGTH_SHORT).show();
                password(null);
            }
        });
    }
    public void password(View view)
    {
        p++;
        if(p<=3) {
            String pass = password1.getText().toString();
            int passf = Integer.parseInt(pass);

            int ctr = 1111;
            for (i = 0; i < 100000; i++) {
                ar[i] = ctr;
                ctr++;
            }
            if (passf >= 1111 && passf <= 9999) {
                for (i = 0; i < 100000; i++) {
                    if (passf == ar[i]) {
                        Toast.makeText(getBaseContext(), "CONGRATS PASSWORD ACCEPTED", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(this, DeviceList.class);
                        startActivity(i);
                        break;
                    }
                }
            } else {
                Toast.makeText(getBaseContext(), "WRONG PASSWORD TRY AGAIN", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            Toast.makeText(getBaseContext(), "SORRY YOU HAVE ATTEMPTED MORE THAN 3 times.", Toast.LENGTH_SHORT).show();
            finish();
//            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//            startActivity(intent);


            Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
            }

        }

    }
}
