package com.example.geocalc;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragTriangulo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragTriangulo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button btn_calc_triangulo;
    private EditText edt_base_triangulo;
    private EditText edt_altura_triangulo;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragTriangulo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragTriangulo.
     */
    // TODO: Rename and change types and number of parameters
    public static FragTriangulo newInstance(String param1, String param2) {
        FragTriangulo fragment = new FragTriangulo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_triangulo, container, false);
        btn_calc_triangulo = view.findViewById(R.id.btn_calc_triangulo);
        edt_base_triangulo = view.findViewById(R.id.edt_base_triangulo);
        edt_altura_triangulo = view.findViewById(R.id.edt_altura_triangulo);

        btn_calc_triangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_base_triangulo.getText().toString().isEmpty() || edt_altura_triangulo.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }else{
                    double base_tri = Double.parseDouble(edt_base_triangulo.getText().toString());
                    double altura_tri = Double.parseDouble(edt_altura_triangulo.getText().toString());
                    double area_tri = (base_tri * altura_tri)/2;

                    AlertDialog.Builder janela = new AlertDialog.Builder(getActivity());
                    janela.setTitle("Resultado");
                    String saida = String.format("O resultado da área do triangulo é: %.3f", area_tri);
                    janela.setMessage(saida);
                    janela.show();

                    edt_base_triangulo.setText("");
                    edt_altura_triangulo.setText("");
                }
            }
        });


        return view;
    }
}