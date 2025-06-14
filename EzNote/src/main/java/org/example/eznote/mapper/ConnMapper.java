package org.example.eznote.mapper;

import org.apache.ibatis.annotations.*;
import org.example.eznote.pojo.Conn;

import java.util.List;

@Mapper
public interface ConnMapper {
    @Insert("insert into Conn(id,source_node_id,target_node_id,type,create_time,update_time) values(#{id}#{sourceNodeId},#{targetNodeId},#{type},#{createTime},#{updateTime})")
    void insert(Conn conn);

    @Select("select * from Conn where id = #{id}")
    Conn selectById(Long id);

    @Select("select * from Conn where source_node_id = #{sourceNodeId}")
    List<Conn> selectBySourceNodeId(Long sourceNodeId);

    @Select("select * from Conn where target_node_id = #{targetNodeId}")
    List<Conn> selectByTargetNodeId(Long targetNodeId);

    @Update("update Conn set target_node_id = #{targetNodeId},type = #{type}, update_time = #{updateTime} where id = #{id}")
    void update(Conn conn);

    @Delete("delete from Conn where id = #{id}")
    void delete(Long id);

}
