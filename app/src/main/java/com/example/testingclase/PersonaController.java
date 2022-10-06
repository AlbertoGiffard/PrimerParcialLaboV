package com.example.testingclase;

import android.util.Log;
import android.view.View;

public class PersonaController implements View.OnClickListener {
    private PersonaModel personaModel;
    private PersonaView view;
    private FormularioActivity formularioActivity;

    public PersonaController(PersonaModel personaModel, FormularioActivity formularioActivity) {
        this.personaModel = personaModel;
        this.formularioActivity = formularioActivity;
    }

    public void setView(PersonaView view) {
        this.view = view;
    }

    public void mostrarLog(){
        Log.d("Persona:", personaModel.toString());
    }

    @Override
    public void onClick(View view) {
        if(this.view.setPersonaModel()){
            this.mostrarLog();
            formularioActivity.regresarHome();
        }
    }

    public PersonaModel getPersonaModel() {
        return personaModel;
    }
}
