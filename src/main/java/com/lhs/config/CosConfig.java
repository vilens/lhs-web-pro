package com.lhs.config;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.File;

/**
 * Created by Leonid on 2018/7/9.
 */
@Configuration
public class CosConfig {

    @Autowired
    private Environment env;

    @Bean
    public COSClient cosClient() {
        String accessKey = env.getProperty("cos.accessKey");
        String secretKey = env.getProperty("cos.secretKey");
        String region = env.getProperty("cos.region");
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(region));
        COSClient cosclient = new COSClient(cred, clientConfig);
        return cosclient;
    }




}
