package com.toolkit4j.rknn.define;

public enum TensorMemFlags {
    RKNN_TENSOR_MEMORY_FLAGS_ALLOC_INSIDE(1),
    RKNN_TENSOR_MEMORY_FLAGS_FROM_FD(2),
    RKNN_TENSOR_MEMORY_FLAGS_FROM_PHYS(3),
    RKNN_TENSOR_MEMORY_FLAGS_UNKNOWN(0);

    private final int value;

    TensorMemFlags(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TensorMemFlags fromValue(int value) {
        for (TensorMemFlags flag : TensorMemFlags.values()) {
            if (flag.value == value) {
                return flag;
            }
        }
        return RKNN_TENSOR_MEMORY_FLAGS_UNKNOWN;
    }
}
