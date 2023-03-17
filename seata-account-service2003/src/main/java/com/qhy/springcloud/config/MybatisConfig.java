package com.qhy.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author (oWo)
 * @date 2022/10/27 10:32
 */
@Configuration
@MapperScan({"com.qhy.springcloud.dao"})
public class MybatisConfig {

}
