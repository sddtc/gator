package com.sddtc.common.impala.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.sddtc.common.impala.service.ImpalaServiceImpl;

/**
 * @Description: impala 视图控制层
 * @Author Sddtc
 */
@Controller
@RequestMapping("/lab")
public class ImpalaController {

    @Autowired
    private ImpalaServiceImpl impalaServiceImpl;
    Gson gson = new Gson();
    
    String[] unauthorizedWords = {"delete", "create", "drop", "truncate", "insert", "update"};
    
    /**
     * lab page
     * @return
     */
    @RequestMapping(value = "index")
    public String index() {
        return "lab/index";
    }

    /**
     * 执行sql
     * @param sql
     * @return
     */
    @RequestMapping(value = "impala")
    @ResponseBody
    public String query(String sql) {
        if (StringUtils.isNotBlank(sql)) {
            sql = sql.toLowerCase();
            for(String word : unauthorizedWords) {
                if(sql.contains(word)) {
                    return "没有权限执行此操作";
                }
            }

            List<Map<String, Object>> result = impalaServiceImpl.query(sql);
            return gson.toJson(result);
        }

        return "输入语句为空";
    }
}
