package com.lhs.service;

import java.io.File;

/**
 * Created by Leonid on 2018/7/9.
 */
public interface QCloudCosService {

    /**
     * 上传文件到腾讯云服务器
     * @param bucketName 桶名称
     * @param key 目录结构名称
     * @param file 文件
     * @return
     * @throws Exception
     */
    String updateFile2QCloudCos(String bucketName, String key, File file) throws Exception;

}
