package com.example.testingclase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class FormularioActivity extends AppCompatActivity {
    private PersonaModel objetoRecibido;
    private PersonaController controller;
    private PersonaView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        //para obtener los datos del actitivyt anterior
        Bundle bundle = super.getIntent().getExtras();
        this.objetoRecibido = new PersonaModel("", "", "");

        if (super.getIntent().hasExtra("persona")){
            this.objetoRecibido = (PersonaModel)bundle.getSerializable("persona");
            this.instanciarForm(this.objetoRecibido);
            this.view.setCamposObjeto();
        } else {
            this.instanciarForm(this.objetoRecibido);
        }

        ActionBar actionBar = super.getSupportActionBar();

        //cambiar nombre
        actionBar.setTitle(R.string.form_name);
        //bundle.getInt("edad");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    public void instanciarForm(PersonaModel objetoRecibido){
        this.controller = new PersonaController(objetoRecibido, this);
        this.view = new PersonaView(this, objetoRecibido, controller);
        controller.setView(view);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            Log.d("click", "en home");
            //para finalizar esta activity y regrese a la anterior

            //pasar datos al retorno
            /*PersonaModel perAux =  this.controller.getPersonaModel();
            MainActivity.personaModel = new PersonaModel(perAux.getNombre(),perAux.getApellido());*/
            MainActivity.personaPosicion = -2;
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void regresarHome(){
        //para finalizar esta activity y regrese a la anterior

        //pasar datos al retorno
        this.objetoRecibido = this.controller.getPersonaModel();
        MainActivity.personaModel = new PersonaModel(objetoRecibido.getNombre(),objetoRecibido.getContrasenia(), objetoRecibido.getTipo());
        finish();
    }
}