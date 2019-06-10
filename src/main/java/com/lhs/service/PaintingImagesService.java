package com.lhs.service;

import com.lhs.entity.Painting;
import com.lhs.entity.PaintingImages;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 补充图片表 服务类
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
public interface PaintingImagesService extends IService<PaintingImages> {

    String uploadImage(MultipartFile file) throws Exception;
    List<PaintingImages> selectList(Long paintingId);
}
