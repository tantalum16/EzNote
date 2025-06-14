package org.example.eznote.mapper;

import org.apache.ibatis.annotations.*;
import org.example.eznote.pojo.User;

@Mapper
public interface UserMapper {
    @Insert("insert into user(id,username,email,password,create_time,update_time) values ,{#{id},#{username},#{email},#{password},#{createTime},#{updateTime})")
    public void insert(User user);

    @Select("select * from User where id = #{id}")
    public User selectById(Long id);

    @Select("select * from User where username = #{username}")
    public User selectByUsername(String username);

    @Select("select * from User where email = #{email}")
    public User selectByEmail(String email);

    @Select("select * from User where username = #{username} and password = #{password}")
    public User selectByUsernameAndPassword(User user);
    @Update("update User SET username = #{username},email = #{email},password = #{password},update_time = #{updateTime} where id = #{id}")
    public void update(User user);

    @Delete("delete from User where id = #{id}")
    public void delete(Long id);
}
