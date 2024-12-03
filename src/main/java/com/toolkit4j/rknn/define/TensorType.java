package com.toolkit4j.rknn.define;

public enum TensorType {
    FLOAT32(0, "FP32"),      // RKNN_TENSOR_FLOAT32
    FLOAT16(1, "FP16"),      // RKNN_TENSOR_FLOAT16
    INT8(2, "INT8"),         // RKNN_TENSOR_INT8
    UINT8(3, "UINT8"),       // RKNN_TENSOR_UINT8
    INT16(4, "INT16"),       // RKNN_TENSOR_INT16
    UINT16(5, "UINT16"),     // RKNN_TENSOR_UINT16
    INT32(6, "INT32"),       // RKNN_TENSOR_INT32
    UINT32(7, "UINT32"),     // RKNN_TENSOR_UINT32
    INT64(8, "INT64"),       // RKNN_TENSOR_INT64
    BOOL(9, "BOOL"),         // RKNN_TENSOR_BOOL
    INT4(10, "INT4"),        // RKNN_TENSOR_INT4
    TYPE_MAX(11, "UNKNOW");  // RKNN_TENSOR_TYPE_MAX

    private final int value;
    private final String typeString;

    TensorType(int value, String typeString) {
        this.value = value;
        this.typeString = typeString;
    }

    public int getValue() {
        return value;
    }

    public String getTypeString() {
        return typeString;
    }

    // Method to get an enum by its value
    public static TensorType fromValue(int value) {
        for (TensorType type : TensorType.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
