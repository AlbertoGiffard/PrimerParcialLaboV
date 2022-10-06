package com.example.testingclase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private List<PersonaModel> list;
    private PersonaAdapter adapter;
    static PersonaModel personaModel;
    static int personaPosicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.personaPosicion = -2;
        this.list = new ArrayList<PersonaModel>();
        list.add(new PersonaModel("JPrueba", "12345", "Administrador"));
        list.add(new PersonaModel("Batsy", "12345", "Administrador"));
        list.add(new PersonaModel("Flash", "6789", "Usuario"));
        list.add(new PersonaModel("WWW", "09876", "Usuario"));
        list.add(new PersonaModel("NDGL", "9876", "Usuario"));
        list.add(new PersonaModel("SIGL", "4657", "Usuario"));
        list.add(new PersonaModel("Superman", "4321", "Usuario"));
        list.add(new PersonaModel("Wakanda", "5675", "Administrador"));
        list.add(new PersonaModel("Lio", "1111", "Usuario"));
        list.add(new PersonaModel("Doggy", "2222", "Usuario"));
        list.add(new PersonaModel("BatsyJr", "3333", "Usuario"));
        list.add(new PersonaModel("JuliBri", "4444", "Administrador"));
        list.add(new PersonaModel("Posty", "5555", "Usuario"));
        list.add(new PersonaModel("DuaL", "6666", "Administrador"));
        list.add(new PersonaModel("BritneyB", "7777", "Administrador"));
        list.add(new PersonaModel("NRoses", "8888", "Usuario"));

        this.adapter = new PersonaAdapter(list, this);
        RecyclerView rv = super.findViewById(R.id.rvPersona);
        LinearLayoutManager linear = new LinearLayoutManager(this);
        rv.setLayoutManager(linear);
        rv.setAdapter(this.adapter);
    }

    /*public void removerEnLista(int personaPoss){
        this.list.remove(personaPoss);
        this.adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.itemAgregar) {
            Log.d("ClickItem", "Se hizo click en 1");
            //abrir un segundo activity
            Intent i = new Intent(this, FormularioActivity.class);
            MainActivity.personaPosicion = -1;
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    } */

    @Override
    protected void onRestart() {
        if (MainActivity.personaPosicion == -1){
            this.list.add(MainActivity.personaModel);
            adapter.notifyDataSetChanged();
        } else if(MainActivity.personaPosicion != -2){
            this.list.get(MainActivity.personaPosicion).setModel(MainActivity.personaModel);
            this.adapter.notifyItemChanged(MainActivity.personaPosicion);
        }

        super.onRestart();
    }
}