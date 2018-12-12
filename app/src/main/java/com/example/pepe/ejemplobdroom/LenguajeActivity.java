package com.example.pepe.ejemplobdroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LenguajeActivity extends AppCompatActivity {

    @BindView(R.id.edtNombreLenguaje)
    EditText edtNombreLenguaje;
    @BindView(R.id.btnGuardarLenguaje)
    Button btnGuardarLenguaje;
    @BindView(R.id.btnMostrarLenguajes)
    Button btnMostrarLenguajes;
    @BindView(R.id.btnActualizarLenguaje)
    Button btnActualizarLenguaje;
    @BindView(R.id.btnBorrarLenguaje)
    Button btnBorrarLenguaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenguaje);
        ButterKnife.bind(this);
        configView();
    }

    private void configView(){

    }
}
