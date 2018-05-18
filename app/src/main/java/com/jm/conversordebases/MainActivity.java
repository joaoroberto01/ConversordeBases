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

import com.jm.conversordebases.bases.Binary;
import com.jm.conversordebases.bases.Decimal;
import com.jm.conversordebases.bases.Hexadecimal;
import com.jm.conversordebases.bases.Octal;

public class MainActivity extends AppCompatActivity{
    private EditText decimalEditText,binaryEditText,octalEditText,hexaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindElements();
    }

    private void bindElements() {
        decimalEditText = findViewById(R.id.et_decimal);
        binaryEditText = findViewById(R.id.et_binary);
        octalEditText = findViewById(R.id.et_octal);
        hexaEditText = findViewById(R.id.et_hexa);
        setupTextWatchers();
    }

    private void setupTextWatchers(){
        decimalEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (decimalEditText.isFocused())
                    new Decimal(MainActivity.this, s.toString()).convert();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binaryEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binaryEditText.isFocused())
                    new Binary(MainActivity.this, s.toString()).convert();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        octalEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (octalEditText.isFocused())
                    new Octal(MainActivity.this, s.toString()).convert();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        hexaEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (hexaEditText.isFocused())
                    new Hexadecimal(MainActivity.this, s.toString()).convert();
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
        decimalEditText.setText("");
        binaryEditText.setText("");
        octalEditText.setText("");
        hexaEditText.setText("");
    }

    private void copy() {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = null;
        if(decimalEditText.hasFocus()){
            clip = ClipData.newPlainText("decimal", decimalEditText.getText().toString());
        }else if(binaryEditText.hasFocus()){
            clip = ClipData.newPlainText("binary", binaryEditText.getText().toString());
        }else if(octalEditText.hasFocus()){
            clip = ClipData.newPlainText("octal", octalEditText.getText().toString());
        }else if(hexaEditText.hasFocus()){
            clip = ClipData.newPlainText("hexa", hexaEditText.getText().toString());
        }
        Toast.makeText(this, "Copiado para a área de transferência", Toast.LENGTH_SHORT).show();

        clipboard.setPrimaryClip(clip);
    }
}
