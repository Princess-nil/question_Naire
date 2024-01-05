package com.lyingedu.questionnaire.dao;

import com.lyingedu.questionnaire.dao.entity.AnswerSheetEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AnswerSheetEntityMapper {
    List<AnswerSheetEntity> queryAnswerSheet(AnswerSheetEntity answerSheetEntity);
    int addAnswerSheet(AnswerSheetEntity answerSheetEntity);
    int deleteAnswerSheetById(AnswerSheetEntity answerSheetEntity);
}
