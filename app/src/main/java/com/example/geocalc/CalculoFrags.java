package com.example.geocalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CalculoFrags extends AppCompatActivity {

    private Button btn_losango;
    private Button btn_triangulo;
    private Button btn_trapezio;
    private FragLosango fragLosango;
    private FragTriangulo fragTriangulo;
    private FragTrapezio fragTrapezio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_frags);

        btn_losango = findViewById(R.id.btn_losango);
        btn_triangulo = findViewById(R.id.btn_triangulo);
        btn_trapezio = findViewById(R.id.btn_trapezio);

        fragTriangulo = new FragTriangulo();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_calc, fragTriangulo);
        fragmentTransaction.commit();

        btn_losango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragLosango = new FragLosango();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_calc, fragLosango);
                fragmentTransaction.commit();
            }
        });

        btn_triangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragTriangulo = new FragTriangulo();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_calc, fragTriangulo);
                fragmentTransaction.commit();
            }
        });

        btn_trapezio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragTrapezio = new FragTrapezio();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_calc, fragTrapezio);
                fragmentTransaction.commit();
            }
        });



    }
}