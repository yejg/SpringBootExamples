package io.ymq.logback;

import io.xjar.XKit;
import io.xjar.boot.XBoot;
import io.xjar.key.XKey;

/**
 * @author yejg
 * @since 2019-08-05
 */
public class TestMain {

    public static void main(String[] args) throws Exception {

        System.out.println(System.getSecurityManager());


        // String password = "111111";
        // XKey xKey = XKit.key(password);
        // XBoot.encrypt("E:\\Git_OpenSource\\SpringBootExamples\\spring-boot-logback\\target\\spring-boot-logback-1.0-SNAPSHOT.jar", "E:\\Git_OpenSource\\SpringBootExamples\\spring-boot-logback\\target\\spring-boot-logback-1.0-SNAPSHOT_1.jar", xKey);
    }
}
