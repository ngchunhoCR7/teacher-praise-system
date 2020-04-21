package com.teacher.praise.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * MyMapper
 *
 * @author ngchunho
 * @version 1.0.0
 * @date 2019/6/7 17:28
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
