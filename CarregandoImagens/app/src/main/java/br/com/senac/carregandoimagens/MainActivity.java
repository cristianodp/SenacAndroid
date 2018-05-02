package br.com.senac.carregandoimagens;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private Button buttonCarro;
    private Button buttonBicicleta;
    private ImageView imageView;

    ///declare
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCarro = findViewById(R.id.buttonCarro);
        buttonBicicleta = findViewById(R.id.buttonBicicleta);
        imageView = findViewById(R.id.imageView);

        //configurar a liguagem
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.ITALY );
                    textToSpeech.setSpeechRate(0.5f);
                }
            }
        });


        buttonCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textToSpeech.speak("porco dio", TextToSpeech.QUEUE_FLUSH, null);
                Picasso.get().load("http://www.radarnacional.com.br/wp-content/uploads/2016/01/100_0799_original-800x500_c.jpg").into(imageView);
            }
        });

        buttonBicicleta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(getResources().getString(R.string.bicicleta), TextToSpeech.QUEUE_FLUSH, null);
                Picasso.get().load("http://i3-decathlon.a8e.net.br/gm/bicicleta-feminina-mountain-bike-aro-27-5-rockrider-540-btwin_153203670_1864086.jpg").into(imageView);
            }
        });

    }
}
