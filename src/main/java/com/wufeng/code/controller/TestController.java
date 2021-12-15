package com.wufeng.code.controller;

import com.wufeng.code.common.CommonResult;
import com.wufeng.code.model.dto.ParamsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

    @PostMapping("/paramsValidate")
    public CommonResult paramsValidate(@RequestBody @Validated ParamsDto dto) {
        log.info("name:", dto.getName());
        log.info("num:", dto.getNum());
        return CommonResult.success(dto);
    }
}
