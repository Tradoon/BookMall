package com.tradoon.mallsecurity.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * author:tradoon
 * desciption:springSecurity不拦截的路径配置
 * date:2022/02/11
 */
@Component
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlsConfig {
    private List<String> urls=new ArrayList<>();
}
