package com.lhs.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lhs.entity.PaintingImages;
import com.lhs.mapper.PaintingImagesMapper;
import com.lhs.service.OSSObjectService;
import com.lhs.service.PaintingImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 补充图片表 服务实现类
 * </p>
 *
 * @author Leonid
 * @since 2018-07-12
 */
@Service
public class PaintingImagesServiceImpl extends ServiceImpl<PaintingImagesMapper, PaintingImages> implements PaintingImagesService {
    @Autowired
    private OSSObjectService ossObjectService;

    @Override
    public String uploadImage(MultipartFile file) throws Exception{
        return ossObjectService.uploadInputStream2OSS(file.getInputStream(), file.getOriginalFilename());
    }

    @Override
    public List<PaintingImages> selectList(Long paintingId) {
        PaintingImages paintingImages = new PaintingImages();
        paintingImages.setPaintingId(paintingId);
        EntityWrapper<PaintingImages> wrapper = new EntityWrapper<>();
        wrapper.setEntity(paintingImages);
        return this.selectList(wrapper);
    }
}
