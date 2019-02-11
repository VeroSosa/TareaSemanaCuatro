package com.example.vero;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.vero.adaptadores.PageAdapter;
import com.example.vero.fragment.InicioPet;
import com.example.vero.fragment.PerfilPet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar     = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout   = (TabLayout) findViewById(R.id.tabLayout);
        viewPager   = (ViewPager) findViewById(R.id.viewPager);

        setUpPageViewer();

        if(toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setIcon(R.drawable.icons8_dog_50);
        }

    }

    //Añandiendo los Fragments
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new InicioPet());
        fragments.add(new PerfilPet());

        return fragments;
    }

    //Dando el Orden de los Fragments con el Siguiente Metodo
    private void setUpPageViewer(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_inicio);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_like:
                Toast.makeText(this, R.string.favs, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Favoritos.class);
                startActivity(intent);
                break;
            case R.id.action_contacto:
                //Crear el Intent para Actvity que enviara Email
                Toast.makeText(this, R.string.contacto_toolbar, Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(MainActivity.this, Contacto.class);
                startActivity(intent2);
                break;
            case R.id.action_about:
                //Crear el Intent para Activity de Datos de Desarrollador
                Toast.makeText(this, R.string.about_toolbar, Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(MainActivity.this, About.class);
                startActivity(intent3);
        }
        return super.onOptionsItemSelected(item);
    }

}
