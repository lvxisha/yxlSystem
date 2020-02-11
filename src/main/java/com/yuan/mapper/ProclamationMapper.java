package com.yuan.mapper;

import com.yuan.model.Proclamation;

public interface ProclamationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Proclamation record);

    int insertSelective(Proclamation record);

    Proclamation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Proclamation record);

    int updateByPrimaryKey(Proclamation record);
}