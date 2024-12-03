package com.toolkit4j.rknn.define;

public enum CoreMask {
    AUTO(0, "AUTO"),                   // RKNN_NPU_CORE_AUTO
    CORE_0(1, "CORE_0"),               // RKNN_NPU_CORE_0
    CORE_1(2, "CORE_1"),               // RKNN_NPU_CORE_1
    CORE_2(4, "CORE_2"),               // RKNN_NPU_CORE_2
    CORE_0_1(3, "CORE_0_1"),           // RKNN_NPU_CORE_0_1 (1 | 2)
    CORE_0_1_2(7, "CORE_0_1_2"),       // RKNN_NPU_CORE_0_1_2 (1 | 2 | 4)
    ALL(0xffff, "ALL"),                // RKNN_NPU_CORE_ALL
    UNDEFINED(0x0, "UNDEFINED");       // RKNN_NPU_CORE_UNDEFINED

    private final int value;
    private final String description;

    CoreMask(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    // Static method to get an enum by its integer value
    public static CoreMask fromValue(int value) {
        for (CoreMask coreMask : CoreMask.values()) {
            if (coreMask.getValue() == value) {
                return coreMask;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
    
    // Static method to check if a core mask is valid (e.g., a combination of the defined masks)
    public static boolean isValidCoreMask(int value) {
        for (CoreMask coreMask : CoreMask.values()) {
            if ((value & coreMask.getValue()) == coreMask.getValue()) {
                return true;
            }
        }
        return false;
    }
}
