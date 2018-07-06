package com.dzc.servicetwo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ExampleDao {

    String selectNameById(Integer id);

}
