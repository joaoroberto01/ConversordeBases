package com.jm.conversordebases.bases;

import android.app.Activity;
import android.widget.EditText;

import com.jm.conversordebases.R;

public class ASCII {
    private Activity activity;
    private String text;

    public ASCII(Activity activity, String text) {
        this.activity = activity;
        this.text = text;
    }

    public void convert(){
        String decimalString = "";
        for (int i = 0; i < text.length(); i++) {
            long decimal = (long) text.charAt(i);
            decimalString = decimalString.concat(decimal+" ");
        }

        Decimal dec = new Decimal(activity,decimalString);

        ((EditText) activity.findViewById(R.id.et_decimal)).setText(decimalString);

        ((EditText) activity.findViewById(R.id.et_binary)).setText(dec.toBinary());

        ((EditText) activity.findViewById(R.id.et_octal)).setText(dec.toOctal());

        ((EditText) activity.findViewById(R.id.et_hexa)).setText(dec.toHexadecimal());
    }
}
