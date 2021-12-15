package com.wufeng.code.model.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
public class ParamsDto {
    @NotNull(message = "name 不能为 null")
    private String name;

    @Range(max = 12, min = 1)
    private Integer num;
}
