package com.sddtc.common.impala.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sddtc.common.impala.dao.ImpalaDao;

/**
 * @Description: impala 接口
 * @Author Sddtc
 */
@Service
public class ImpalaServiceImpl {
    @Autowired
    private ImpalaDao impalaDao;
    
    /**
     * 执行sql
     * @param sql
     * @return
     */
    public List<Map<String, Object>> query(String sql) {
        return impalaDao.query(sql);
    }
}
