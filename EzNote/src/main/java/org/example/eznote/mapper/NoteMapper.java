package org.example.eznote.mapper;

import org.apache.ibatis.annotations.*;
import org.example.eznote.pojo.Note;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Insert("insert into Note(id,user_id,title,content,create_time,update_time) values(#{id},#{userId},#{title},#{content},#{createTime},#{updateTime})")
    void insert(Note note);

    @Select("select * from Note where id = #{id}")
    Note selectById(long id);

    @Select("select * from Note where user_id = #{userId}")
    List<Note> selectByUserId(long userId);

    @Select("select * from Note where title like #{title}")
    List<Note> selectByTitle(String title);

    @Update("update Note set title = #{title}, content = #{content}, update_time = #{updateTime} where id = #{id}")
    void update(Note note);

    @Delete("delete from Note where id = #{id}")
    void delete(long id);
}
