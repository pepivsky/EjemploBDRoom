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

    @OnClick(R.id.btnMostrarLenguajes)
    public void onViewClicked() {
        listaLenguajes = AppDB.getAppDB(getApplicationContext()).lenguajeDAO().mostrarLenguajes();
        for (TLenguaje tLenguaje : listaLenguajes) {
            Log.d("TAG", "id:" + tLenguaje.getId() + " Nombre:" + tLenguaje.getNombre());
        }
    }

    @OnClick(R.id.btnActualizarLenguaje)
    public void actualizarLenguajexId() {
        //Actualiza el lenguaje con id = 1
        tLenguaje.setId(1);
        tLenguaje.setNombre("Phyton");
        AppDB.getAppDB(getApplicationContext()).lenguajeDAO().actualizarLenguajePorId(tLenguaje);
        Log.d("TAG", "Se ha actualizado correctamente" );


    }

    @OnClick(R.id.btnBorrarLenguaje)
    public void borrarLenguajexId() {
        //Borra el lenguaje con el id = 1
        tLenguaje.setId(1);
        AppDB.getAppDB(getApplicationContext()).lenguajeDAO().borrarLenguajePorId(tLenguaje);
        Log.d("TAG", "Se ha borrado correctamente");

    }
}
