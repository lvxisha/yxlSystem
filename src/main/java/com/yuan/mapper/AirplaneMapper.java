package com.yuan.mapper;

import com.yuan.model.Airplane;

public interface AirplaneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Airplane record);

    int insertSelective(Airplane record);

    Airplane selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Airplane record);

    int updateByPrimaryKey(Airplane record);

	
}