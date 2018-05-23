package com.jm.conversordebases;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.jm.conversordebases.bases.ASCII;
import com.jm.conversordebases.bases.Binary;
import com.jm.conversordebases.bases.Decimal;
import com.jm.conversordebases.bases.Hexadecimal;
import com.jm.conversordebases.bases.Octal;

public class MainActivity extends AppCompatActivity{
    private EditText etDecimal, etBinary, etOctal, etHexa,etASCII;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindElements();
    }

    private void bindElements() {
        etDecimal = findViewById(R.id.et_decimal);
        etBinary = findViewById(R.id.et_binary);
        etOctal = findViewById(R.id.et_octal);
        etHexa = findViewById(R.id.et_hexa);
        etASCII = findViewById(R.id.et_ascii);
        setupTextWatchers();
    }

    private void setupTextWatchers(){
        etDecimal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etDecimal.isFocused())
                    new Decimal(MainActivity.this, s.toString()).convert();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etBinary.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etBinary.isFocused())
                    new Binary(MainActivity.this, s.toString()).convert();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etOctal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etOctal.isFocused())
                    new Octal(MainActivity.this, s.toString()).convert();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etHexa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etHexa.isFocused())
                    new Hexadecimal(MainActivity.this, s.toString()).convert();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etASCII.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (etASCII.isFocused())
                    new ASCII(MainActivity.this, s.toString()).convert();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.clear:
                clear();
                break;
            case R.id.copy:
                copy();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void clear() {
        etDecimal.setText("");
        etBinary.setText("");
        etOctal.setText("");
        etHexa.setText("");
        etASCII.setText("");
    }

    private void copy() {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = null;
        if(etDecimal.hasFocus())
            clip = ClipData.newPlainText("decimal", etDecimal.getText().toString());
        else if(etBinary.hasFocus())
            clip = ClipData.newPlainText("binary", etBinary.getText().toString());
        else if(etOctal.hasFocus())
            clip = ClipData.newPlainText("octal", etOctal.getText().toString());
        else if(etHexa.hasFocus())
            clip = ClipData.newPlainText("hexa", etHexa.getText().toString());
        else if(etASCII.hasFocus())
            clip = ClipData.newPlainText("ascii", etASCII.getText().toString());
        Toast.makeText(this, "Copiado para a área de transferência", Toast.LENGTH_SHORT).show();

        clipboard.setPrimaryClip(clip);
    }
}
