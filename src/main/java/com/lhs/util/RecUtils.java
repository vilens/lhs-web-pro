package com.lhs.util;

import com.lhs.em.RrcFileType;

import java.util.List;

import static java.util.Arrays.asList;

public class RecUtils {
    private Integer getRrcFileTypeBySuffix(String suffix) {
        List<String> videoArr = asList("AVI", "MOV", "RMVB", "RM", "FLV", "MP4", "3GP");

        List<String> imageArr = asList("JPG", "JPEG", "GIF", "PNG");
        if (videoArr.contains(suffix.toUpperCase())) {
            return RrcFileType.VIDEO.getId();
        } else if (imageArr.contains(suffix.toUpperCase())) {
            return RrcFileType.IMAGE.getId();
        } else {
            return RrcFileType.OTHER.getId();
        }

    }
}
