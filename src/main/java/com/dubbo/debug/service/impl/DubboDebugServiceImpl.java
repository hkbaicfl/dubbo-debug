package com.dubbo.debug.service.impl;

import com.dubbo.debug.param.DubboDebugParam;
import com.dubbo.debug.service.DubboDebugService;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.utils.ReferenceConfigCache;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * dubbo调试服务实现类
 *
 * @author hkb
 * @date 2019-09-02
 */
@Service
public class DubboDebugServiceImpl implements DubboDebugService {

    /**
     * 应用mingc
     */
    @Value("${dubbo.application.name}")
    private String appName;
    /**
     * 注册中心地址
     */
    @Value("${dubbo.registry.address}")
    private String registryAddress;

    @Override
    public Object invoke(DubboDebugParam param) {
        if (StringUtils.isEmpty(param.getService())) {
            return "service is not empty";
        }
        if (StringUtils.isEmpty(param.getMethod())) {
            return "method is not empty";
        }
        if (param.getTypes() == null) {
            param.setTypes(new String[] {});
        }

        if (param.getArgs() == null) {
            param.setArgs(new Object[] {});
        }
        // 创建服务实例
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        reference.setGeneric(true);
        reference.setApplication(new ApplicationConfig(appName));
        reference.setInterface(param.getService());

        RegistryConfig registry = new RegistryConfig();
        registry.setAddress(registryAddress);
        reference.setRegistry(registry);

        // 获取缓存中的实例
        ReferenceConfigCache cache = ReferenceConfigCache.getCache();
        GenericService genericService = cache.get(reference);
        return genericService.$invoke(param.getMethod(), param.getTypes(), param.getArgs());
    }

}
