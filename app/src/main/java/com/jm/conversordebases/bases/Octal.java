package com.jm.conversordebases.bases;

import android.app.Activity;
import android.widget.EditText;

import com.jm.conversordebases.R;

public class Octal extends Converter{
    private Activity activity;

    public Octal(Activity activity,String octal) {
        super(8,octal);
        this.activity = activity;
    }

    public void convert(){
        ((EditText) activity.findViewById(R.id.et_decimal)).setText(toDecimal());

        ((EditText) activity.findViewById(R.id.et_binary)).setText(toBinary());

        ((EditText) activity.findViewById(R.id.et_hexa)).setText(toHexadecimal());

        ((EditText) activity.findViewById(R.id.et_ascii)).setText(toASCII());
    }
}
