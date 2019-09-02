package com.dubbo.debug.service;

import com.dubbo.debug.param.DubboDebugParam;

/**
 * dubbo调试服务接口
 *
 * @author hkb
 * @date 2019-09-02
 */
public interface DubboDebugService {

    /**
     * 调用
     * 
     * @param param
     *            入参
     * @return 返回结果
     */
    Object invoke(DubboDebugParam param);

}
