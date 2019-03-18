package com.lhs.service.impl;

import com.lhs.service.QCloudCosService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by Leonid on 2018/7/9.
 */
@Service
public class QCloudCosServiceImpl implements QCloudCosService {

    @Autowired
    private COSClient cosClient;
    @Value("${cos.url}")
    private String QCLOUD_COS_URL;

    @Override
    public String updateFile2QCloudCos(String bucketName, String key, File file) throws Exception {
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        return QCLOUD_COS_URL + key;
    }
}
