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
        Toast.makeText(this,"ciao",Toast.LENGTH_LONG).show();
        if(((RadioButton)findViewById(R.id.radioButton3)).isChecked()) {
            Toast.makeText(this,"ciao2",Toast.LENGTH_LONG).show();
            if (((TextInputEditText)findViewById(R.id.metri)).getText().equals("")) {
                ((TextInputEditText) findViewById(R.id.metri)).setError(getString(R.string.Vuoto));
                ((TextInputLayout)findViewById(R.id.inputlayout2)).setError(getString(R.string.Vuoto));
            }
        }
    }
}
