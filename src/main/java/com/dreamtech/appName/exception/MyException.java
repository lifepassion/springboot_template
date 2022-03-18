package com.dreamtech.appName.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Life
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException{

    @ApiModelProperty(value = "状态码")
    private Integer code;
    @ApiModelProperty(value = "异常信息")
    private String msg;

}
