package com.dubbo.debug.param;

import lombok.Data;

/**
 * dubbo调试入参
 *
 * @author hkb
 * @date 2019-09-02
 */
@Data
public class DubboDebugParam {

    /**
     * 服务
     */
    private String service;

    /**
     * 方法
     */
    private String method;

    /**
     * 版本号
     */
    private String version;

    /**
     * 参数类型
     */
    private String[] types;

    /**
     * 参数
     */
    private Object[] args;

}
