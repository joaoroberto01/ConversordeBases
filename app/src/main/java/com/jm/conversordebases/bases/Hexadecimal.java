package com.jm.conversordebases.bases;

import android.app.Activity;
import android.widget.EditText;

import com.jm.conversordebases.R;

public class Hexadecimal extends Converter{
    private Activity activity;

    public Hexadecimal(Activity activity,String hexadecimal) {
        super(16,hexadecimal);
        this.activity = activity;
    }

    public void convert(){
        ((EditText) activity.findViewById(R.id.et_decimal)).setText(toDecimal());

        ((EditText) activity.findViewById(R.id.et_binary)).setText(toBinary());

        ((EditText) activity.findViewById(R.id.et_octal)).setText(toOctal());

        ((EditText) activity.findViewById(R.id.et_ascii)).setText(toASCII());
    }
}
