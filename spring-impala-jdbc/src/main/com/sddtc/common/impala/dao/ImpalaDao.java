package com.sddtc.common.impala.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Description: impala调用jdbc接口
 * @Author Sddtc
 */
@Repository
public class ImpalaDao {

    @Resource(name = "ImpalaJdbcTemplate")
    private JdbcTemplate impalaTemplate;

    /**
     * 执行sql
     * @param sql
     * @return
     */
    public List<Map<String, Object>> query(String sql) {
        List<Map<String, Object>> result = impalaTemplate.queryForList(sql);
        return result;
    }
}
