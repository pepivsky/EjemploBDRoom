package com.example.pepe.ejemplobdroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pepe.ejemplobdroom.db.database.AppDB;
import com.example.pepe.ejemplobdroom.db.entity.TLenguaje;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    private TLenguaje tLenguaje;
    private List<TLenguaje> listaLenguajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenguaje);
        ButterKnife.bind(this);
        configView();
    }

    private void configView() {
        tLenguaje = new TLenguaje();
        listaLenguajes = new ArrayList<>();


    }

    @OnClick(R.id.btnGuardarLenguaje)
    public void guardarLeguaje() {
        tLenguaje.setNombre(edtNombreLenguaje.getText().toString());
        AppDB.getAppDB(getApplicationContext()).lenguajeDAO().insert(tLenguaje);
        Toast.makeText(getApplicationContext(), "Se ha guardado exitosamente", Toast.LENGTH_SHORT).show();
    }

    
}
