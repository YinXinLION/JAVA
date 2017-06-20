package com.nowcoder.service;

import com.nowcoder.dao.CommentDAO;
import com.nowcoder.dao.QuestionDAO;
import com.nowcoder.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * Created by 殷鑫 on 2017/2/2.
 */
@Service
public class CommentService {
    @Autowired
    CommentDAO commentDao;
    @Autowired
    SensitiveService sensitiveService;

    public List<Comment> getCommentByEntity(int entityId,int entityType){
        List<Comment> list = commentDao.findCommentByEntity(entityId,entityType);
        return list;
    }

    public int addComment(Comment comment){
        comment.setContent(HtmlUtils.htmlEscape(comment.getContent()));
        comment.setContent(sensitiveService.filter(comment.getContent()));
        int i = 0;
        i = commentDao.addComment(comment);
        if (i != 0){
            return comment.getId();
        }
        return i;
    }

    //获取某一条评论
    public Comment selectById(int commentId){
        return commentDao.selectById(commentId);
    }

    //获得某个entity的评论总数
    public int getCommentCount(int entityId,int entityType){
        int count = commentDao.getCommentCount(entityId,entityType);
        return count;
    }

    //删除
    public int deleteComment(int commentId){
        return commentDao.updateComment(commentId, 1) > 0? commentId : 0;
    }
}
