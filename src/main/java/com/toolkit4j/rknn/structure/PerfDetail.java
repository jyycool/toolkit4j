package com.toolkit4j.rknn.structure;

import com.sun.jna.Pointer;

public class PerfDetail  extends SdkStructure{

    // D /* the string pointer of perf detail. don't need free it by user. */
    public Pointer perf_data; // Pointer to char*

    /* the string length. */
    public long data_len;     // uint64_t
}
