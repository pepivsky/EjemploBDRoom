package com.example.pepe.ejemplobdroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfesorLenguajesActivity extends AppCompatActivity {

    @BindView(R.id.profesorId)
    EditText profesorId;
    @BindView(R.id.lenguajeId)
    EditText lenguajeId;
    @BindView(R.id.btnGuardarProfesorLenguaje)
    Button btnGuardarProfesorLenguaje;
    @BindView(R.id.btnMostrarProfesores)
    Button btnMostrarProfesores;
    @BindView(R.id.btnMostrarLenguajes)
    Button btnMostrarLenguajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor_lenguajes);
        ButterKnife.bind(this);
        configurarView();
    }

    private void configurarView(){

    }

    @OnClick(R.id.btnGuardarProfesorLenguaje)
    public void onViewClicked() {
    }
}
