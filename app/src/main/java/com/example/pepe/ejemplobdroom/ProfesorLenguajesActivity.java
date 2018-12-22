package com.example.pepe.ejemplobdroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pepe.ejemplobdroom.db.database.AppDB;
import com.example.pepe.ejemplobdroom.db.entity.TLenguaje;
import com.example.pepe.ejemplobdroom.db.entity.TProfessor;
import com.example.pepe.ejemplobdroom.db.entity.TProfessorLenguaje;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfesorLenguajesActivity extends AppCompatActivity {


    @BindView(R.id.btnGuardarProfesorLenguaje)
    Button btnGuardarProfesorLenguaje;
    @BindView(R.id.btnMostrarProfesores)
    Button btnMostrarProfesores;
    @BindView(R.id.btnMostrarLenguajes)
    Button btnMostrarLenguajes;
    @BindView(R.id.edtprofesorId)
    EditText edtprofesorId;
    @BindView(R.id.edtlenguajeId)
    EditText edtlenguajeId;

    //Instancia
    private TProfessorLenguaje tProfessorLenguaje;

    //ArrayLists
    private List<TLenguaje> listaLenguajes;
    private List<TProfessor> listaProfesores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor_lenguajes);
        ButterKnife.bind(this);
        configurarView();
    }

    private void configurarView() {
        tProfessorLenguaje = new TProfessorLenguaje();
        listaLenguajes = new ArrayList<>();
        listaProfesores = new ArrayList<>();

    }

    @OnClick(R.id.btnGuardarProfesorLenguaje)
    public void onViewClicked() {
        tProfessorLenguaje.setLenguajeId(Integer.parseInt(edtlenguajeId.getText().toString()));
        tProfessorLenguaje.setProfessorId(Integer.parseInt(edtprofesorId.getText().toString()));

        AppDB.getAppDB(getApplicationContext()).professorLenguajeDAO().insert(tProfessorLenguaje);
        Toast.makeText(this, "Se ha guardado exitosamente :)", Toast.LENGTH_SHORT).show();
    }

    //Muestra todos los profesores que saben un lenguaje
    @OnClick(R.id.btnMostrarProfesores)
    public void mostrarProfessoresPorLenguaje() {
        //Toast.makeText(this, ":)", Toast.LENGTH_SHORT).show();
        listaProfesores = AppDB.getAppDB(getApplicationContext()).professorLenguajeDAO().mostrarProfessoresxLenguaje(4);
        for (TProfessor tProfessor : listaProfesores) {
            Log.d("TAG", "Nombre profesor:" + tProfessor.getNombre());
            Toast.makeText(getApplicationContext(), ":)", Toast.LENGTH_SHORT).show();

        }
    }

    //Muestra todos los lenguajes que sabe un profesor
    @OnClick(R.id.btnMostrarLenguajes)
    public void mostrarLenguajes() {
        listaLenguajes = AppDB.getAppDB(getApplicationContext()).professorLenguajeDAO().mostrarLenguajesxProfesor(2);
        for (TLenguaje tLenguaje: listaLenguajes){
            Log.d("TAG", "Nombre del lenguaje: " + tLenguaje.getNombre());
        }
    }
}
