package com.example.pepe.ejemplobdroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pepe.ejemplobdroom.db.database.AppDB;
import com.example.pepe.ejemplobdroom.db.entity.TCurso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CursoActivity extends AppCompatActivity {


    @BindView(R.id.edtIdProfessor)
    EditText edtIdProfessor;
    @BindView(R.id.edtNombreCurso)
    EditText edtNombreCurso;
    @BindView(R.id.edtDuracionCurso)
    EditText edtDuracionCurso;
    @BindView(R.id.btnGuardarCurso)
    Button btnGuardarCurso;
    @BindView(R.id.btnLeerCurso)
    Button btnLeerCurso;
    @BindView(R.id.btnActualizarCurso)
    Button btnActualizarCurso;
    @BindView(R.id.btnBorrarrCurso)
    Button btnBorrarrCurso;

    private TCurso tCurso;
    private List<TCurso> listaCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);
        ButterKnife.bind(this);
        configurarView();
    }

    public void configurarView() {
        tCurso = new TCurso();
        listaCursos = new ArrayList<>();
    }

    @OnClick(R.id.btnGuardarCurso)
    public void onViewClicked() {
        tCurso.setDuracion(edtDuracionCurso.getText().toString());
        tCurso.setNombre(edtNombreCurso.getText().toString());
        tCurso.setProfessorId(Integer.parseInt(edtIdProfessor.getText().toString()));
        AppDB.getAppDB(getApplicationContext()).cursoDAO().insert(tCurso);
        Toast.makeText(this, "Se ha guardado exitosamente", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnLeerCurso)
    public void leerCursoxProfessor() {
        listaCursos = AppDB.getAppDB(getApplicationContext()).cursoDAO().buscarCursosPorProfessor(Integer.parseInt(edtIdProfessor.getText().toString()));
        for (TCurso tCurso:listaCursos) {
            Log.d("TAG", "id:" + tCurso.getId() + " Nombre:" + tCurso.getNombre() + " Duración:" + tCurso.getDuracion() + " ProfessorId:" + tCurso.getProfessorId());

        }
    }

    @OnClick(R.id.btnActualizarCurso)
    public void ActualizarCursoxId() {
        //Se actualiza el curso con el Id 2
        tCurso.setId(2);
        tCurso.setNombre("Japones");
        tCurso.setDuracion("14");
        tCurso.setProfessorId(2);
        AppDB.getAppDB(getApplicationContext()).cursoDAO().updateCursoPorId(tCurso);
        Toast.makeText(this, "Se ha actualizado exitosamente", Toast.LENGTH_SHORT).show();

    }
}
