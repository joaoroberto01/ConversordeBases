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
        String decimal = "";
        for (int i = 0; i < text.length() ; i++) {
            int ascii = (int) text.charAt(i);
            decimal = decimal.concat(ascii+"");
        }
        new Decimal(activity,decimal).convert();
        ((EditText) activity.findViewById(R.id.et_decimal)).setText(decimal);
    }
}
