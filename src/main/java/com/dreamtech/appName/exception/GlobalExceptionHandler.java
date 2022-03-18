package com.dreamtech.appName.exception;

import cn.dev33.satoken.exception.DisableLoginException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.dreamtech.appName.utils.R;
import com.dreamtech.appName.utils.ResultCode;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ValidationException;

/**
 * 统一异常处理类
 *
 * @author Life
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {

        if (e instanceof NotLoginException) {
            NotLoginException ee = (NotLoginException) e;
            return R.error().code(ResultCode.CODE_NOT_LOGIN).message(ee.getMessage());

        } else if (e instanceof NotRoleException) {
            // 如果是角色异常
            NotRoleException ee = (NotRoleException) e;
            return R.error().code(ResultCode.CODE_NOT_JUR).message("无此角色：" + ee.getRole());

        } else if (e instanceof NotPermissionException) {
            // 如果是权限异常
            NotPermissionException ee = (NotPermissionException) e;
            return R.error().code(ResultCode.CODE_NOT_JUR).message("无此权限：" + ee.getCode());

        } else if (e instanceof DisableLoginException) {
            // 如果是被封禁异常
            DisableLoginException ee = (DisableLoginException) e;
            return R.error().code(ResultCode.CODE_NOT_JUR).message("账号被封禁：" + ee.getDisableTime() + "秒后解封");

        } else if (e instanceof ValidationException) {
            //如果是ValidationException验证异常requestParams
            return R.error().code(ResultCode.CODE_WARNING).message(e.getMessage());
        } else if (e instanceof BindException) {
            //如果是参数BindException绑定异常 requestBody
            return R.error().code(ResultCode.CODE_WARNING).message(((BindException) e).getBindingResult().getAllErrors().get(0).getDefaultMessage());
        } else if (e instanceof MethodArgumentTypeMismatchException) {
            //参数转换异常
            e.printStackTrace();
            return R.error().code(ResultCode.CODE_WARNING).message(e.getMessage());
        }
        else {    // 普通异常, 输出：500 + 异常信息
            e.printStackTrace();
            return R.error().code(ResultCode.ERROR).message("执行了统一异常处理: " + e.getMessage());
        }

    }

    @ExceptionHandler(MyException.class)
    @ResponseBody
    public R error(MyException e) {
        e.printStackTrace();
        return R.error().message(e.getMsg()).code(e.getCode());
    }


}
