package com.example.vero.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vero.R;
import com.example.vero.adaptadores.FotosPerfilAdaptador;
import com.example.vero.pojo.Mascota;

import java.util.ArrayList;


public class PerfilPet extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public PerfilPet() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil_pet, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvFotosPerfil);
        GridLayoutManager llm = new GridLayoutManager(getActivity(), 3);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();


        return v;
    }
    public void inicializarAdaptador(){
        FotosPerfilAdaptador adaptador = new FotosPerfilAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Keysi1", "12", R.drawable.perro1));
        mascotas.add(new Mascota("Keysi2", "4", R.drawable.perro1));
        mascotas.add(new Mascota("Keysi3", "6", R.drawable.perro1));
        mascotas.add(new Mascota("Monny", "7", R.drawable.perro));
        mascotas.add(new Mascota("Perrito", "15", R.drawable.perro9));
        mascotas.add(new Mascota("Perrito2", "10", R.drawable.perro9));
        mascotas.add(new Mascota("Keysi1", "12", R.drawable.perro1));
        mascotas.add(new Mascota("Keysi2", "4", R.drawable.perro1));
        mascotas.add(new Mascota("Keysi3", "6", R.drawable.perro1));
        mascotas.add(new Mascota("Monny", "7", R.drawable.perro));
        mascotas.add(new Mascota("Perrito", "15", R.drawable.perro9));
        mascotas.add(new Mascota("Perrito2", "10", R.drawable.perro9));

    }


}
