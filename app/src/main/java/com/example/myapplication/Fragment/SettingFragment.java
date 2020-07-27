package com.example.myapplication.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.CustomerActivty;
import com.example.myapplication.R;


public class SettingFragment extends Fragment implements View.OnClickListener {
    EditText ET_investment, ET_datepurchase, ET_units, ET_purchase_price;
    Button Btn_add;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        ET_investment = view.findViewById(R.id.ET_investment);
        ET_datepurchase = view.findViewById(R.id.ET_datepurchase);
        ET_units = view.findViewById(R.id.ET_units);
        ET_purchase_price = view.findViewById(R.id.ET_purchase_price);
        Btn_add = view.findViewById(R.id.Btn_add);

        Btn_add.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.Btn_add) {
            String invest = ET_investment.getText().toString();
            String date_purchase = ET_datepurchase.getText().toString();
            String unit = ET_units.getText().toString();
            String purchase_price = ET_purchase_price.getText().toString();
            if (TextUtils.isEmpty(invest) || TextUtils.isEmpty(date_purchase) || TextUtils.isEmpty(unit) || TextUtils.isEmpty(purchase_price)) {
                Toast.makeText(getContext(), "All fields are required", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(getContext(), CustomerActivty.class));
            }
        }
    }
}