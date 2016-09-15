package com.mayo.mvvm.person;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mayo.mvvm.R;
import com.mayo.mvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements IPersonView {

    private PersonViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new PersonViewModel(this);
        binding.setViewModel(viewModel);

        viewModel.description.set("Rekha");
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
