package org.changli.covermanager.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author alex
 * @date 2021/3/2 10:01
 */

@Controller
public class IndexController {
    private static final Logger LOGGER = LogManager.getLogger();

    /***
     * @description: 点击登录跳转到看板页面
     * @param:
     * @return: java.lang.String
     * @author alex
     * @date: 2021/3/2 10:38
     */
    @RequestMapping("/scanboard")
    public String scanboard(){
        return "scanboard";
    }
}
