package com.baizhi.util;

import java.sql.ResultSet;

//  rs   转换成具体的实体      接口回调
public interface RowMapper<T> {
	T mapRow(ResultSet rs);
}
