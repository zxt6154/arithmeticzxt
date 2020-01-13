package com.imooc.login.dao;

import com.imooc.login.domain.User;
import com.imooc.login.domain.UserTest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    public User getById(@Param("id")long id	);

    @Insert("insert into user(id, name)values(#{id}, #{name})")
    public int insert(User user);
    @Select("select * from usertest")
    public List<UserTest> getList();
}
