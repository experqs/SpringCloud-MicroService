package com.dzc.servicetwo.dao;

import com.dzc.servicetwo.model.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExampleDao {

    String selectNameById(Integer id);

    List<Integer> listUsersId(@Param("idBegin") Integer idBegin, @Param("idEnd") Integer idEnd);

    List<UserVO> listUsersInfo(List<Integer> idList);

}
