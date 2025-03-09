package com.hoa.Bai32_Log4j2;

import com.hoa.utils.LogUtils;
import org.testng.annotations.Test;

public class DemoWriteLog {
    @Test
    public void testWriteLogToFile1() {
        LogUtils.info("This is a debug message");
        LogUtils.warn("This is a warn message");
        LogUtils.error("This is an error message");
        LogUtils.fatal("This is a fatal message");
    }
}
