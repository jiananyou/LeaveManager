package com.hziee.util;

import java.nio.charset.StandardCharsets;

public class EncodeUtil {
    public static String transcoding(String str) {
        return new String(str.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }
}
