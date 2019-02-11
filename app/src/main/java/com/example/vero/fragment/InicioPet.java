package com.example.vero.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vero.R;
import com.example.vero.adaptadores.MascotaAdaptador;
import com.example.vero.pojo.Mascota;

import java.util.ArrayList;

public class InicioPet extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public InicioPet()
    {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_inicio_pet, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Monny", "10", R.drawable.perro));
        mascotas.add(new Mascota("Keysi", "2", R.drawable.perro1));
        mascotas.add(new Mascota("Coqueta", "3", R.drawable.perro2));
        mascotas.add(new Mascota("Tilla", "7", R.drawable.perro3));
        mascotas.add(new Mascota("Junior", "13", R.drawable.perro4));
        mascotas.add(new Mascota("Bolo", "6", R.drawable.perro5));
        mascotas.add(new Mascota("Zeus", "15", R.drawable.perro8));
        mascotas.add(new Mascota("Perrito", "9", R.drawable.perro9));
    }

}
