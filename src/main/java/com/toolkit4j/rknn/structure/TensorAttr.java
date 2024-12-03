package com.toolkit4j.rknn.structure;

import com.muang.rknn.define.TensorConstants;
import com.muang.rknn.define.TensorFormat;
import com.muang.rknn.define.TensorQntType;
import com.muang.rknn.define.TensorType;

import java.util.Arrays;

public class TensorAttr extends SdkStructure {


    // input parameter, the index of input/output tensor,
    // need set before call rknn_query
    public int index;

    /* the number of dimensions. */
    public int n_dims;

    /* the dimensions array. */
    public int[] dims = new int[TensorConstants.RKNN_MAX_DIMS];

    /* the name of tensor. */
    public byte[] name = new byte[TensorConstants.RKNN_MAX_NAME_LEN];

    /* the number of elements. */
    public int n_elems;

    /* the bytes size of tensor. */
    public int size;

    /* the data format of tensor. */
    /**
     * @See TensorFormat
     */
    public int fmt;

    /* the data type of tensor. */

    /**
     * @See TensorType
     */
    public int type;

    /* the quantitative type of tensor. */
    /**
     * @See TensorQntType
     */
    public int qnt_type;

    /* fractional length for RKNN_TENSOR_QNT_DFP. */
    public byte fl;

    /* zero point for RKNN_TENSOR_QNT_AFFINE_ASYMMETRIC. */
    public int zp;

    /* scale for RKNN_TENSOR_QNT_AFFINE_ASYMMETRIC. */
    public float scale;

    /* the stride of tensor along the width dimention of input,
    Note: it is read-only, 0 means equal to width. */
    public int w_stride;

    /* the bytes size of tensor with stride. */
    public int size_with_stride;

    /* pass through mode, for rknn_set_io_mem interface.
    if TRUE, the buf data is passed directly to the input node of the rknn model
    without any conversion. the following variables do not need to be set.
    if FALSE, the buf data is converted into an input consistent with the model
    according to the following type and fmt. so the following variables
     need to be set.*/
    public byte pass_through;

    /* the stride along the height dimention of input,
    Note: it is write-only, if it was set to 0, h_stride = height. */
    public int h_stride;

    @Override
    public String toString() {
        return "TensorAttr{" +
                "index=" + index +
                ", n_dims=" + n_dims +
                ", dims=" + Arrays.toString(dims) +
                ", name=" + new String(name) +
                ", n_elems=" + n_elems +
                ", size=" + size +
                ", fmt=" + TensorFormat.fromValue(fmt).getFormatString() +
                ", type=" + TensorType.fromValue(type).getTypeString() +
                ", qnt_type=" + TensorQntType.fromValue(qnt_type).getQntTypeString() +
                ", fl=" + fl +
                ", zp=" + zp +
                ", scale=" + scale +
                ", w_stride=" + w_stride +
                ", size_with_stride=" + size_with_stride +
                ", pass_through=" + pass_through +
                ", h_stride=" + h_stride +
                '}';
    }
}
