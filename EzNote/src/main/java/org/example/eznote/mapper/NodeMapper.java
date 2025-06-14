package org.example.eznote.mapper;

import org.apache.ibatis.annotations.*;
import org.example.eznote.pojo.Node;

@Mapper
public interface NodeMapper {
    @Insert("insert into Node(id,note_id,title,position_x,position_y,size,color,style,,create_time,update_time) values#{id},#{noteId},#{title},#{positionX},#{positionY},#{size},#{color},#{style},#{createTime},#{updateTime})")
    void insert(Node node);

    @Select("select * from Node where id = #{id}")
    Node selectById(Long id);

    @Select("select * from Node where note_id = #{noteId} order by position_y,position_x")
    Node selectByNoteId(Long noteId);

    @Update("update Node set title = #{title},position_x = #{positionX},position_y = #{positionY},size = #{size},color = #{color},style = #{style},update_time = #{updateTime} where id = #{id}")
    void update(Node node);

    @Delete("delete from Node where id = #{id}")
    void delete(Long id);
}
