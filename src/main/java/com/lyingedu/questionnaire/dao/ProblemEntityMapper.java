package com.lyingedu.questionnaire.dao;

import com.lyingedu.questionnaire.dao.entity.ProblemEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProblemEntityMapper {
    List<ProblemEntity> queryProblem(ProblemEntity problemEntity);
    int addProblem(List<ProblemEntity> problemEntity);
    int updateByPrimaryKeySelective(ProblemEntity problemEntity);
    int deleteProblemById(ProblemEntity problemEntity);

    int deleteProblemByQuestionnaireId(String questionnaireId);
}
