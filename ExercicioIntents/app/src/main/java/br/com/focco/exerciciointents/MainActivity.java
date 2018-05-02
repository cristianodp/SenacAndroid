package br.com.focco.exerciciointents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static android.content.Intent.ACTION_VIEW;

public class MainActivity extends AppCompatActivity{

    Button buttonGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonGoogle = findViewById(R.id.buttonGoogle);
        buttonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com");
                Intent i = new Intent(ACTION_VIEW, uri);
                startActivity(i);
            }
        });

    }
}
