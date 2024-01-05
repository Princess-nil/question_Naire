package com.lyingedu.questionnaire.common.typehandler;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.ibatis.type.MappedTypes;
import com.lyingedu.questionnaire.beans.AnswerEntity;

@MappedTypes({List.class})
public class AnswerEntityListTypeHandler extends ListTypeHandler<AnswerEntity> {
    @Override
    protected TypeReference<List<AnswerEntity>> specificType() {
        System.out.println("specificType");
        return new TypeReference<List<AnswerEntity>>() {
        };
    }
}

