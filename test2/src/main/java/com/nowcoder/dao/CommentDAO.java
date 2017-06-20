package com.nowcoder.dao;

import com.nowcoder.model.Comment;
import org.apache.catalina.startup.PasswdUserDatabase;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 殷鑫 on 2017/2/2.
 */
@Mapper
public interface CommentDAO {
    String TABLE_NAME = " comment ";
    String INSERT_FIELDS = " user_id, content, entity_id, entity_type, created_date, status  ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    //插入
    @Insert({"insert into ",TABLE_NAME,"(", INSERT_FIELDS,
            ") values(#{userId},#{content},#{entityId},#{entityType},#{createdDate},#{status})"})
    int addComment(Comment comment);

    //选出所有评论
    @Select({"select ",SELECT_FIELDS, "from ",TABLE_NAME," where entity_id=#{entityId} and entity_type=#{entityType} order by created_date desc"})
    List<Comment> findCommentByEntity(@Param("entityId")int entityId,@Param("entityType") int entityType);

    @Select({"select count(id)",SELECT_FIELDS, "from ",TABLE_NAME," where entity_id=#{entityId} and entity_type=#{entityType}"})
    int getCommentCount(@Param("entityId") int entityId,@Param("entityType")int entityType);

    @Update({"update " ,TABLE_NAME, " set status=#{status} where id=#{id}"})
    int updateComment(@Param("status") int id,@Param("status") int status );//status = 1 表示删除

    @Select({"select ", SELECT_FIELDS," from ",TABLE_NAME," where id=#{commentId}"})
    Comment selectById(int commentId);
}
