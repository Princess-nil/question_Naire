package com.lyingedu.questionnaire.controller;

import jakarta.annotation.Resource;
import com.lyingedu.questionnaire.beans.HttpResponseEntity;
import org.junit.jupiter.api.Test;
import com.lyingedu.questionnaire.beans.AnswerEntity;
import com.lyingedu.questionnaire.dao.entity.AnswerSheetEntity;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest
@RunWith(SpringRunner.class)
class AnswerSheetControllerTest {

    @Resource
    private AnswerSheetController answerSheetController;
    @Test
    void queryAnswerSheetInfo() {
        AnswerSheetEntity answerSheetEntity = new AnswerSheetEntity();
        answerSheetEntity.setAnswerUser("test");
        answerSheetEntity.setQuestionnaireId("testQuestionnaireID");
        List<AnswerEntity> answerEntityList = new ArrayList<>();
        answerSheetEntity.setAnswer(answerEntityList);
        HttpResponseEntity httpResponseEntity = answerSheetController.queryAnswerSheetInfo(answerSheetEntity);
        System.out.println(httpResponseEntity.getData());
        answerSheetEntity.setAnswerUser("noUser");
        answerSheetEntity.setQuestionnaireId("noQuestionnaireID");
        answerSheetEntity.setAnswer(answerEntityList);
        HttpResponseEntity httpResponseEntity1 = answerSheetController.queryAnswerSheetInfo(answerSheetEntity);
        System.out.println(httpResponseEntity1.getData());
    }

    @Test
    void addAnswerSheetInfo() {
        AnswerSheetEntity answerSheetEntity = new AnswerSheetEntity();
        answerSheetEntity.setAnswerUser("test");
        answerSheetEntity.setQuestionnaireId("testQuestionnaireID");
        List<AnswerEntity> answerEntityList = new ArrayList<>();
        answerSheetEntity.setAnswer(answerEntityList);
        answerSheetEntity.setId("testID");

        HttpResponseEntity httpResponseEntity = answerSheetController.addAnswerSheetInfo(answerSheetEntity);
        System.out.println(httpResponseEntity.getData());
        HttpResponseEntity httpResponseEntity1 = answerSheetController.queryAnswerSheetInfo(answerSheetEntity);
        String result = httpResponseEntity1.getData().toString();
        String id = result.substring(result.indexOf("\"id\":")+6,result.indexOf(", \"answerUser\"")-1);
        System.out.println(id);
        answerSheetEntity.setAnswerUser(id);
        HttpResponseEntity httpResponseEntity2 = answerSheetController.deleteAnswerSheetById(answerSheetEntity);
        System.out.println(httpResponseEntity2.getData());

        answerSheetEntity.setId(null);
        answerSheetEntity.setAnswerUser(null);
        HttpResponseEntity httpResponseEntity3 = answerSheetController.addAnswerSheetInfo(answerSheetEntity);
        System.out.println(httpResponseEntity3.getData());
        HttpResponseEntity  httpResponseEntity4 = answerSheetController.queryAnswerSheetInfo(answerSheetEntity);
        System.out.println(httpResponseEntity4.getData());
    }

    @Test
    void deleteAnswerSheetById() {
        AnswerSheetEntity answerSheetEntity = new AnswerSheetEntity();
        answerSheetEntity.setId("testID");
        answerSheetEntity.setQuestionnaireId("testQuestionnaireID");
        List<AnswerEntity> answerEntityList = new ArrayList<>();
        answerSheetEntity.setAnswer(answerEntityList);
        answerSheetEntity.setAnswerUser("testUser");
        HttpResponseEntity  httpResponseEntity = answerSheetController.addAnswerSheetInfo(answerSheetEntity);
        System.out.println(httpResponseEntity.getData());
        HttpResponseEntity httpResponseEntity1 = answerSheetController.queryAnswerSheetInfo(answerSheetEntity);
        String result = httpResponseEntity1.getData().toString();
        System.out.println(result);
        String id = result.substring(result.indexOf("\"id\":")+6,result.indexOf(", \"answerUser\"")-1);
        System.out.println(id);
        answerSheetEntity.setAnswerUser(id);
        HttpResponseEntity httpResponseEntity2 = answerSheetController.deleteAnswerSheetById(answerSheetEntity);
        System.out.println(httpResponseEntity2.getData());

        answerSheetEntity.setId(null);
        HttpResponseEntity httpResponseEntity3 = answerSheetController.deleteAnswerSheetById(answerSheetEntity);
        System.out.println(httpResponseEntity3.getData());

    }
}