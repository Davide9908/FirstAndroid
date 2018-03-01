package it.itisplanck.davide.it.conversione;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextInputEditText) findViewById(R.id.metriInput)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (((RadioButton) findViewById(R.id.radioButton3)).isChecked()) {
                    if (((TextInputEditText) findViewById(R.id.metriInput)).getText().toString().equals("")) {
                        ((TextInputEditText) findViewById(R.id.metriInput)).setError(getString(R.string.Vuoto));
                        ((TextInputLayout) findViewById(R.id.layoutMetri)).setError(getString(R.string.Vuoto));
                        if ((findViewById(R.id.metriInput)).requestFocus())
                            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);
                    }
                    else
                        ((TextInputLayout) findViewById(R.id.layoutMetri)).setErrorEnabled(false);
                }
            }
        });
        ((TextInputEditText) findViewById(R.id.kilometriInput)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!((RadioButton) findViewById(R.id.radioButton3)).isChecked()) {
                    if (((TextInputEditText) findViewById(R.id.kilometriInput)).getText().toString().equals("")) {
                        ((TextInputEditText) findViewById(R.id.kilometriInput)).setError(getString(R.string.Vuoto));
                        ((TextInputLayout) findViewById(R.id.layoutKilometri)).setError(getString(R.string.Vuoto));
                        if ((findViewById(R.id.layoutKilometri)).requestFocus())
                            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);
                    }
                    else
                        ((TextInputLayout) findViewById(R.id.layoutKilometri)).setErrorEnabled(false);

                }
            }
        });
    }
    public void convert(View v){
        if(((RadioButton)findViewById(R.id.radioButton3)).isChecked()) {
            if (((TextInputEditText)findViewById(R.id.metriInput)).getText().toString().equals("")) {
                ((TextInputEditText) findViewById(R.id.metriInput)).setError(getString(R.string.Vuoto));
                ((TextInputLayout)findViewById(R.id.layoutMetri)).setError(getString(R.string.Vuoto));
            }
            else {
                    try{
                        double n=Double.parseDouble(((TextInputEditText)findViewById(R.id.metriInput)).getText().toString());
                        n/=1000;
                        ((TextInputEditText)findViewById(R.id.kilometriInput)).setText(""+n);
                    }
                    catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Numero inserito non corretto",Toast.LENGTH_SHORT).show();
                    }

            }
        }
        else{

            if (((TextInputEditText)findViewById(R.id.kilometriInput)).getText().toString().equals("")) {
                ((TextInputEditText) findViewById(R.id.kilometriInput)).setError(getString(R.string.Vuoto));
                ((TextInputLayout)findViewById(R.id.layoutKilometri)).setError(getString(R.string.Vuoto));
            }
            else {
                    try{
                        double n=Double.parseDouble(((TextInputEditText)findViewById(R.id.kilometriInput)).getText().toString());
                        n*=1000;
                        ((TextInputEditText)findViewById(R.id.metriInput)).setText(""+n);
                    }
                    catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Numero inserito non corretto",Toast.LENGTH_SHORT).show();
                    }

            }
        }
    }

}

