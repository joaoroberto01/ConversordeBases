package com.jm.conversordebases.bases;

import android.app.Activity;
import android.widget.EditText;

import com.jm.conversordebases.R;

public class Binary extends Converter{
    private Activity activity;

    public Binary(Activity activity, String binary) {
        super(2,binary);
        this.activity = activity;
    }

    public void convert(){
        EditText decimal = activity.findViewById(R.id.et_decimal);
        decimal.setText(toDecimal());

        EditText octal = activity.findViewById(R.id.et_octal);
        octal.setText(toOctal());

        EditText hexa = activity.findViewById(R.id.et_hexa);
        hexa.setText(toHexadecimal());

    }

    private String toOctal(){
        return toDecimal().length() > 0 ? Long.toOctalString(Long.valueOf(toDecimal())) : toDecimal();
    }

    private String toHexadecimal(){
        return toDecimal().length() > 0 ? Long.toHexString(Long.valueOf(toDecimal())) : toDecimal();
    }
}
