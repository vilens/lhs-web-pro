package com.lhs.web;

import com.lhs.entity.RecipientInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Leonid on 2018/7/13.
 */
@RestController
@RequestMapping("/recipient")
public class RecipientController {

    private static Logger logger = LoggerFactory.getLogger(RecipientController.class);

    @PostMapping("/save")
    public Object save(RecipientInfo recipientInfo) {
        return null;
    }

}
