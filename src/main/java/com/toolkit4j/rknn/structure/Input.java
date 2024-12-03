package com.toolkit4j.rknn.structure;

import com.muang.rknn.define.TensorFormat;
import com.muang.rknn.define.TensorType;
import com.sun.jna.Pointer;

public class Input  extends SdkStructure{

    //the input index
    public int index;

    // the input buf for index
    public Pointer buf;

    //the size of input buf.
    public int size;

    /* pass through mode.
    if TRUE, the buf data is passed directly to the input node of the rknn model
    without any conversion. the following variables do not need to be set.
     if FALSE, the buf data is converted into an input consistent with the model
    according to the following type and fmt. so the following variables
    need to be set.*/
    public byte pass_through;

    // the data type of input buf
    /**
     * @see TensorType
     */
    public int type;

    /* the data format of input buf.
     currently the internal input format of NPU is NCHW by default.
     so entering NCHW data can avoid the format conversion in the driver. */
    /**
     * @see TensorFormat
     */
    public int fmt;


    public Input(Pointer pointer){
        super(pointer);
    }
    public Input() {
    }

}
