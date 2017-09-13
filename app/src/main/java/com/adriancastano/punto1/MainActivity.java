package com.adriancastano.punto1;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioButton rCuadro, rCirculo, rTriangulo, rCubo;
    private RadioGroup rGroup;
    private ImageView iImagen;
    private LinearLayout lCirculo, lComun, lTriangulo;
    private EditText eR, eL, eLA, eLB, eLC;
    private TextView tResultado;

    private double perimetro, area, volumen, aux, a, b, c, s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rCuadro = (RadioButton) findViewById(R.id.rCuadro);
        rCirculo = (RadioButton) findViewById(R.id.rCirculo);
        rTriangulo = (RadioButton) findViewById(R.id.rTriangulo);
        rCubo = (RadioButton) findViewById(R.id.rCubo);

        rGroup = (RadioGroup) findViewById(R.id.rGroup);

        iImagen = (ImageView) findViewById(R.id.iImagen);

        lCirculo = (LinearLayout) findViewById(R.id.lCirculo);
        lComun = (LinearLayout) findViewById(R.id.lComun);
        lTriangulo = (LinearLayout) findViewById(R.id.lTriangulo);

        eL = (EditText) findViewById(R.id.eL);
        eR = (EditText) findViewById(R.id.eR);
        eLA = (EditText) findViewById(R.id.eLA);
        eLB = (EditText) findViewById(R.id.eLB);
        eLC = (EditText) findViewById(R.id.eLC);

        tResultado = (TextView) findViewById(R.id.tResultado);

        lCirculo.setVisibility(View.INVISIBLE);
        lTriangulo.setVisibility(View.INVISIBLE);
        lComun.setVisibility(View.INVISIBLE);


        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                lCirculo.setVisibility(View.INVISIBLE);
                lTriangulo.setVisibility(View.INVISIBLE);
                lComun.setVisibility(View.INVISIBLE);

                tResultado.setText("");

                if (rCuadro.isChecked()) {
                    iImagen.setImageDrawable(getDrawable(R.drawable.cuadro));
                    lComun.setVisibility(View.VISIBLE);
                }

                if (rCirculo.isChecked()) {
                    iImagen.setImageDrawable(getDrawable(R.drawable.circulo));
                    lCirculo.setVisibility(View.VISIBLE);
                }

                if (rTriangulo.isChecked()) {
                    iImagen.setImageDrawable(getDrawable(R.drawable.triangulo));
                    lTriangulo.setVisibility(View.VISIBLE);
                }

                if (rCubo.isChecked()) {
                    iImagen.setImageDrawable(getDrawable(R.drawable.cubo));
                    lComun.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    public void calcular(View view) {

        if (eL.getText().toString().equals("") && eR.getText().toString().equals("") &&
        eLA.getText().toString().equals("") && eLB.getText().toString().equals("") &&
        eLC.getText().toString().equals(""))
            tResultado.setText("Ingrese todos los datos");

        else {

            if (rCuadro.isChecked()) {
                aux = Double.valueOf(eL.getText().toString());
                perimetro = aux * 4;
                area = aux * aux;
                tResultado.setText("Perimetro: " + perimetro + "\nÁrea: " + area);
            }

            if (rCirculo.isChecked()) {
                aux = Double.valueOf(eR.getText().toString());
                perimetro = aux * 2 * Math.PI;
                area = aux * aux * Math.PI;
                tResultado.setText("Perimetro: " + perimetro + "\nÁrea: " + area);
            }

            if (rTriangulo.isChecked()) {
                a = Double.valueOf(eLA.getText().toString());
                b = Double.valueOf(eLB.getText().toString());
                c = Double.valueOf(eLC.getText().toString());
                perimetro = a + b + c;
                s = perimetro / 2;
                area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                tResultado.setText("Perimetro: " + perimetro + "\nÁrea: " + area);
            }

            if (rCubo.isChecked()) {
                aux = Integer.valueOf(eL.getText().toString());
                perimetro = aux * 12;
                area = aux * aux * 6;
                volumen = aux * aux * aux;
                tResultado.setText("Perimetro: " + perimetro + "\nÁrea: " + area + "\nVolumen: " + volumen);
            }
        }

    }
}
