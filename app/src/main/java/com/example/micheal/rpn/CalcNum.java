package com.example.micheal.rpn;

import java.util.Objects;

/**
 *
 *
 * Created by micheal on Apr 05, 2017 at 3:14 PM.
 * (The above line is incorrect, the template was edited and the above line was auto-fixed, the
 * correct date is about a week prior)
 * Project: RPN
 *
 *
 */

class CalcNum {
    private static final String TAG = "CalcNum";
    private Double valDouble;
    private String valString;
    private Boolean negative;
    CalcNum(Double valDouble) {
        this.valDouble = valDouble;
        this.valString = String.valueOf(this.valDouble);
//        Log.v(TAG, this.valString);
        if (this.valString.contains(".") && !this.valString.contains("E")) {
            while (this.valString.endsWith("0")) {
                this.valString = this.valString.substring(0, this.valString.length() - 1);
            }
            if (this.valString.endsWith(".")) {
                this.valString = this.valString.substring(0, this.valString.length() - 1);
            }
        }
        this.negative = (this.valDouble < 0);
    }
    CalcNum() {
        this.valDouble = 0d;
        this.valString = "0";
        this.negative = false;
    }
    CalcNum(CalcNum source) {
        this.valDouble = source.toDouble();
        this.valString = source.toString();
//        Log.v(TAG, this.valString);
        if (this.valString.contains(".") && !this.valString.contains("E")) {
            while (this.valString.endsWith("0")) {
                this.valString = this.valString.substring(0, this.valString.length() - 1);
            }
            if (this.valString.endsWith(".")) {
                this.valString = this.valString.substring(0, this.valString.length() - 1);
            }
        }
        this.negative = source.isNegative();
    }
    void setValDouble(String valDouble) {
        this.valDouble = Double.parseDouble(valDouble);
        this.valString = String.valueOf(this.valDouble);
//        Log.v(TAG, this.valString);
        if (this.valString.contains(".") && !this.valString.contains("E")) {
            while (this.valString.endsWith("0")) {
                this.valString = this.valString.substring(0, this.valString.length() - 1);
            }
            if (this.valString.endsWith(".")) {
                this.valString = this.valString.substring(0, this.valString.length() - 1);
            }
        }
    }
    void setValDouble(Double valDouble) {
        this.valDouble = valDouble;
        this.valString = String.valueOf(this.valDouble);
        if (this.valString.contains(".") && !this.valString.contains("E")) {
            while (this.valString.endsWith("0")) {
                this.valString = this.valString.substring(0, this.valString.length() - 1);
            }
            if (this.valString.endsWith(".")) {
                this.valString = this.valString.substring(0, this.valString.length() - 1);
            }
        }
    }
    void setValString(String valString) {
        this.valString = String.valueOf(Double.parseDouble(valString));
        if (this.valString.contains(".") && !this.valString.contains("E")) {
            while (this.valString.endsWith("0")) {
                this.valString = this.valString.substring(0, this.valString.length() - 1);
            }
            if (this.valString.endsWith(".")) {
                this.valString = this.valString.substring(0, this.valString.length() - 1);
            }
        }
        this.valDouble = Double.parseDouble(this.valString);
    }
    void setValString(Double valString) {
        this.valString = String.valueOf(valDouble);
        if (this.valString.contains(".") && !this.valString.contains("E")) {
            while (this.valString.endsWith("0")) {
                this.valString = this.valString.substring(0, this.valString.length() - 1);
            }
            if (this.valString.endsWith(".")) {
                this.valString = this.valString.substring(0, this.valString.length() - 1);
            }
        }
        this.valDouble = Double.parseDouble(this.valString);
    }
    void setVal(CalcNum newVal) {
        this.valDouble = newVal.toDouble();
        this.valString = newVal.toString();
        if (this.valString.contains(".") && !this.valString.contains("E")) {
            while (this.valString.endsWith("0")) {
                this.valString = this.valString.substring(0, this.valString.length() - 1);
            }
            if (this.valString.endsWith(".")) {
                this.valString = this.valString.substring(0, this.valString.length() - 1);
            }
        }
        this.negative = newVal.isNegative();
    }
    Double toDouble() {
        return this.valDouble;
    }
    public String toString() {
        return this.valString;
    }
    Integer toInteger() {
        return this.valDouble.intValue();
    }
    void clearVal() {
        this.valDouble = 0d;
        this.valString = "0";
        this.negative = false;
    }
    void changeNegative() {
        this.valDouble *= -1d;
        this.negative = !this.negative;
        if (this.negative) {
            if (!this.valString.startsWith("-")) {
                this.valString = "-" + this.valString;
            }
        }
        else {
            if (this.valString.startsWith("-")) {
                this.valString = this.valString.substring(1);
            }
        }
    }
    void changeDecimal() {
        if (!this.valString.contains(".")) {
            this.valString += ".";
        }
    }
    private Boolean isNegative() {
        return this.negative;
    }
    void buttonPress(Integer newNum) {}
    void buttonPress(String newNum) {
        // newNum must be a string which converts to an integer between 0 and 9 inclusive
        // no length-2 strings (unless the first char is 0).
        if (Objects.equals(this.valString, "0") || (this.valString.length() == 2 && this.valString.endsWith("0") && this.negative)) {
            this.valString = "";
            this.negative = false;
        }
        this.valString += newNum;
        this.valDouble = Double.parseDouble(this.valString);
    }
    void backspace() {
        if (this.valString.length() == 1 || (this.valString.length() == 2 && this.negative)) {
            this.valString = "0";
        }
        else {
            this.valString = this.valString.substring(0, this.valString.length() - 1);
        }
        this.valDouble = Double.parseDouble(this.valString);
    }

}
