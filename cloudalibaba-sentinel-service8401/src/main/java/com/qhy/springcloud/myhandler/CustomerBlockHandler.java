package com.qhy.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.qhy.springcloud.entities.CommonResult;

/**
 * @author (oWo)
 * @date 2022/10/26 14:43
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(444, "按客户自定义, global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444, "按客户自定义, global handlerException-----2");
    }
}
