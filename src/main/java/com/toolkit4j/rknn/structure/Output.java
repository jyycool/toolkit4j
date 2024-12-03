package com.toolkit4j.rknn.structure;

import com.sun.jna.Pointer;

public class Output  extends SdkStructure{

    //want transfer output data to float
    public byte want_float;

    // whether buf is pre-allocated.if TRUE,
    // the following variables need to be set.
    // if FALSE, the following variables do not need to be set.
    public byte is_prealloc;

    //he output index.
    public int index;

    /* the output buf for index.
    when is_prealloc = FALSE and rknn_outputs_release called,
    this buf pointer will be free and don't use it anymore. */
    public Pointer buf;

    // The size of the output buffer
    public int size;

    public Output(Pointer pointer){
        super(pointer);
    }
    public Output() {
    }

}
