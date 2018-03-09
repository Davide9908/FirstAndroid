package it.itisplanck.davide.it.conversione;

import android.graphics.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextInputEditText) findViewById(R.id.migliaInput)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (((RadioButton) findViewById(R.id.radioButton3)).isChecked()) {
                    if (((TextInputEditText) findViewById(R.id.migliaInput)).getText().toString().equals("")) {
                        ((TextInputEditText) findViewById(R.id.migliaInput)).setError(getString(R.string.Vuoto));
                        ((TextInputLayout) findViewById(R.id.layoutMiglia)).setError(getString(R.string.Vuoto));
                        if ((findViewById(R.id.migliaInput)).requestFocus())
                            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);
                    }
                    else
                        ((TextInputLayout) findViewById(R.id.layoutMiglia)).setErrorEnabled(false);
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
            if (((TextInputEditText)findViewById(R.id.migliaInput)).getText().toString().equals("")) {
                ((TextInputEditText) findViewById(R.id.migliaInput)).setError(getString(R.string.Vuoto));
                ((TextInputLayout)findViewById(R.id.layoutMiglia)).setError(getString(R.string.Vuoto));
            }
            else {
                ((TextInputLayout) findViewById(R.id.layoutMiglia)).setErrorEnabled(false);
                try{
                    double n=Double.parseDouble(((TextInputEditText)findViewById(R.id.migliaInput)).getText().toString());
                    n*=1.60934;
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
                ((TextInputLayout) findViewById(R.id.layoutKilometri)).setErrorEnabled(false);
                try{
                    double n=Double.parseDouble(((TextInputEditText)findViewById(R.id.kilometriInput)).getText().toString());
                    n*=0.621371;
                    ((TextInputEditText)findViewById(R.id.migliaInput)).setText(""+n);
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Numero inserito non corretto",Toast.LENGTH_SHORT).show();
                }

            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

   /* @Override
    public boolean onContextItemSelected(MenuItem item) {
        Log.i("luce", "qualcosa non funziona");
        switch (item.getItemId()) {

            case R.id.luce:
                CameraManager mCameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
                try {
                    mCameraManager.setTorchMode(mCameraManager.getCameraIdList()[0], true);
                } catch (CameraAccessException e) {
                    Log.e("luce", "qualcosa non funziona");
                }
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }*/
    public void flash(MenuItem item){
        Log.i("ciao","entrato");
        CameraManager mCameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
        try {
            mCameraManager.setTorchMode(mCameraManager.getCameraIdList()[0], true);
        } catch (CameraAccessException e) {
            Log.e("luce", "qualcosa non funziona");
        }
    }
}