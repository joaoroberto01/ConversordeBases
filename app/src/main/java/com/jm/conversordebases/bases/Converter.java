package com.jm.conversordebases.bases;

abstract class Converter {
    private int base;
    private String toConvert;

    Converter(int base,String toConvert){
        this.base = base;
        this.toConvert = toConvert;
    }

    String toDecimal(){
        toConvert = reverse(toConvert);
        Long sum = 0L;

        for (int i = 0; i < toConvert.length(); i++) {
            String character = charToNumber(toConvert.toUpperCase().charAt(i));
            sum += (long) Math.pow(base,i) * Long.valueOf(character);
        }

        if(toConvert.length() < 1)
            return "";
        else
            return sum.toString().toUpperCase();
    }

    private String charToNumber(char c) {
        switch (c) {
            case 'A':
                return "10";
            case 'B':
                return "11";
            case 'C':
                return "12";
            case 'D':
                return "13";
            case 'E':
                return "14";
            case 'F':
                return "15";
            default:
                return String.valueOf(c);
        }
    }

    private String reverse(String string){
        String reversed = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            reversed = reversed.concat(String.valueOf(string.charAt(i)));
        }

        return reversed;
    }
}
