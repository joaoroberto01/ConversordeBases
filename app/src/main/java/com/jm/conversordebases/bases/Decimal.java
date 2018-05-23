package com.jm.conversordebases.bases;

import android.app.Activity;
import android.widget.EditText;

import com.jm.conversordebases.R;

public class Decimal extends Converter{
    private Activity activity;

    public Decimal(Activity activity, String decimal) {
        super(10,decimal);
        this.activity = activity;
    }

    public void convert(){
        ((EditText) activity.findViewById(R.id.et_binary)).setText(toBinary());

        ((EditText) activity.findViewById(R.id.et_octal)).setText(toOctal());

        ((EditText) activity.findViewById(R.id.et_hexa)).setText(toHexadecimal());

        ((EditText) activity.findViewById(R.id.et_ascii)).setText(toASCII());
    }
}
