package com.example.sleepswell.ui.Alarme;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sleepswell.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment  {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        final TextView textHora = binding.textHora;
        final Button butAlarme = binding.buttonAlarme;



        butAlarme.setOnClickListener(v ->  {

                Intent janelaAlarme = new Intent(getActivity(), despertador.class );
                startActivity(janelaAlarme);

        });




       /* botClick.setOnClickListener(v -> {
            textView.setText("resiliencia");
            seguravalor.sgrvalue.jafoi = true;
                }
        );

      HomeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        return root;
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
       binding = null;
    }



}