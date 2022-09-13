package com.example.fragmentpassing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fragmentpassing.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    View view;
    String textTest="";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        Button buttonSend=view.findViewById(R.id.buttonSend);
        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(textTest);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        Button button=view.findViewById(R.id.buttonSend);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view1){
                EditText editText1=view.findViewById(R.id.ET1);
                Bundle result=new Bundle();
                result.putString("df1",editText1.getText().toString());
                getParentFragmentManager().setFragmentResult("dataFrom1",result);
                textTest=textTest+editText1.getText().toString();
                editText1.setText("");

            }

        });
        getParentFragmentManager().setFragmentResultListener("dataFrom2", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data= result.getString("df2");
                TextView textView=view.findViewById(R.id.dataFrom2);
                textView.setText(data);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}