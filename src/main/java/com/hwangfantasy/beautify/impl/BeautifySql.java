package com.hwangfantasy.beautify.impl;

import com.alibaba.druid.sql.SQLUtils;


/**
 * Created by hwangfantasy on 2017/8/9.
 * 采用alibaba 的druid 的sqlutils
 */
public class BeautifySql {

    public BeautifySql() {
    }

    public static String beautifySql(String sourceSql, String sqlType){
        return SQLUtils.format(sourceSql,sqlType);
    }
}
