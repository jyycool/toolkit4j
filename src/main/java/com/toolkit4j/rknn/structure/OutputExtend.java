package com.toolkit4j.rknn.structure;

import com.sun.jna.NativeLong;

public class OutputExtend extends SdkStructure{

    //output parameter, indicate the frame id of outputs, corresponds to
    // struct rknn_run_extend.frame_id
    public NativeLong frame_id;


}
