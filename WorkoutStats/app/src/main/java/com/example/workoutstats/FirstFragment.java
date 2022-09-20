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

import com.example.workoutstats.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private EditText name, age, weight, height;
    View view;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
//        name = view.findViewById(R.id.edit1);
//        age = view.findViewById(R.id.edit2);
//        num= view.findViewById(R.id.editNum);
//        height=view.findViewById(R.id.editHeight);
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                name = view.findViewById(R.id.edit1);
        age = view.findViewById(R.id.edit2);
        weight= view.findViewById(R.id.editWeight);
        height=view.findViewById(R.id.editHeight);
                Bundle result=new Bundle();
                result.putString("df1Name",name.getText().toString());
                result.putString("df1Age",age.getText().toString());
                result.putString("df1Weight",weight.getText().toString());
                result.putString("df1Height", height.getText().toString());
                getParentFragmentManager().setFragmentResult("dataFrom1",result);
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        getParentFragmentManager().setFragmentResultListener("dataFrom2", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String data= result.getString("df2Name");
                TextView textView=view.findViewById(R.id.edit1);
                textView.setText(data);
                data=result.getString("df2Age");
                textView=view.findViewById(R.id.edit2);
                textView.setText(data);
                data=result.getString("df2Weight");
                textView=view.findViewById(R.id.editWeight);
                textView.setText(data);
                data=result.getString("df2Height");
                textView=view.findViewById(R.id.editHeight);
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