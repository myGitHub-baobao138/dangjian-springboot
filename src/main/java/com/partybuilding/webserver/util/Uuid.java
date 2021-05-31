package com.partybuilding.webserver.util;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 生成uuid类
 */
public class Uuid {
    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
