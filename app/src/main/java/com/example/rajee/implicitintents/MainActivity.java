package com.example.rajee.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_launch = (Button) findViewById(R.id.launch);
        btn_launch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText link = (EditText) findViewById(R.id.url_link);
                Intent intent_launch = new Intent(Intent.ACTION_VIEW, Uri.parse(link.getText().toString()));
                Intent chooser = Intent.createChooser(intent_launch, "SELECT BROWSER");
                if(intent_launch.resolveActivity(getPackageManager()) != null){
                    startActivity(chooser);
                }
            }
        });

        Button btn_ring = (Button) findViewById(R.id.ring);
        btn_ring.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText phone_number = (EditText) findViewById(R.id.phone_number);
                Intent intent_ring = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone_number.getText().toString()));
                Intent chooser = Intent.createChooser(intent_ring, "SELECT APP TO CALL");
                if(intent_ring.resolveActivity(getPackageManager()) != null){
                    startActivity(chooser);
                }
            }
        });

        Button btn_close = (Button) findViewById(R.id.close_app);
        btn_close.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
