package com.qhy.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 创建自己的负载均衡接口
 */
public interface MyLoadBalancer {

    /**
     * 收集服务器总共有多少台能够提供服务的服务器，并放到List集合里
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
