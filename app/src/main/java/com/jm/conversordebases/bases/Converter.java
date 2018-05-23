package com.jm.conversordebases.bases;

abstract class Converter {
    private int base;
    private String[] toConvert = {};

    Converter(int base,String toConvert){
        this.base = base;
        if(!toConvert.equals(""))
            this.toConvert = toConvert.split(" ");
    }

    String toDecimal(){
        String result = "";
        if(base != 10) {
            Long sum = 0L;

            for (String convert : toConvert) {
                convert = reverse(convert);
                for (int i = 0; i < convert.length(); i++) {
                    String character = charToNumber(convert.toUpperCase().charAt(i));

                    sum += (long) Math.pow(base, i) * Long.valueOf(character);
                }
                result = result.concat(sum + " ");
                sum = 0L;
            }
        }else {
            for(String convert : toConvert){
                result = result.concat(convert+" ");
            }
        }

        return result.toUpperCase();
    }

    String toBinary(){
        String binary = "";
        String[] toConvert = toDecimal().split(" ");
        for(String convert : toConvert){
            if(!convert.equals(""))
                binary = binary.concat(Long.toBinaryString(Long.valueOf(convert)))+" ";
        }
        return binary;
    }

    String toOctal(){
        String octal = "";
        String[] toConvert = toDecimal().split(" ");
        for(String convert : toConvert){
            if(!convert.equals(""))
                octal = octal.concat(Long.toOctalString(Long.valueOf(convert)))+" ";
        }
        return octal;
    }

    String toHexadecimal(){
        String hexa = "";
        String[] toConvert = toDecimal().split(" ");
        for(String convert : toConvert){
            if(!convert.equals(""))
                hexa = hexa.concat(Long.toHexString(Long.valueOf(convert)).toUpperCase())+" ";
        }
        return hexa;
    }

    String toASCII(){
        String decimal = "";
        String[] toConvert = toDecimal().split(" ");
        for (String convert: toConvert) {
            if(!convert.equals("")) {
                long value = Long.valueOf(convert);
                decimal = decimal.concat(String.valueOf((char) value) + " ");
            }
        }
        return decimal;
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
