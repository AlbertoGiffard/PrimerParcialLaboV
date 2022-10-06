package com.example.testingclase;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PersonaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView tvContrasenia;
    TextView tvTipo;
    TextView tvNombre;
    ImageButton iBtnEditar;
    //ImageButton iBtnBorrar;
    MainActivity mainActivity;

    public PersonaViewHolder(View itemView, MainActivity mainActivity) {
        super(itemView);
        this.tvContrasenia = itemView.findViewById(R.id.tvContrasenia);
        this.tvTipo = itemView.findViewById(R.id.tvTipo);
        this.tvNombre = itemView.findViewById(R.id.tvNombre);
        this.iBtnEditar = itemView.findViewById(R.id.btnEditar);
        //this.iBtnBorrar = itemView.findViewById(R.id.btnEliminar);
        this.mainActivity = mainActivity;

        //itemView.setOnClickListener(this);
        //iBtnBorrar.setOnClickListener(this);
        iBtnEditar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int btn = view.getId();

        if (btn == R.id.btnEditar){
            Log.d("boton", "es: Editar");
            Intent i = new Intent(this.mainActivity, FormularioActivity.class);
            //pasar informacion a un activity
            PersonaModel personaModel = new PersonaModel("", "", "");
            personaModel.setNombre(this.tvNombre.getText().toString());
            personaModel.setContrasenia(this.tvContrasenia.getText().toString());
            personaModel.setTipo(this.tvTipo.getText().toString());
            MainActivity.personaPosicion = super.getAdapterPosition();
            i.putExtra("persona", personaModel);
            mainActivity.startActivity(i);
        }
        /*else if(btn == R.id.btnEliminar){
            Log.d("boton", "es: Eliminar");
            MainActivity.personaPosicion = -1;
            this.mainActivity.removerEnLista(super.getAdapterPosition());
        }*/
    }
}