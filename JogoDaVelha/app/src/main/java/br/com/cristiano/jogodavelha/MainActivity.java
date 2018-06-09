package br.com.cristiano.jogodavelha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Velha velha;
    private Button btn_0_0;
    private Button btn_0_1;
    private Button btn_0_2;
    private Button btn_1_0;
    private Button btn_1_1;
    private Button btn_1_2;
    private Button btn_2_0;
    private Button btn_2_1;
    private Button btn_2_2;

    private View.OnClickListener onClickBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int pos = 0 ;

            if (v.getId() == R.id.btn_0_0) pos = 0;
            if (v.getId() == R.id.btn_0_1) pos = 1;
            if (v.getId() == R.id.btn_0_2) pos = 2;
            if (v.getId() == R.id.btn_1_0) pos = 3;
            if (v.getId() == R.id.btn_1_1) pos = 4;
            if (v.getId() == R.id.btn_1_2) pos = 5;
            if (v.getId() == R.id.btn_2_0) pos = 6;
            if (v.getId() == R.id.btn_2_1) pos = 7;
            if (v.getId() == R.id.btn_2_2) pos = 8;

            try {
                velha.jogada(pos);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }

            carregarValoresNaGrade(velha);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        velha = new Velha();

        btn_0_0 = findViewById(R.id.btn_0_0);
        btn_0_1 = findViewById(R.id.btn_0_1);
        btn_0_2 = findViewById(R.id.btn_0_2);
        btn_1_0 = findViewById(R.id.btn_1_0);
        btn_1_1 = findViewById(R.id.btn_1_1);
        btn_1_2 = findViewById(R.id.btn_1_2);
        btn_2_0 = findViewById(R.id.btn_2_0);
        btn_2_1 = findViewById(R.id.btn_2_1);
        btn_2_2 = findViewById(R.id.btn_2_2);

        btn_0_0.setOnClickListener(onClickBtn);
        btn_0_1.setOnClickListener(onClickBtn);
        btn_0_2.setOnClickListener(onClickBtn);
        btn_1_0.setOnClickListener(onClickBtn);
        btn_1_1.setOnClickListener(onClickBtn);
        btn_1_2.setOnClickListener(onClickBtn);
        btn_2_0.setOnClickListener(onClickBtn);
        btn_2_1.setOnClickListener(onClickBtn);
        btn_2_2.setOnClickListener(onClickBtn);


        carregarValoresNaGrade(velha);




    }

    private void carregarValoresNaGrade(Velha velha) {

       btn_0_0.setText(velha.pontos[0].valor);
       btn_0_1.setText(velha.pontos[1].valor);
       btn_0_2.setText(velha.pontos[2].valor);
       btn_1_0.setText(velha.pontos[3].valor);
       btn_1_1.setText(velha.pontos[4].valor);
       btn_1_2.setText(velha.pontos[5].valor);
       btn_2_0.setText(velha.pontos[6].valor);
       btn_2_1.setText(velha.pontos[7].valor);
       btn_2_2.setText(velha.pontos[8].valor);


    }


}




















