package com.toolkit4j.rknn.structure;

import com.sun.jna.Pointer;

public class TensorMemory extends SdkStructure{

    // virtual address of tensor buffer
    public Pointer virt_addr;

    // physical address of tensor buffer
    public long phys_addr;

    // file descriptor of tensor buffer
    public int fd;

    // offset of the memory
    public int offset;

    // size of tensor buffer
    public int size;

    // flags of tensor buffer, reserved
    public int flags;

    // private data of tensor buffer
    public Pointer priv_data;
}
