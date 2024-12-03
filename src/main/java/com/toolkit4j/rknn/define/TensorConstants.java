package com.toolkit4j.rknn.define;

public final class TensorConstants {
    private TensorConstants() {
        // Prevent instantiation
    }

    public static final int RKNN_MAX_DIMS = 16;                            // maximum dimension of tensor.
    public static final int RKNN_MAX_NUM_CHANNEL = 15;                     // maximum channel number of input tensor.
    public static final int RKNN_MAX_NAME_LEN = 256;                       // maximum name length of tensor.
    public static final int RKNN_MAX_DYNAMIC_SHAPE_NUM = 512;              // maximum number of dynamic shape for each input.
}
