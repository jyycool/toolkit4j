
项目地址:
 [https://github.com/rockchip-linux/rkdnn](https://github.com/rockchip-linux/rkdnn)RKNN（Rockchip Neural Network）是瑞芯微（Rockchip）提供的一种用于在瑞芯微芯片上运行深度学习模型的推理引擎。
RKNN API 提供了一套C++接口，允许开发者将训练好的模型加载到瑞芯微芯片上，并进行推理操作。

## RKNN Java API 概述
 RKNN Java API 是 RKNN 推理引擎的 Java 绑定。
 瑞芯微芯片并没有提供java 相关的操作。所以花时间写一个java相关的API的接口
 允许 Java 开发者使用 Java 语言在瑞芯微芯片上进行深度学习模型的推理。通过 RKNN Java API，开发者可以加载模型、预处理输入数据、执行推理操作以及获取推理结果。

主要功能
RKNN Java API 提供了以下主要功能：

模型加载：

加载 RKNN 模型文件（通常是 .rknn 文件）。

    配置模型运行参数，如输入输出节点、数据格式等。

数据预处理：

    对输入数据进行预处理，如归一化、缩放、通道转换等。预处理后的数据转换为 RKNN 模型所需的格式。

推理执行：

    将预处理后的数据输入到 RKNN 模型中进行推理。获取推理结果。

结果后处理：

    对推理结果进行后处理，如解码、分类、检测等。

处理效果如下基于openpose模型
原始图片推理之后的图片如下
<img src="image/yoga.jpg" width="400" height="300" />

<img src="image/yoga_result.jpg" width="400" height="300" />