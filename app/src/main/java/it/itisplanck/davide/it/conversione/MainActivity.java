package it.itisplanck.davide.it.conversione;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void error(View v){
        ((TextInputLayout)findViewById(R.id.inputlayout)).setError("a caso");
        ((TextInputLayout)findViewById(R.id.inputlayout)).setError("a caso");
        ((TextInputEditText)findViewById(R.id.textKilometri)).setError("a caso");

    }
}
