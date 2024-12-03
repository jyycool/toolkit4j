package com.toolkit4j.rknn.define;

public enum MemAllocFlags {
    RKNN_FLAG_MEMORY_FLAGS_DEFAULT(0),                  // Same as RKNN_FLAG_MEMORY_CACHEABLE
    RKNN_FLAG_MEMORY_CACHEABLE(1 << 0),                  // Create Cacheable memory
    RKNN_FLAG_MEMORY_NON_CACHEABLE(1 << 1);              // Create Non-Cacheable memory

    private final int value;

    MemAllocFlags(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MemAllocFlags fromValue(int value) {
        for (MemAllocFlags flag : MemAllocFlags.values()) {
            if (flag.value == value) {
                return flag;
            }
        }
        throw new IllegalArgumentException("Unknown value: " + value);
    }
}
