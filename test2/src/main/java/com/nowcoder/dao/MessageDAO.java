package com.nowcoder.dao;

import com.nowcoder.model.Message;
import com.nowcoder.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 殷鑫 on 2017/2/4.
 */

@Mapper
public interface MessageDAO {
    String TABLE_NAME = " message ";
    String INSERT_FIELDS = " from_id, to_id, content, created_date, has_read, conversation_id ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;
    @Insert({"insert into " , TABLE_NAME , "(", INSERT_FIELDS, ")",
            " values(#{fromId},#{toId},#{content},#{createdDate},#{hasRead},#{conversationId})"})
    int addMessage(Message message);

    @Select({"select ",SELECT_FIELDS," from ",TABLE_NAME ," where conversation_id=#{conversationId} order by created_date desc limit #{offset},#{limit} "})
    List<Message> getConversationDetail(@Param("conversationId") String conversationId,@Param("offset")int offset,@Param("limit") int limit);

    //select * from message group by conversation_id
    //select * from (select * from message order by created_date desc) tt  order by conversation_id 找到每一组中最新的
    //select *, count(id) as cnt from (select * from message order by created_date desc) tt group by conversation_id order by created_date desc;
    //找到每组最新的并记录每组中含多少个，并通过时间排个序

    @Select({"select ", INSERT_FIELDS, " , count(id) as id from ( select * from ", TABLE_NAME,
            " where from_id=#{userId} or to_id=#{userId} order by created_date desc ) tt group by conversation_id order by created_date desc limit #{offset}, #{limit}"})
    List<Message> getConversationList(@Param("userId") int userId,
                                      @Param("offset") int offset,
                                      @Param("limit") int limit);

    @Select({"select count(id) from ", TABLE_NAME, "where has_read=0 and to_id=#{userId} and conversation_id=#{conversationId}"})
    int getNoReadMessageCount(@Param("userId") int UserId, @Param("conversationId") String conversationId);

    @Update({"update ",TABLE_NAME, "set has_read=1 where to_id=#{userId} and conversation_id=#{conversationId}"})
    int updateHasRead(@Param("userId")int userId,@Param("conversationId")String conversationId);
}
