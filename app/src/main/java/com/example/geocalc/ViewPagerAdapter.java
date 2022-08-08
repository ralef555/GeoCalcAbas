package com.example.geocalc;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private List<Fragment>Lista = new ArrayList<>();
    private List<String>listaTitulo = new ArrayList<>();


    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public String getTitle(int position){

        return listaTitulo.get(position);
    }

    public void adicionaFragmento(Fragment fragment, String titulo){
        Lista.add(fragment);
        listaTitulo.add(titulo);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return Lista.get(position);
    }

    @Override
    public int getItemCount() {
        return Lista.size();
    }
}
