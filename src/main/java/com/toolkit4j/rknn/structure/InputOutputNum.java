package com.toolkit4j.rknn.structure;

import com.sun.jna.Pointer;

public class InputOutputNum  extends SdkStructure{

    public int n_input;   // the number of input


    public int n_output;  // the number of output


    public InputOutputNum(Pointer pointer){
        super(pointer);
    }
    public InputOutputNum() {
    }

    @Override
    public String toString() {
        return "InputOutputNum{" +
                "n_input=" + n_input +
                ", n_output=" + n_output +
                '}';
    }
}
