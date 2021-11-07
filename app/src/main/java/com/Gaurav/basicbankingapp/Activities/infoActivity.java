package com.Gaurav.basicbankingapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.Gaurav.basicbankingapp.R;

public class infoActivity extends AppCompatActivity {

    private TextView tvWhatsapp;
    private TextView tvInstagram;
    private TextView tvFB;
    private TextView tvLinkedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        tvWhatsapp = findViewById(R.id.tvWhatsapp);
        tvInstagram = findViewById(R.id.tvInstagram);
        tvFB = findViewById(R.id.tvFacebook);
        tvLinkedIn = findViewById(R.id.tvLinkedIn);

        tvWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("http://api.whatsapp.com/send?phone=+919970086264&text=Hi Gaurav, I am ...!");
            }
        });

        tvInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("https://instagram.com/gaurav_tiwari_7?utm_medium=copy_link");
            }
        });

        tvFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("https://www.facebook.com/profile.php?id=100008857891238");
            }
        });

        tvLinkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLink("https://www.linkedin.com/in/gaurav-tiwari-845228196");
            }
        });
    }

    private void openLink(String link){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(link));
        startActivity(intent);
    }
}