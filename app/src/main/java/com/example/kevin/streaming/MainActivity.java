package com.example.kevin.streaming;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button noti,documnetales,music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noti = (Button)findViewById(R.id.noticias);
        documnetales = (Button)findViewById(R.id.documentales);
        music = (Button)findViewById(R.id.musica);

        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Class_tv.class);
                startActivity(intent);
            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Musica.class);
                startActivity(intent);
            }
        });

        documnetales.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(),Documentales.class);
        startActivity(intent);
    }
}
