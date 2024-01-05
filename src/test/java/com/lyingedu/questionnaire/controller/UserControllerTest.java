package com.lyingedu.questionnaire.controller;

import jakarta.annotation.Resource;
import com.lyingedu.questionnaire.beans.HttpResponseEntity;
import com.lyingedu.questionnaire.dao.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
class UserControllerTest {

    @Resource
    private UserController userController;

    @Test
    void userLogin() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("test");
        userEntity.setPassword("test");
        userEntity.setStatus("1");
        HttpResponseEntity httpResponseEntity = userController.addUserInfo(userEntity);
        System.out.println(httpResponseEntity.getData());
        HttpResponseEntity httpResponseEntity1 = userController.userLogin(userEntity);
        System.out.println(httpResponseEntity1.getData());
        HttpResponseEntity httpResponseEntity2 = userController.queryUserList(userEntity);
        String result = httpResponseEntity2.getData().toString();
        String id = result.substring(result.indexOf("\"id\":")+6,result.indexOf(", \"username\"")-1);
        System.out.println(id);
        userEntity.setId(id);
        HttpResponseEntity httpResponseEntity3 = userController.deleteUserById(userEntity);
        System.out.println(httpResponseEntity3.getData());

        userEntity.setUsername("rtyuiuytrtyuytrtyuiuytrertyufdsgahgdaggdiugasdgkjdhskgdsfgkdsgjkfdGKjgfdKJhgdfKJgdfJKgfkJgfJKGkjfdsGjkdfgskjgFSDKgFDJKS");
        userEntity.setPassword("123");
        userEntity.setStatus("1");
        HttpResponseEntity httpResponseEntityNoResult = userController.userLogin(userEntity);
        System.out.println(httpResponseEntityNoResult.getData());
    }


    @Test
    void queryUserList() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("test");
        HttpResponseEntity httpResponseEntityUser = userController.queryUserList(userEntity);
        System.out.println(httpResponseEntityUser);
        userEntity.setUsername("noresult");
        HttpResponseEntity httpResponseEntityNoResult = userController.queryUserList(userEntity);
        System.out.println(httpResponseEntityNoResult.getData());
    }

    @Test
    void addUserInfo() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("testAdd");
        userEntity.setStatus("1");
        HttpResponseEntity httpResponseEntity = userController.addUserInfo(userEntity);
        System.out.println(httpResponseEntity.getData());
        HttpResponseEntity httpResponseEntity1 = userController.queryUserList(userEntity);
        ArrayList<UserEntity> resultList = (ArrayList<UserEntity>) httpResponseEntity1.getData();
        String result = resultList.get(0).toString();
        System.out.println(result);
        String id = result.substring(result.indexOf("\"id\":")+6,result.indexOf(", \"username\"")-1);
        System.out.println(id);
        userEntity.setId(id);
        HttpResponseEntity httpResponseEntity2 = userController.deleteUserById(userEntity);
        System.out.println(httpResponseEntity2.getData());
        userEntity.setUsername(null);
        HttpResponseEntity httpResponseEntity3 = userController.addUserInfo(userEntity);
        System.out.println(httpResponseEntity3.getData());

    }

    @Test
    void modifyUserInfo() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("testModify");
        userEntity.setPassword("123");
        userEntity.setStatus("1");
        HttpResponseEntity httpResponseEntity = userController.addUserInfo(userEntity);
        System.out.println(httpResponseEntity.getData());
        HttpResponseEntity httpResponseEntity1 = userController.queryUserList(userEntity);
        ArrayList<UserEntity> resultList = (ArrayList<UserEntity>) httpResponseEntity1.getData();
        String result = resultList.get(0).toString();
        System.out.println(result);
        String id = result.substring(result.indexOf("\"id\":")+6,result.indexOf(", \"username\"")-1);
        System.out.println(id);
        userEntity.setId(id);
        userEntity.setUsername("testModify1");
        userEntity.setPassword("123");
        userEntity.setStatus("1");
        HttpResponseEntity httpResponseEntity2 = userController.modifyUserInfo(userEntity);
        System.out.println(httpResponseEntity2.getData());
        HttpResponseEntity httpResponseEntity3 = userController.queryUserList(userEntity);
        System.out.println(httpResponseEntity3.getData());
        userEntity.setUsername("testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify-testModify");
        HttpResponseEntity httpResponseEntity5 = userController.modifyUserInfo(userEntity);
        System.out.println(httpResponseEntity5.getData());
        HttpResponseEntity httpResponseEntity6 = userController.deleteUserById(userEntity);
        System.out.println(httpResponseEntity6.getData());
    }

    @Test
    void deleteUserById() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("testDelete");
        userEntity.setPassword("123");
        userEntity.setStatus("1");
        HttpResponseEntity httpResponseEntity = userController.addUserInfo(userEntity);
        System.out.println(httpResponseEntity.getData());
        HttpResponseEntity httpResponseEntity1 = userController.queryUserList(userEntity);
        ArrayList<UserEntity> resultList = (ArrayList<UserEntity>) httpResponseEntity1.getData();
        String result = resultList.get(0).toString();
        String id = result.substring(result.indexOf("\"id\":")+6,result.indexOf(", \"username\"")-1);
        System.out.println(id);
        userEntity.setId(id);
        HttpResponseEntity httpResponseEntity2 = userController.deleteUserById(userEntity);
        System.out.println(httpResponseEntity2.getData());
        userEntity.setId(null);
        HttpResponseEntity httpResponseEntity3 = userController.addUserInfo(userEntity);
        System.out.println(httpResponseEntity3.getData());
        System.out.println(httpResponseEntity3.getMessage());
    }
}