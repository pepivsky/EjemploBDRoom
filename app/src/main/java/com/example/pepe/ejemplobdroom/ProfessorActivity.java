package com.example.pepe.ejemplobdroom;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pepe.ejemplobdroom.db.database.AppDB;
import com.example.pepe.ejemplobdroom.db.entity.TProfessor;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfessorActivity extends AppCompatActivity {

    @BindView(R.id.edtNombre)
    EditText edtNombre;
    @BindView(R.id.edtEmail)
    EditText edtEmail;
    @BindView(R.id.btnGuardar)
    Button btnGuardar;
    @BindView(R.id.btnLeer)
    Button btnLeer;
    @BindView(R.id.btnBuscarPorNombre)
    Button btnBuscarPorNombre;
    @BindView(R.id.btnBuscarPorId)
    Button btnBuscarPorId;
    @BindView(R.id.btnActualizar)
    Button btnActualizarporId;
    @BindView(R.id.btnBorrarPorId)
    Button btnBorrarPorId;
    @BindView(R.id.btnBorrarTodo)
    Button btnBorrarTodo;

    private TProfessor tProfessor;
    private List<TProfessor> listaProfessors;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);
        ButterKnife.bind(this);
        configurarView();
    }

    public void configurarView() {
        tProfessor = new TProfessor();
        listaProfessors = new ArrayList<>();
    }



    @OnClick(R.id.btnGuardar)
    public void onViewClicked() {

        tProfessor.setNombre(edtNombre.getText().toString());
        tProfessor.setEmail(edtEmail.getText().toString());
        EscribirBaseDatosTask escribirBaseDatosTask = new EscribirBaseDatosTask();
        escribirBaseDatosTask.execute(tProfessor);

        Toast.makeText(this, "Se ha guardado exitosamente", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnLeer)
    public void onViewClickedBtnLeer() {
        LeerBaseDatosTask leerBaseDatosTask = new LeerBaseDatosTask();
        leerBaseDatosTask.execute();

    }

    @OnClick(R.id.btnBuscarPorNombre)
    public void onViewClickedBtnBuscarXNombre() {
        //tProfessor = AppDB.getAppDB(getApplicationContext()).professorDAO().findProfessorbyName(edtNombre.getText().toString());
        //mostrarUnProfessor(tProfessor);
        BuscarPorNombre buscarPorNombre = new BuscarPorNombre();
        buscarPorNombre.execute();
    }



    @OnClick(R.id.btnBuscarPorId)
    public void onViewClickedBuscarPorId() {
        /*tProfessor = AppDB.getAppDB(getApplicationContext()).professorDAO().findProfessorbyID(1);
        mostrarUnProfessor(tProfessor);*/
        BuscarPorId buscarPorId = new BuscarPorId();
        buscarPorId.execute();

    }
    private void mostrarUnProfessor(TProfessor tProfessor) {
        Log.d("TAG", "Nombre:" + tProfessor.getNombre() + " Email:" + tProfessor.getEmail() + "\n");

    }


    @OnClick(R.id.btnActualizar)
    public void ActualizarporId() {
        TProfessor tProfessor = new TProfessor();
        tProfessor.setId(1);
        tProfessor.setNombre("Ernesto");
        tProfessor.setEmail("ernest@gmail.com");
    }

    @OnClick(R.id.btnBorrarPorId)
    public void borrarPorId() {
        TProfessor tProfessor = new TProfessor();
        tProfessor.setId(2);
        AppDB.getAppDB(getApplicationContext()).professorDAO().deleteProfessorbyID(tProfessor);
    }

    @OnClick(R.id.btnBorrarTodo)
    public void borrarTodo() {
        //AppDB.getAppDB(getApplicationContext()).professorDAO().deleteAllProfessor();
        BorrarTodo borrarTodo = new BorrarTodo();
        borrarTodo.execute();
    }



    //Guardar registros
    //Clase para hacer el proseso en un hilo secundario (segundo plano
    private class EscribirBaseDatosTask extends AsyncTask<TProfessor, Void, Void> {

        @Override //Ejecucion en segundo plano
        protected Void doInBackground(TProfessor... tProfessors) {
            AppDB.getAppDB(getApplicationContext()).professorDAO().insertProfessor(tProfessors[0]);
            return null;
        }
    }


    private class LeerBaseDatosTask extends AsyncTask<Void, Void, List<TProfessor>> {

        @Override
        protected List<TProfessor> doInBackground(Void... voids) {
            listaProfessors = AppDB.getAppDB(getApplicationContext()).professorDAO().findAllProfessor();
            return listaProfessors;
        }

        //Metodo en el hilo principal
        @Override
        protected void onPostExecute(List<TProfessor> professors) {
            showProfessor(professors);
        }

        private void showProfessor(List<TProfessor> professors) {
            for (TProfessor professor : professors) {
                Log.d("TAG", "Nombre:" + professor.getNombre() + " Email:" + professor.getEmail() + " ID: " + professor.getId() + "\n");
            }
        }

    }

    private class BorrarTodo extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            AppDB.getAppDB(getApplicationContext()).professorDAO().deleteAllProfessor();
            return null;
        }
    }



    private class BuscarPorNombre extends AsyncTask<Void, Void, TProfessor>{

        @Override
        protected TProfessor doInBackground(Void... voids) {
            tProfessor = AppDB.getAppDB(getApplicationContext()).professorDAO().findProfessorbyName(edtNombre.getText().toString());
            return tProfessor;
        }

        //Metodo que se ejecuta automaticamente despues de "doInBackground"
        @Override
        protected void onPostExecute(TProfessor tProfessor) {
            Log.d("TAG", "Nombre:" + tProfessor.getNombre() + " Email:" + tProfessor.getEmail() + "\n");
        }
    }



    private class BuscarPorId extends AsyncTask<Void, Void, TProfessor>{

        @Override
        protected TProfessor doInBackground(Void... voids) {
            //tProfessor = AppDB.getAppDB(getApplicationContext()).professorDAO().findProfessorbyName(edtNombre.getText().toString());
            tProfessor = AppDB.getAppDB(getApplicationContext()).professorDAO().findProfessorbyID(1);
            return tProfessor;
        }

        //Metodo que se ejecuta automaticamente despues de "doInBackground"
        @Override
        protected void onPostExecute(TProfessor tProfessor) {
            Log.d("TAG", "Nombre:" + tProfessor.getNombre() + " Email:" + tProfessor.getEmail() + "\n");
        }
    }


}