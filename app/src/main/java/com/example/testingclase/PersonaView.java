package com.example.testingclase;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class PersonaView {
    PersonaModel personaModel;
    Activity activity;
    Button btnGuardar;

    public PersonaView(Activity activity, PersonaModel personaModel, PersonaController controller) {
        this.activity = activity;
        this.personaModel = personaModel;

        btnGuardar = this.activity.findViewById(R.id.btnGuardarForm);
        btnGuardar.setOnClickListener(controller);
    }

    public Boolean setPersonaModel(){
        Boolean resultado = false;

        if (this.mismaContrasenia()){
            if (this.setNombrePorActivity()) {
                resultado = true;
                this.setContraseniaPorActivity();
                this.setTipoPorActivity();
            } else {
                alertView("Usuario muy corto");
            }
        } else {
            alertView("Contraseñas distintas");
        }

        return resultado;
    }

    public Boolean setNombrePorActivity() {
        Boolean resultado = false;
        EditText nombre = this.activity.findViewById(R.id.nombreForm);

        if (nombre.length() > 2){
            resultado = true;
            this.personaModel.setNombre(nombre.getText().toString());
        }
        return resultado;
    }

    public void setContraseniaPorActivity() {
        EditText contrasenia = this.activity.findViewById(R.id.contraseniaForm);
        this.personaModel.setContrasenia(contrasenia.getText().toString());
    }

    public Boolean mismaContrasenia(){
        EditText contrasenia = this.activity.findViewById(R.id.contraseniaForm);
        EditText contraseniaRepetida = this.activity.findViewById(R.id.contraseniaRepetidaForm);
        Boolean resultado = false;

        if (contrasenia.getText().toString().equals(contraseniaRepetida.getText().toString())){
            resultado = true;
        }

        return resultado;
    }

    /*public void setDniPorActivity() {
        EditText dniTxt = this.activity.findViewById(R.id.dniForm);
        Integer dni = Integer.valueOf(dniTxt.getText().toString());
        this.personaModel.setDni(dni);
    }*/

    public void setTipoPorActivity() {
        RadioButton administrador = (RadioButton)this.activity.findViewById(R.id.radioAdministradorForm);
        String tipo = "Usuario";

        if (administrador.isChecked()) {
            tipo = "Administrador";
        }

        this.personaModel.setTipo(tipo);
    }

    public void setTipoRadio(){
        String tipo = this.personaModel.getTipo();
        RadioButton radioAdministrador = (RadioButton)this.activity.findViewById(R.id.radioAdministradorForm);
        RadioButton radioUsuario = (RadioButton)this.activity.findViewById(R.id.radioUsuarioForm);

        if (tipo.equals("Administrador")){
            radioAdministrador.setChecked(true);
            radioUsuario.setChecked(false);
            Log.d("tipo", tipo);
        } else {
            radioUsuario.setChecked(true);
            radioAdministrador.setChecked(false);
        }
    }

    public void setCamposObjeto(){
        EditText contrasenia = this.activity.findViewById(R.id.contraseniaForm);
        EditText nombre = this.activity.findViewById(R.id.nombreForm);
        contrasenia.setText(this.personaModel.getContrasenia());
        nombre.setText(this.personaModel.getNombre());
        this.setTipoRadio();
    }

    private void alertView( String message ) {
        AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
        alertDialog.setTitle("Error");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
