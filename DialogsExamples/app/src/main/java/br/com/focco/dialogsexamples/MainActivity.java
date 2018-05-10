package br.com.focco.dialogsexamples;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonAlertSimple;
    private Button buttonQuestionAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAlertSimple = findViewById(R.id.buttonAlertSimple);
        buttonAlertSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //callSimpleAlert("Ola Mundo");
                callQuestionAlert("Diga Ola mundo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // MainActivity.this.finish();
                        Toast.makeText(MainActivity.this,"Ola mundo",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        buttonQuestionAlert = findViewById(R.id.buttonQuestionAlert);
        buttonQuestionAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callQuestionAlert("Deseja sair do aplicativo?", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity.this.finish();
                    }
                });
            }
        });

    }

    private void callQuestionAlert(String msg,View.OnClickListener clickListenerOK) {


        final Dialog dialog =new Dialog(this);
        dialog.setContentView(R.layout.layout_question_alert);
        TextView titleTextView = dialog.findViewById(R.id.title_text_view);
        Button btnOk = dialog.findViewById(R.id.ok_button);
        Button btnCanc = dialog.findViewById(R.id.canc_button);
        btnOk.setText("OK");
        btnCanc.setText("Cancelar");

        titleTextView.setText(msg);

        btnOk.setOnClickListener(clickListenerOK);

        btnCanc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        dialog.show();

    }

    private void callSimpleAlert(String msg) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_simple_alert);

        //dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        TextView tile_text_view = dialog.findViewById(R.id.tile_text_view);
        Button button = dialog.findViewById(R.id.label_button);
        tile_text_view.setText(msg);

        button.setText("OK");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        dialog.show();
    }
}
