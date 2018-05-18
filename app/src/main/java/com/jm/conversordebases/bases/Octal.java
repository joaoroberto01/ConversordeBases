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
        EditText decimal = activity.findViewById(R.id.et_decimal);
        decimal.setText(toDecimal());

        EditText binary = activity.findViewById(R.id.et_binary);
        binary.setText(toBinary());

        EditText hexa = activity.findViewById(R.id.et_hexa);
        hexa.setText(toHexadecimal());
    }

    private String toBinary(){
        return toDecimal().length() > 0 ? Long.toBinaryString(Long.valueOf(toDecimal())) : toDecimal();
    }

    private String toHexadecimal(){
        return toDecimal().length() > 0 ? Long.toHexString(Long.valueOf(toDecimal())) : toDecimal();
    }
}
