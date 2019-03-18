package com.lhs.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lhs.entity.Classify;
import com.lhs.entity.vo.ClassifyVO;
import com.lhs.mapper.ClassifyMapper;
import com.lhs.service.ClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;


/**
 * Created by Leonid on 2018/7/3.
 */
@Service
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements ClassifyService {

    //@PostConstruct
    private void test() {
        // 需要树形结构的时候使用
        /*
        List<Classify> classifyList = this.selectList(new EntityWrapper<>());
        String json = JSON.toJSONString(classifyList);
        List<ClassifyVO> classifyVOS = JSON.parseArray(json, ClassifyVO.class);
        Collections.sort(classifyVOS, (e1,e2) -> e1.getPid() < e2.getPid() ? 1 : -1);
        System.out.println(classifyVOS);

        Map<Long, List<ClassifyVO>> map = new LinkedHashMap<>();
        for (ClassifyVO vo : classifyVOS) {
            if (map.get(vo.getPid()) != null) {
                map.get(vo.getPid()).add(vo);
            } else {
                List<ClassifyVO> vos = new ArrayList<>();
                vos.add(vo);
                map.put(vo.getPid(), vos);
            }
        }

        Set<Long> set =  map.keySet();
        for (Long pid : set) {
            for (ClassifyVO vo : map.get(pid)) {
                if (map.get(vo.getId()) != null) {
                    List<ClassifyVO> temp = map.get(vo.getId());
                    vo.setClassifyVOList(temp);
                }
            }
        }
        System.out.println(map.get(0L));
        */
    }

}
