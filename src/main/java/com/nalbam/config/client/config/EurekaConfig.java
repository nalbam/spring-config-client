package com.nalbam.config.client.config;

import com.netflix.appinfo.AmazonInfo;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.InetUtilsProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@RefreshScope
@Configuration
@EnableEurekaClient
public class EurekaConfig {

    @Bean
    @Profile("!default")
    public EurekaInstanceConfigBean eurekaInstanceConfig() {
        final InetUtils inetUtils = new InetUtils(new InetUtilsProperties());
        final EurekaInstanceConfigBean config = new EurekaInstanceConfigBean(inetUtils);
        final AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
        config.setDataCenterInfo(info);
        config.setHostname(info.get(AmazonInfo.MetaDataKey.localHostname));
        config.setIpAddress(info.get(AmazonInfo.MetaDataKey.localIpv4));
        return config;
    }

}
