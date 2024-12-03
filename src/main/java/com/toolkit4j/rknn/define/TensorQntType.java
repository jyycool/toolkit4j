package com.toolkit4j.rknn.define;

public enum TensorQntType {
    NONE(0, "NONE"),                    // RKNN_TENSOR_QNT_NONE
    DFP(1, "DFP"),                      // RKNN_TENSOR_QNT_DFP
    AFFINE(2, "AFFINE"),                // RKNN_TENSOR_QNT_AFFINE_ASYMMETRIC
    MAX(3, "UNKNOW");                   // RKNN_TENSOR_QNT_MAX (Not used, but included for completeness)

    private final int value;
    private final String qntString;

    TensorQntType(int value, String qntString) {
        this.value = value;
        this.qntString = qntString;
    }

    public int getValue() {
        return value;
    }

    public String getQntTypeString() {
        return qntString;
    }

    // Method to get an enum by its value
    public static TensorQntType fromValue(int value) {
        for (TensorQntType type : TensorQntType.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
