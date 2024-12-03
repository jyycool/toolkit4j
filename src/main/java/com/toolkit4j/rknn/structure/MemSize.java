package com.toolkit4j.rknn.structure;

public class MemSize extends SdkStructure{

    ///* the weight memory size */
    public int total_weight_size;

    /* the internal memory size, exclude inputs/outputs */
    public int total_internal_size;

    /* total dma memory allocated size */
    public long total_dma_allocated_size;

    /* total system sram size reserved for rknn */
    public int total_sram_size;

    /* free system sram size reserved for rknn */
    public int free_sram_size;

    /* reserved */
    public int[] reserved = new int[10];
}
