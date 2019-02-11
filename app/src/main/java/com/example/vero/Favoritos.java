package com.example.vero;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.vero.adaptadores.MascotaAdaptador;
import com.example.vero.pojo.Mascota;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.icons8_dog_50);
        getSupportActionBar().setTitle(R.string.favs);

        listaMascotas = (RecyclerView) findViewById(R.id.rvContactos2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarFavs();
        inicializarAdaptador();
    }

    //11.- Seteando el Adaptador
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    //12.- Inicializar Lista de Mascotas Hardcoded
    public void inicializarFavs(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Keysi", "15", R.drawable.perro1));
        mascotas.add(new Mascota("Monny", "12", R.drawable.perro));
        mascotas.add(new Mascota("Zeus", "15", R.drawable.perro8));
        mascotas.add(new Mascota("Perrito", "9", R.drawable.perro9));
        mascotas.add(new Mascota("Tilla", "7", R.drawable.perro3));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.fav_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_contacto:
                //Crear el Intent para Actvity que enviara Email
                Toast.makeText(this, R.string.contacto_toolbar, Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Favoritos.this, Contacto.class);
                startActivity(intent2);
                break;
            case R.id.action_about:
                //Crear el Intent para Activity de Datos de Desarrollador
                Toast.makeText(this, R.string.about_toolbar, Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(Favoritos.this, About.class);
                startActivity(intent3);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
