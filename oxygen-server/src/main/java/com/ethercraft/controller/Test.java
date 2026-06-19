package com.ethercraft.controller;

import com.ethercraft.result.Result;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data")
@Slf4j
public class Test {

    @GetMapping("/test")
    public Result<String> getData() {
        log.info("运行成功");

        return Result.success("Hello");
    }
}
