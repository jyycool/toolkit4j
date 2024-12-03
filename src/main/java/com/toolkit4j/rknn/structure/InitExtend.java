package com.toolkit4j.rknn.structure;

import com.sun.jna.Pointer;

public class InitExtend extends SdkStructure {

    // rknn context
    public Pointer ctx;

    // real rknn model file offset, only valid when init context with rknn file path and zero-copy model model
    public int real_model_offset;

    // real rknn model file size, only valid when init context with rknn file path and zero-copy model model */
    public int real_model_size;

    // the fd of model buffer.
    public int model_buffer_fd;

    //the flags of model_buffer
    public int model_buffer_flags;

    //reserved
    public byte[] reserved = new byte[112];
}
