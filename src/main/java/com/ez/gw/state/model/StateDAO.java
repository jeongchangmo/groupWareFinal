package com.ez.gw.state.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StateDAO {
	List<StateVO> selectAllState();
}
