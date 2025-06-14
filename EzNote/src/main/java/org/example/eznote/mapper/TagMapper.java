package org.example.eznote.mapper;

import org.apache.ibatis.annotations.*;
import org.example.eznote.pojo.Tag;

@Mapper
public interface TagMapper {
    @Insert("insert int Tag(id,name,create_time,update_time) values(#{id},#{name},#{createTime},#{updateTime})")
    void insert(Tag tag);

    @Select("select * from Tag where id = #{id}")
    Tag findById(Long id);

    @Select("select *  from Tag where name = #{name}")
    Tag findByName(String name);

    @Update("update Tag set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Tag tag);

    @Delete("delete from Tag where id = #{id}")
    void delete(Long id);
}
