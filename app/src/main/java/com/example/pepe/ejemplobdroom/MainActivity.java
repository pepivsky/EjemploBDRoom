package com.example.pepe.ejemplobdroom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnProfessor)
    Button btnProfessor;
    @BindView(R.id.btnCurso)
    Button btnCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //configurarView();
    }

    /*private void configurarView() {
    }*/

    @OnClick(R.id.btnProfessor)
    public void onViewClicked() {
        startActivity(new Intent(getApplicationContext(), ProfessorActivity.class));
    }

    @OnClick(R.id.btnCurso)
    public void irCursoActivity() {
        startActivity(new Intent(getApplicationContext(), CursoActivity.class));

    }
}
