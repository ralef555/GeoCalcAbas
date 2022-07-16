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
 * Use the {@link FragLosango#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragLosango extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button btn_calc_losango;
    private EditText edt_diag_maior_losango;
    private EditText edt_diag_menor_losango;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragLosango() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragLosango.
     */
    // TODO: Rename and change types and number of parameters
    public static FragLosango newInstance(String param1, String param2) {
        FragLosango fragment = new FragLosango();
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
        View view = inflater.inflate(R.layout.fragment_frag_losango, container, false);
        btn_calc_losango = view.findViewById(R.id.btn_calc_losango);
        edt_diag_menor_losango = view.findViewById(R.id.edt_diag_menor_losango);
        edt_diag_maior_losango = view.findViewById(R.id.edt_diag_maior_losango);
        btn_calc_losango.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_diag_maior_losango.getText().toString().isEmpty() || edt_diag_menor_losango.getText().toString().isEmpty()){
                    Toast.makeText(getActivity(), "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }else{
                    double diag_menor = Double.parseDouble(edt_diag_menor_losango.getText().toString());
                    double diag_maior = Double.parseDouble(edt_diag_maior_losango.getText().toString());
                    double area_losango = (diag_maior * diag_menor)/2;

                    AlertDialog.Builder janela = new AlertDialog.Builder(getActivity());
                    janela.setTitle("Resultado");
                    String saida = String.format("O resultado da área do losango é: %.3f", area_losango);
                    janela.setMessage(saida);
                    janela.show();

                    edt_diag_menor_losango.setText("");
                    edt_diag_maior_losango.setText("");
                }
            }
        });



        return view;




    }
}