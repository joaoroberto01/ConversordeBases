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
        EditText decimal = activity.findViewById(R.id.et_decimal);
        decimal.setText(toDecimal());

        EditText binary = activity.findViewById(R.id.et_binary);
        binary.setText(toBinary());

        EditText octal = activity.findViewById(R.id.et_octal);
        octal.setText(toOctal());
    }

    private String toBinary(){
        return toDecimal().length() > 0 ? Long.toBinaryString(Long.valueOf(toDecimal())) : toDecimal();
    }

    private String toOctal(){
        return toDecimal().length() > 0 ? Long.toOctalString(Long.valueOf(toDecimal())) : toDecimal();
    }
}
