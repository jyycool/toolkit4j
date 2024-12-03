package test;

import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.ptr.PointerByReference;
import com.toolkit4j.rknn.code.RKNNApi;
import com.toolkit4j.rknn.define.QueryCmd;
import com.toolkit4j.rknn.structure.InputOutputNum;
import com.toolkit4j.rknn.structure.SdkVersion;
import com.toolkit4j.rknn.structure.TensorAttr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {


    public static void main(String[] args) throws InterruptedException {


        String path = args[0];
        String api = args[1];
        byte[] model = loadModel(path);
        NativeLong modelDataSize = new NativeLong(model.length);
        PointerByReference content = new PointerByReference();
        RKNNApi rknnApi = Native.load(api, RKNNApi.class);
        int ret = rknnApi.rknn_init(content, model, modelDataSize, new NativeLong(0), null);
        System.out.println("初始化结果是：" + ret);
        SdkVersion sdkVersion = new SdkVersion();
        ret = rknnApi.rknn_query(content.getValue(), QueryCmd.QUERY_SDK_VERSION.getValue(), sdkVersion, sdkVersion.size());
        System.out.println("查询结果是：" + ret);
        if (ret == 0) { // 检查调用是否成功
            System.out.println("API Version: " + new String(sdkVersion.api_version));
            System.out.println("Driver Version: " + new String(sdkVersion.drv_version));
        } else {
            System.err.println("Failed to get RKNN SDK version.");
        }

        // 获取输入输出个数
        InputOutputNum inputOutputNum = new InputOutputNum();
        ret = rknnApi.rknn_query(content.getValue(), QueryCmd.QUERY_IN_OUT_NUM.getValue(), inputOutputNum, inputOutputNum.size());
        if (ret == 0) { // 检查调用是否成功
            System.out.println(String.format("model input num: %s, output num: %s", inputOutputNum.n_input, inputOutputNum.n_output));
        } else {
            System.err.println("Failed to get RKNN SDK InputOutputNum.");
        }

        // 输入属性
        System.out.println("input tensors:");
        TensorAttr[] input_attrs = new TensorAttr[inputOutputNum.n_input];
        for (int i = 0; i < inputOutputNum.n_input; i++)
        {
            TensorAttr tensorAttr = new TensorAttr();
            tensorAttr.index = i;
            ret = rknnApi.rknn_query(content.getValue(), QueryCmd.QUERY_INPUT_ATTR.getValue(), tensorAttr, tensorAttr.size());
            if (ret != 0) { // 检查调用是否成功
                System.out.println(String.format("rknn_query fail! ret=%d", ret));
            }
            System.out.println(tensorAttr);
            input_attrs[i] = tensorAttr;
        }
        // 输出属性
        System.out.println("output tensors:");
        TensorAttr[] output_attrs = new TensorAttr[inputOutputNum.n_output];
        for (int i = 0; i < inputOutputNum.n_output; i++)
        {
            TensorAttr tensorAttr = new TensorAttr();
            tensorAttr.index = i;
            ret = rknnApi.rknn_query(content.getValue(), QueryCmd.QUERY_OUTPUT_ATTR.getValue(), tensorAttr, tensorAttr.size());
            if (ret != 0) { // 检查调用是否成功
                System.out.println(String.format("rknn_query fail! ret=%d", ret));
            }
            output_attrs[i] = tensorAttr;
            System.out.println(tensorAttr);
        }

        System.out.println("参数设置");
        // 设置输入


    }



    public static byte[] loadModel(String filename) {
        try {
            Path path = Paths.get(filename);
            System.out.println("Loading model from " + path);
            return Files.readAllBytes(path);
        } catch (IOException e) {
            System.err.printf("Failed to load model from file %s: %s%n", filename, e.getMessage());
            return null;
        }
    }
}
