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
        ((EditText) activity.findViewById(R.id.et_decimal)).setText(toDecimal());

        ((EditText) activity.findViewById(R.id.et_octal)).setText(toOctal());

        ((EditText) activity.findViewById(R.id.et_hexa)).setText(toHexadecimal());

        ((EditText) activity.findViewById(R.id.et_ascii)).setText(toASCII());
    }
}
