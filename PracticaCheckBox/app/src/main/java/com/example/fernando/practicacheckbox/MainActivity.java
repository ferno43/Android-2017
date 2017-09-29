package com.example.fernando.practicacheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox recuerdame;
    EditText password,numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recuerdame=(CheckBox) findViewById(R.id.checkBoxRecuerdame);
        password=(EditText) findViewById(R.id.editTextoPassword);
        numero=(EditText) findViewById(R.id.editTextNumero);
        if(recuerdame.isChecked()==true){
            Toast.makeText(this, "Esta marcado", Toast.LENGTH_SHORT).show();

        }else{

            Toast.makeText(this, "No esta marcado", Toast.LENGTH_SHORT).show();
        }

        recuerdame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(recuerdame.isChecked()==true){
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                        Toast.makeText(getApplicationContext(), "Esta marcado", Toast.LENGTH_SHORT).show();
                }else{
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    Toast.makeText(getApplicationContext(), "No esta marcado", Toast.LENGTH_SHORT).show();
                }

            }
            });
        numero.addTextChangedListener(new CustomWatcher());



    }

    public class CustomWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (s.length() > 0) {
                if (Integer.parseInt(s.toString()) > 1000) {
                    recuerdame.setChecked(true);
                } else {
                    recuerdame.setChecked(false);
                }
            }
        }
        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
