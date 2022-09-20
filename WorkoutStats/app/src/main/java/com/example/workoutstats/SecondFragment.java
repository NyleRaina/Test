package com.example.workoutstats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.fragment.NavHostFragment;

import com.example.workoutstats.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    TextView name, age, weight, height;
    View view;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                name = view.findViewById(R.id.dataGetName);
                age = view.findViewById(R.id.dataGetAge);
                weight= view.findViewById(R.id.dataGetWeight);
                height=view.findViewById(R.id.dataGetHeight);
                Bundle result=new Bundle();
                result.putString("df2Name",name.getText().toString());
                result.putString("df2Age",age.getText().toString());
                result.putString("df2Weight",weight.getText().toString());
                result.putString("df2Height", height.getText().toString());
                getParentFragmentManager().setFragmentResult("dataFrom2",result);
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        getParentFragmentManager().setFragmentResultListener("dataFrom1", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data= result.getString("df1Name");
                TextView textView=view.findViewById(R.id.dataGetName);
                textView.setText(data);
                data=result.getString("df1Age");
                textView=view.findViewById(R.id.dataGetAge);
                textView.setText(data);
                data=result.getString("df1Weight");
                textView=view.findViewById(R.id.dataGetWeight);
                textView.setText(data);
                data=result.getString("df1Height");
                textView=view.findViewById(R.id.dataGetHeight);
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