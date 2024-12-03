package com.toolkit4j.rknn.define;


/**
 *  Error code returned by the RKNN API.
 */

public enum ResultType {

    //execute succeed.
    SUCC(0),

    //execute failed.
    ERR_FAIL(-1),

    //execute timeout.
    ERR_TIMEOUT(-2),

    //device is unavailable
    ERR_DEVICE_UNAVAILABLE(-3),

    //memory malloc fail.
    ERR_MALLOC_FAIL(-4),

    //parameter is invalid.
    ERR_PARAM_INVALID(-5),

    //model is invalid.
    ERR_MODEL_INVALID(-6),

    //context is invalid.
    ERR_CTX_INVALID(-7),

    //input is invalid.
    ERR_INPUT_INVALID(-8),

    //output is invalid
    ERR_OUTPUT_INVALID(-9),

    // the device is unmatch, please update rknn sdk and npu driver/firmware.
    ERR_DEVICE_UNMATCH(-10),

    //This RKNN model use pre_compile mode, but not compatible with current driver.
    ERR_INCOMPATILE_PRE_COMPILE_MODEL(-11),

    //This RKNN model set optimization level, but not compatible with current driver.
    ERR_INCOMPATILE_OPTIMIZATION_LEVEL_VERSION(-12),

    //This RKNN model set target platform, but not compatible with current platform.
    ERR_TARGET_PLATFORM_UNMATCH(-13),

    ;

    private ResultType(int code) {
        this.code = code;
    }

    private int code;

}
