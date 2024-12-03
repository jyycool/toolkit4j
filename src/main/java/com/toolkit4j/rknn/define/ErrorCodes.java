package com.toolkit4j.rknn.define;

public final class ErrorCodes {
    private ErrorCodes() {
        // Prevent instantiation
    }

    public static final int RKNN_SUCC = 0;                               // execute succeed.
    public static final int RKNN_ERR_FAIL = -1;                          // execute failed.
    public static final int RKNN_ERR_TIMEOUT = -2;                       // execute timeout.
    public static final int RKNN_ERR_DEVICE_UNAVAILABLE = -3;            // device is unavailable.
    public static final int RKNN_ERR_MALLOC_FAIL = -4;                   // memory malloc fail.
    public static final int RKNN_ERR_PARAM_INVALID = -5;                 // parameter is invalid.
    public static final int RKNN_ERR_MODEL_INVALID = -6;                 // model is invalid.
    public static final int RKNN_ERR_CTX_INVALID = -7;                   // context is invalid.
    public static final int RKNN_ERR_INPUT_INVALID = -8;                 // input is invalid.
    public static final int RKNN_ERR_OUTPUT_INVALID = -9;                // output is invalid.
    public static final int RKNN_ERR_DEVICE_UNMATCH = -10;               // the device is unmatch, please update rknn sdk and npu driver/firmware.
    public static final int RKNN_ERR_INCOMPATILE_PRE_COMPILE_MODEL = -11; // This RKNN model use pre_compile mode, but not compatible with current driver.
    public static final int RKNN_ERR_INCOMPATILE_OPTIMIZATION_LEVEL_VERSION = -12; // This RKNN model set optimization level, but not compatible with current driver.
    public static final int RKNN_ERR_TARGET_PLATFORM_UNMATCH = -13;      // This RKNN model set target platform, but not compatible with current platform.
}
