package com.lhs.web;

import com.lhs.web.util.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Date;

/**
 * Created by Leonid on 2018/6/14.
 */
public class BaseController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //
        binder.registerCustomEditor(Date.class, new CustomDateEditor(true));
    }

}
