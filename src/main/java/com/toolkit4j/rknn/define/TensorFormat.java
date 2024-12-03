package com.toolkit4j.rknn.define;

/**
 *
 * 1. NCHW（批量大小、通道、高度、宽度）
 * N: 批量大小（即一批数据的样本数量）
 * C: 通道数（例如图像的颜色通道）
 * H: 每张图像或特征图的高度
 * W: 每张图像或特征图的宽度
 * 示例形状: (10, 3, 224, 224)
 *
 * 10 是批量大小（即一批有 10 张图像）
 * 3 是通道数（例如 RGB 颜色通道）
 * 224 是图像的高度
 * 224 是图像的宽度
 * 用途: 这种格式常用于深度学习框架如 PyTorch，并且对 NVIDIA GPU 优化良好。它将通道放在空间维度之前，这对 GPU 性能优化通常是有利的。
 *
 * 2. NHWC（批量大小、高度、宽度、通道）
 * N: 批量大小（即一批数据的样本数量）
 * H: 每张图像或特征图的高度
 * W: 每张图像或特征图的宽度
 * C: 通道数（例如图像的颜色通道）
 * 示例形状: (10, 224, 224, 3)
 *
 * 10 是批量大小（即一批有 10 张图像）
 * 224 是图像的高度
 * 224 是图像的宽度
 * 3 是通道数（例如 RGB 颜色通道）
 * 用途: 这种格式通常用于 TensorFlow 及其他框架。它将空间维度放在通道之前，这在某些处理和计算时可能更直观，并且对 CPU 操作较为友好。
 *
 * 3. NC1HWC2
 * N: 批量大小（即一批数据的样本数量）
 * C1: 第一个通道维度（例如，表示不同类型的特征或多个通道）
 * H: 每张图像或特征图的高度
 * W: 每张图像或特征图的宽度
 * C2: 第二个通道维度（额外的通道或深度）
 * 示例形状: (10, 2, 224, 224, 3)
 *
 * 10 是批量大小（即一批有 10 张图像）
 * 2 是第一个通道维度（例如，表示不同类型的特征）
 * 224 是图像的高度
 * 224 是图像的宽度
 * 3 是第二个通道维度（例如 RGB 颜色通道）
 * 用途: 这种格式较少见，但在一些高级神经网络架构中，特别是涉及复杂特征图或多维通道数据的架构中可能会使用。
 *
 * 未定义的术语
 * 如果你在张量格式或其他技术讨论中遇到“UNDEFINED”，这可能表示一个占位符或未指定的维度。例如，一些格式可能包含“未定义”的维度，这些维度可以根据应用的需求或约束来指定。
 *
 * 总结:
 *
 * NCHW 和 NHWC 是两种常见的格式，根据维度的排列顺序不同，适用于不同的框架和硬件。
 * NC1HWC2 是一种较为专业的格式，用于处理复杂的数据结构。
 */
public enum TensorFormat {
    NCHW(0, "NCHW"),                // RKNN_TENSOR_NCHW
    NHWC(1, "NHWC"),                // RKNN_TENSOR_NHWC
    NC1HWC2(2, "NC1HWC2"),          // RKNN_TENSOR_NC1HWC2
    UNDEFINED(3, "UNDEFINED"),      // RKNN_TENSOR_UNDEFINED
    MAX(4, "UNKNOW");               // RKNN_TENSOR_FORMAT_MAX (Not used, but included for completeness)

    private final int value;
    private final String formatString;

    TensorFormat(int value, String formatString) {
        this.value = value;
        this.formatString = formatString;
    }

    public int getValue() {
        return value;
    }

    public String getFormatString() {
        return formatString;
    }

    public static TensorFormat fromValue(int value) {
        for (TensorFormat format : TensorFormat.values()) {
            if (format.getValue() == value) {
                return format;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
