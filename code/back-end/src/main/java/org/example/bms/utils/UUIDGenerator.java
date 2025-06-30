package org.example.bms.utils;

import java.util.UUID;

public class UUIDGenerator {
    // 生成一个随机 UUID（标准格式）
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
