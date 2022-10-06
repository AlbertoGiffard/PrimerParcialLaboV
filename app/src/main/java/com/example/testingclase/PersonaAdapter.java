package com.example.testingclase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonaAdapter  extends RecyclerView.Adapter<PersonaViewHolder> {

    private List<PersonaModel> personaModels;
    private MainActivity mainActivity;

    public PersonaAdapter(List<PersonaModel> personaModels, MainActivity mainActivity) {
        this.personaModels = personaModels;
        this.mainActivity = mainActivity;
    }

    //este metodo se ejecuta por la cantidad de
    //elementos que entren en la pantalla
    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_persona, parent, false);

        return new PersonaViewHolder(v, this.mainActivity);
    }

    //se ejecuta a partir de cuanto haga scroll
    //tanto para arriba y para abajo
    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        PersonaModel p = this.personaModels.get(position);

        TextView tvContrasenia = holder.tvContrasenia;
        TextView tvNombre = holder.tvNombre;
        TextView tvTipo = holder.tvTipo;

        tvContrasenia.setText(p.getContrasenia());
        tvTipo.setText(p.getTipo());
        tvNombre.setText(p.getNombre());

    }
    //ver el tamaño de la lista
    @Override
    public int getItemCount() {
        return this.personaModels.size();
    }
}