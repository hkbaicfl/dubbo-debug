package com.dubbo.debug.web;

import javax.annotation.Resource;

import com.dubbo.debug.param.DubboDebugParam;
import com.dubbo.debug.service.DubboDebugService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * dubbo调试前端控制器
 *
 * @author hkb
 * @date 2019-09-02
 */
@RestController
public class DubboDebugController {

    /**
     * dubbo调试服务接口
     */
    @Resource
    private DubboDebugService dubboDebugService;

    /**
     * 调用
     * 
     * @param param
     *            入参
     * @return 返回结果
     */
    @PostMapping("/dubbo/debug")
    public Object invoke(@RequestBody DubboDebugParam param) {
        return dubboDebugService.invoke(param);
    }

}
