package com.toolkit4j.rknn.code;

import com.toolkit4j.rknn.define.MemSyncMode;
import com.toolkit4j.rknn.structure.*;
import com.sun.jna.Library;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

/**
 * RKNN API interface
 */
public interface RKNNApi extends Library {


    /*  rknn_init

    initial the context and load the rknn model.

    input:
        rknn_context* context       the pointer of context handle.
        void* model                 if size > 0, pointer to the rknn model, if size = 0, filepath to the rknn model.
        uint32_t size               the size of rknn model.
        uint32_t flag               extend flag, see the define of RKNN_FLAG_XXX_XXX.
        rknn_init_extend* extend    the extend information of init.
    return:
        int                         error code.
    */
    int rknn_init(PointerByReference context, byte []  model, NativeLong size, NativeLong flag, InitExtend extend);



    /*  rknn_dup_context

    initial the context and load the rknn model.
    input:
        rknn_context* context_in       the pointer of context in handle.
        rknn_context* context_out      the pointer of context out handle.
    return:
        int                         error code.
    */
    int rknn_dup_context(Pointer context_in, Pointer context_out);


    /*  rknn_destroy

    unload the rknn model and destroy the context.

    input:
        rknn_context context        the handle of context.
    return:
        int                         error code.
    */
    int rknn_destroy(Pointer context);


    /*  rknn_query

    query the information about model or others. see rknn_query_cmd.

    input:
        rknn_context context        the handle of context.
        rknn_query_cmd cmd          the command of query.
        void* info                  the buffer point of information.
        uint32_t size               the size of information.
    return:
        int                         error code.
    */
    int rknn_query(Pointer context, int cmd, Object  info, int size);



    /*  rknn_inputs_set

    set inputs information by input index of rknn model.
    inputs information see rknn_input.

    input:
        rknn_context context        the handle of context.
        uint32_t n_inputs           the number of inputs.
        rknn_input inputs[]         the arrays of inputs information, see rknn_input.
    return:
        int                         error code
    */
    int rknn_inputs_set(Pointer context, int n_inputs, Input [] inputs);



    /*
    rknn_set_batch_core_num

    set rknn batch core_num.

    input:
        rknn_context context        the handle of context.
        int core_num                the core number.
    return:
        int                         error code.

    */
    int rknn_set_batch_core_num(Pointer context, int core_num);


    /*  rknn_set_core_mask

    set rknn core mask.(only supported on RK3588 now)
    RKNN_NPU_CORE_AUTO: auto mode, default value
    RKNN_NPU_CORE_0: core 0 mode
    RKNN_NPU_CORE_1: core 1 mode
    RKNN_NPU_CORE_2: core 2 mode
    RKNN_NPU_CORE_0_1: combine core 0/1 mode
    RKNN_NPU_CORE_0_1_2: combine core 0/1/2 mode
    RKNN_NPU_CORE_ALL: auto mode, select multiple npu cores to run depending on platform
    input:
        rknn_context context        the handle of context.
        rknn_core_mask core_mask    the core mask.
    return:
        int                         error code.
    */
    int rknn_set_core_mask(Pointer context, int core_mask);



    /*  rknn_run

    run the model to execute inference.

    input:
        rknn_context context        the handle of context.
        rknn_run_extend* extend     the extend information of run.
    return:
        int                         error code.
    */
    int rknn_run(Pointer context, RunExtend extend);


    /*  rknn_wait

    wait the model after execute inference.

    input:
        rknn_context context        the handle of context.
        rknn_run_extend* extend     the extend information of run.
    return:
        int                         error code.
    */
    int rknn_wait(Pointer context, RunExtend extend);

    /*  rknn_outputs_get

    wait the inference to finish and get the outputs.
    this function will block until inference finish.
    the results will set to outputs[].

    input:
        rknn_context context        the handle of context.
        uint32_t n_outputs          the number of outputs.
        rknn_output outputs[]       the arrays of output, see rknn_output.
        rknn_output_extend*         the extend information of output.
    return:
        int                         error code.
    */
    int rknn_outputs_get(Pointer context, int n_outputs, Output[] outputs, RunExtend extend);

    /*  rknn_outputs_release

    release the outputs that get by rknn_outputs_get.
    after called, the rknn_output[x].buf get from rknn_outputs_get will
    also be free when rknn_output[x].is_prealloc = FALSE.

    input:
        rknn_context context        the handle of context.
        uint32_t n_ouputs           the number of outputs.
        rknn_output outputs[]       the arrays of output.
    return:
        int                         error code
    */
    int rknn_outputs_release(Pointer context, int n_outputs, Output[] outputs);

    /* new api for zero copy */
    /*  rknn_create_mem_from_phys (memory allocated outside)
    
        initialize tensor memory from physical address.
    
        input:
            rknn_context ctx            the handle of context.
            uint64_t phys_addr          physical address.
            void *virt_addr             virtual address.
            uint32_t size               the size of tensor buffer.
        return:
            rknn_tensor_mem             the pointer of tensor memory information.
    */
    TensorMemory rknn_create_mem_from_phys(Pointer ctx, NativeLong phys_addr, Pointer virt_addr, NativeLong size);

    /*  rknn_create_mem_from_fd (memory allocated outside)

    initialize tensor memory from file description.

    input:
        rknn_context ctx            the handle of context.
        int32_t fd                  file description.
        void *virt_addr             virtual address.
        uint32_t size               the size of tensor buffer.
        int32_t offset              indicates the offset of the memory (virt_addr without offset).
    return:
        rknn_tensor_mem             the pointer of tensor memory information.
    */
    TensorMemory rknn_create_mem_from_fd(Pointer ctx, int fd, Pointer virt_addr, NativeLong size, int offset);

    /*  rknn_create_mem_from_mb_blk (memory allocated outside)

    create tensor memory from mb_blk.

    input:
        rknn_context ctx            the handle of context.
        void *mb_blk                mb_blk allocate from system api.
        int32_t offset              indicates the offset of the memory.
    return:
        rknn_tensor_mem             the pointer of tensor memory information.
    */
    TensorMemory rknn_create_mem_from_mb_blk(Pointer ctx, Pointer mb_blk, int offset);

    /*  rknn_create_mem (memory allocated inside)

    create tensor memory.

    input:
        rknn_context ctx            the handle of context.
        uint32_t size               the size of tensor buffer.
    return:
        rknn_tensor_mem             the pointer of tensor memory information.
    */
    TensorMemory rknn_create_mem(Pointer ctx, NativeLong size);

    /*  rknn_create_mem2 (memory allocated inside)

    create tensor memory.

    input:
        rknn_context ctx            the handle of context.
        uint64_t size               the size of tensor buffer.
        uint64_t alloc_flags              control the memory is cacheable
    return:
        rknn_tensor_mem             the pointer of tensor memory information.
    */
    TensorMemory rknn_create_mem2(Pointer ctx, NativeLong size, NativeLong alloc_flags);

    /*  rknn_destroy_mem (support allocate inside and outside)

    destroy tensor memory.

    input:
        rknn_context ctx            the handle of context.
        rknn_tensor_mem *mem        the pointer of tensor memory information.
    return:
        int                         error code
    */
    int rknn_destroy_mem(Pointer ctx, TensorMemory mem);

    /*  rknn_set_weight_mem

    set the weight memory.
    input:
        rknn_context ctx            the handle of context.
        rknn_tensor_mem *mem        the array of tensor memory information
    return:
        int                         error code.
    */
    int rknn_set_weight_mem(Pointer ctx, TensorMemory mem);

    /*  rknn_set_internal_mem

    set the internal memory.

    input:
        rknn_context ctx            the handle of context.
        rknn_tensor_mem *mem        the array of tensor memory information
    return:
        int                         error code.
    */
    int rknn_set_internal_mem(Pointer ctx, TensorMemory mem);

    /*  rknn_set_io_mem

    set the input and output tensors buffer.

    input:
        rknn_context ctx            the handle of context.
        rknn_tensor_mem *mem        the array of tensor memory information.
        rknn_tensor_attr *attr      the attribute of input or output tensor buffer.
    return:
        int                         error code.
    */
    int rknn_set_io_mem(Pointer ctx, TensorMemory mem, TensorAttr attr);

    /*  rknn_set_input_shape(deprecated)

    set the input tensor shape (only valid for dynamic shape rknn model).

    input:
        rknn_context ctx            the handle of context.
        rknn_tensor_attr *attr      the attribute of input or output tensor buffer.
    return:
        int                         error code.
    */
    int rknn_set_input_shape(Pointer ctx, TensorAttr attr);


    /*  rknn_set_input_shapes

    set all the input tensor shapes. graph will run under current set of input shapes after rknn_set_input_shapes.(only valid for dynamic shape rknn model).

    input:
        rknn_context ctx            the handle of context.
        uint32_t n_inputs           the number of inputs.
        rknn_tensor_attr attr[]     the attribute array of all input tensors.
    return:
        int                         error code.
    */
    int rknn_set_input_shapes(Pointer ctx, NativeLong n_inputs, TensorAttr[] attr);

    /*  rknn_mem_sync

     sync cacheable rknn memory when both cpu and device access data.

     input:
         rknn_context context        the handle of context.
         rknn_tensor_mem *mem        the pointer of tensor memory information.
         rknn_mem_sync_mode mode     the mode of sync cache.
     return:
         int                         error code.
    */
    int rknn_mem_sync(Pointer context, TensorMemory mem, MemSyncMode mode);
}
