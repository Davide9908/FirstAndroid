package it.itisplanck.davide.it.conversione;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void convert(View v){
        if(((RadioButton)findViewById(R.id.radioButton3)).isChecked()) {
            if (((TextInputEditText)findViewById(R.id.metriInput)).getText().toString().equals("")) {
                ((TextInputEditText) findViewById(R.id.metriInput)).setError(getString(R.string.Vuoto));
                ((TextInputLayout)findViewById(R.id.layoutMetri)).setError(getString(R.string.Vuoto));
            }
        }
    }
}
