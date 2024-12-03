package com.toolkit4j.rknn.structure;

import com.sun.jna.Pointer;

public class SdkVersion extends SdkStructure{

    //  /* the version of rknn api. */
    public byte[] api_version = new byte[256];

    /* the version of rknn driver. */
    public byte[] drv_version = new byte[256];


    public SdkVersion(Pointer pointer){
        super(pointer);
    }
    public SdkVersion() {
    }


}


