package com.toolkit4j.rknn.define;


/**
 * 自己定义无符号整形
 */
public class UnsignedInt32 {
    private int value;
    
    public UnsignedInt32(int value) {
        this.value = value;
    }
    
    public long getUnsignedValue() {
        return value & 0xFFFFFFFFL;
    }
    
    @Override
    public String toString() {
        return Long.toString(getUnsignedValue());
    }
}
