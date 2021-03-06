package com.dreamtech.appName.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    public CorsConfig() {
    }

    @Bean
    public CorsFilter corsFilter() {
        // 1. 添加cors配置信息
        CorsConfiguration config = new CorsConfiguration();
        //config.addAllowedOrigin("http://localhost:8080");
        // 其实不建议使用*，允许所有跨域
        config.addAllowedOrigin("*");

        // 设置是否发送cookie信息，在前端也可以设置axios.defaults.withCredentials = true;表示发送Cookie,
        // 跨域请求要想带上cookie，必须要请求属性withCredentials=true，这是浏览器的同源策略导致的问题：不允许JS访问跨域的Cookie
        /*
         * withCredentials前后端都要设置，后端是setAllowCredentials来设置
         * 如果后端设置为false而前端设置为true，前端带cookie就会报错
         * 如果后端为true，前端为false，那么后端拿不到前端的cookie，cookie数组为null
         * 前后端都设置withCredentials为true，表示允许前端传递cookie到后端。
         * 前后端都为false，前端不会传递cookie到服务端，后端也不接受cookie
         */
        // config.setAllowCredentials(true);

        // 设置允许请求的方式，比如get、post、put、delete，*表示全部
        config.addAllowedMethod("*");

        //设置允许跨域的时间
        config.setMaxAge(3600L);

        // 设置允许的header
        config.addAllowedHeader("*");

        // 2. 为url添加映射路径
        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        // /**表示该config适用于所有路由
        corsSource.registerCorsConfiguration("/**", config);

        // 3. 返回重新定义好的corsSource
        return new CorsFilter(corsSource);
    }
}

