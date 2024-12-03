package com.toolkit4j.rknn.define;

public enum QueryCmd {
    QUERY_IN_OUT_NUM(0),                             // RKNN_QUERY_IN_OUT_NUM
    QUERY_INPUT_ATTR(1),                             // RKNN_QUERY_INPUT_ATTR
    QUERY_OUTPUT_ATTR(2),                            // RKNN_QUERY_OUTPUT_ATTR
    QUERY_PERF_DETAIL(3),                            // RKNN_QUERY_PERF_DETAIL
    QUERY_PERF_RUN(4),                               // RKNN_QUERY_PERF_RUN
    QUERY_SDK_VERSION(5),                            // RKNN_QUERY_SDK_VERSION
    QUERY_MEM_SIZE(6),                               // RKNN_QUERY_MEM_SIZE
    QUERY_CUSTOM_STRING(7),                          // RKNN_QUERY_CUSTOM_STRING
    QUERY_NATIVE_INPUT_ATTR(8),                      // RKNN_QUERY_NATIVE_INPUT_ATTR
    QUERY_NATIVE_OUTPUT_ATTR(9),                     // RKNN_QUERY_NATIVE_OUTPUT_ATTR
    QUERY_NATIVE_NC1HWC2_INPUT_ATTR(8),              // RKNN_QUERY_NATIVE_NC1HWC2_INPUT_ATTR
    QUERY_NATIVE_NC1HWC2_OUTPUT_ATTR(9),             // RKNN_QUERY_NATIVE_NC1HWC2_OUTPUT_ATTR
    QUERY_NATIVE_NHWC_INPUT_ATTR(10),                // RKNN_QUERY_NATIVE_NHWC_INPUT_ATTR
    QUERY_NATIVE_NHWC_OUTPUT_ATTR(11),               // RKNN_QUERY_NATIVE_NHWC_OUTPUT_ATTR
    QUERY_DEVICE_MEM_INFO(12),                       // RKNN_QUERY_DEVICE_MEM_INFO
    QUERY_INPUT_DYNAMIC_RANGE(13),                   // RKNN_QUERY_INPUT_DYNAMIC_RANGE
    QUERY_CURRENT_INPUT_ATTR(14),                    // RKNN_QUERY_CURRENT_INPUT_ATTR
    QUERY_CURRENT_OUTPUT_ATTR(15),                   // RKNN_QUERY_CURRENT_OUTPUT_ATTR
    QUERY_CURRENT_NATIVE_INPUT_ATTR(16),             // RKNN_QUERY_CURRENT_NATIVE_INPUT_ATTR
    QUERY_CURRENT_NATIVE_OUTPUT_ATTR(17),            // RKNN_QUERY_CURRENT_NATIVE_OUTPUT_ATTR
    CMD_MAX(18);                                     // RKNN_QUERY_CMD_MAX

    private final int value;

    QueryCmd(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // Example method to get an enum by its value
    public static QueryCmd fromValue(int value) {
        for (QueryCmd cmd : QueryCmd.values()) {
            if (cmd.getValue() == value) {
                return cmd;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
