package com.qhy.springcloud.controller;

/**
 * @author (oWo)
 * @date 2022/10/25 10:00
 */

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        log.info("A");
        return "-----------A";
    }

    @GetMapping("/testB")
    public String testB() {
        return "-----------B";
    }

    @GetMapping("/testD")
    public String testD() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        log.info("testD ---测试RT");
        return "---testD";
    }

    @GetMapping("/testC")
    public String testC() {
        log.info("testC 测试异常比例");
        int age = 10 / 0;
        return "-----testC";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testC 测试异常数");
        int age = 10 / 0;
        return "-----testE测试异常数";
    }

    @RequestMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotkey", blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String P2){
        return "-------test Host Key";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "---------deal_testHotKey,┭┮﹏┭┮";
    }

}

