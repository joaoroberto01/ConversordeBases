package com.jm.conversordebases.bases;

import android.app.Activity;
import android.widget.EditText;

import com.jm.conversordebases.R;

public class Decimal {
    private Activity activity;
    private long decimal;
    private boolean shouldClean;

    public Decimal(Activity activity, String decimal) {
        this.activity = activity;
        try {
            this.decimal = Long.valueOf(decimal);
        }catch (Exception e){
            shouldClean = true;
        }
    }

    public void convert(){
        ((EditText)activity.findViewById(R.id.et_binary)).setText(toBinary());

        ((EditText)activity.findViewById(R.id.et_octal)).setText(toOctal());

        ((EditText)activity.findViewById(R.id.et_hexa)).setText(toHexadecimal());

        ((EditText)activity.findViewById(R.id.et_ascii)).setText(Converter.toASCII(decimal+""));
    }

    private String toBinary(){
        return shouldClean ? "" : Long.toBinaryString(decimal);
    }

    private String toOctal(){
        return shouldClean ? "" : Long.toOctalString(decimal);
    }

    private String toHexadecimal(){
        return shouldClean ? "" : Long.toHexString(decimal);
    }
}
