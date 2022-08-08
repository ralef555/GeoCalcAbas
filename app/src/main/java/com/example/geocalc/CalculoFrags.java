package com.example.geocalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MediatorLiveData;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CalculoFrags extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_frags);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        configurarTabLayout();




    }

    private void configurarTabLayout(){
        ViewPagerAdapter adaptador = new ViewPagerAdapter(this);
        viewPager.setAdapter(adaptador);
        adaptador.adicionaFragmento(new FragLosango(), "Losango");
        adaptador.adicionaFragmento(new FragTrapezio(), "Trapézio");
        adaptador.adicionaFragmento(new FragTriangulo(), "Triangulo");
        viewPager.setOffscreenPageLimit(adaptador.getItemCount());
        TabLayoutMediator tabMediator = new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
           tab.setText(adaptador.getTitle(position));
        });
        tabMediator.attach();

    }

}