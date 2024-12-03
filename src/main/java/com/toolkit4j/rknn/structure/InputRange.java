package com.toolkit4j.rknn.structure;

import com.muang.rknn.define.TensorConstants;
import com.muang.rknn.define.TensorFormat;

public class InputRange extends SdkStructure  {


    /* input parameter, the index of input/output tensor,
   need set before call rknn_query. */
    public  int  index;

    /* the number of shape. */
    public  int   shape_number;

    /* the data format of tensor. */
    public TensorFormat fmt;

    /* the name of tensor. */
    public byte[] name = new byte[TensorConstants.RKNN_MAX_NAME_LEN];

    /* the dynamic input dimensions range. */
    public int[][] dyn_range = new int[TensorConstants.RKNN_MAX_DYNAMIC_SHAPE_NUM][TensorConstants.RKNN_MAX_DIMS];

    /* the number of dimensions. */
    public  int  n_dims;

}
