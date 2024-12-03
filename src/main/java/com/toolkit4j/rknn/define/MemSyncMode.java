package com.toolkit4j.rknn.define;

public enum MemSyncMode {
    /* the mode used for consistency of device access after CPU accesses data. */
    RKNN_MEMORY_SYNC_TO_DEVICE(0x1),

    /* the mode used for consistency of CPU access after device accesses data. */
    RKNN_MEMORY_SYNC_FROM_DEVICE(0x2),


    /* the mode used for consistency of data access
    between device and CPU in both directions. */
    RKNN_MEMORY_SYNC_BIDIRECTIONAL(RKNN_MEMORY_SYNC_TO_DEVICE.value | RKNN_MEMORY_SYNC_FROM_DEVICE.value); // Both directions

    private final int value;

    MemSyncMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MemSyncMode fromValue(int value) {
        for (MemSyncMode mode : MemSyncMode.values()) {
            if (mode.value == value) {
                return mode;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
