package com.toolkit4j.rknn.structure;

import com.sun.jna.NativeLong;

public class RunExtend extends SdkStructure{

    //output parameter, indicate current frame id of run
    public NativeLong frame_id;

    //block flag of run, 0 is block else 1 is non block
    public int non_block;

    //timeout for block mode, in milliseconds
    public int timeout_ms;

    //fence fd from other unit
    public int fence_fd;
}
