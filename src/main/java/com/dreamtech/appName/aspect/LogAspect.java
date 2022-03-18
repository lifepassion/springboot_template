package com.dreamtech.appName.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 日志切面类
 */
@Aspect
@Component
public class LogAspect {


//    /**
//     * 切点
//     */
//    @Pointcut("execution(* com.dreamtech.appName.controller..*.*(..))")
//    private void LogAspectPointcut() {
//    }
//
//    /**
//     * 前置通知
//     * 通知方法会在目标方法调用之前执行
//     */
//    @Around("LogAspectPointcut()")
//    public Object doBefore(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        Log log = LogFactory.get(joinPoint.getTarget().getClass().getName());
//
//        LogRecord logRecord = new LogRecord();
//        //获取当前请求对象
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        assert attributes != null;
//        HttpServletRequest request = attributes.getRequest();
//
//        //拿到用户对象
//        boolean login = StpUtil.isLogin();
//        if (login) {
//            UserInfoVo userInfo = (UserInfoVo) StpUtil.getSession().get("USERINFO");
//            logRecord.setUserInfo(userInfo);
//        } else {
//            logRecord.setUserInfo(new UserInfoVo("未登录", "未登录", 93));
//        }
//        logRecord.setIp(request.getRemoteAddr());
//        logRecord.setMethod(request.getMethod());
//        logRecord.setUrl(request.getRequestURL().toString());
//        //日志输出
//        log.info("{}", logRecord);
//        //获取方法参数值数组
//        Object[] args = joinPoint.getArgs();
//        log.info("请求参数为{}", Arrays.toString(args));
//        //注意，如果调用joinPoint.proceed()方法，则修改的参数值不会生效，必须调用joinPoint.proceed(Object[] args)
//        return joinPoint.proceed(args);
//    }
}
