package com.nowcoder.service;

import com.nowcoder.controller.QuestionController;
import com.nowcoder.dao.QuestionDAO;
import com.nowcoder.model.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * Created by nowcoder on 2016/7/15.
 */
@Service
public class QuestionService {
    private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);
    @Autowired
    QuestionDAO questionDAO;
    @Autowired
    SensitiveService sensitiveService;
    //获得最近问题
    public List<Question> getLatestQuestions(int userId, int offset, int limit) {
        return questionDAO.selectLatestQuestions(userId, offset, limit);
    }
    //加入问题
    public int addQuestion(Question question){
        //html文本过滤
        question.setContent(HtmlUtils.htmlEscape(question.getContent()));
        question.setTitle(HtmlUtils.htmlEscape(question.getTitle()));
        //敏感词过滤
        System.out.println(sensitiveService.filter(question.getContent()));
        question.setTitle(sensitiveService.filter(question.getTitle()));
        question.setContent(sensitiveService.filter(question.getContent()));

        return questionDAO.addQuestion(question) > 0 ? question.getId() : 0;
    }

    public Question findQuestion(int id){
        Question question = questionDAO.findQuestionById(id);
        return question;
    }
//    public int updateCommentCount(int id,int count) {
//        return questionDAO.updateCommentCount()
//    }
}
