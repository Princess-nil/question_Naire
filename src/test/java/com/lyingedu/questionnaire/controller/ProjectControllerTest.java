package com.lyingedu.questionnaire.controller;

import jakarta.annotation.Resource;
import com.lyingedu.questionnaire.beans.HttpResponseEntity;
import com.lyingedu.questionnaire.dao.entity.ProjectEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@RunWith(SpringRunner.class)
class ProjectControllerTest {
    @Resource
    private ProjectController projectController;
    @Test
    void queryProjectList() {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectName("test");
        HttpResponseEntity httpResponseEntity = projectController.queryProjectList(projectEntity);
        System.out.println(httpResponseEntity.getData());
        projectEntity.setProjectName("noresult");
        HttpResponseEntity httpResponseEntity1 = projectController.queryProjectList(projectEntity);
        System.out.println(httpResponseEntity1.getData());
    }

    @Test
    void addProjectInfo() {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectName("test-junit-add");

        HttpResponseEntity httpResponseEntity = projectController.addProjectInfo(projectEntity);
        System.out.println(httpResponseEntity.getData());
        HttpResponseEntity httpResponseEntity1 = projectController.queryProjectList(projectEntity);
        String result = httpResponseEntity1.getData().toString();
        String id = result.substring(result.indexOf("\"id\":")+6,result.indexOf(", \"userId\"")-1);
        System.out.println(id);
        projectEntity.setId(id);
        HttpResponseEntity httpResponseEntity2 = projectController.deleteProjectById(projectEntity);
        System.out.println(httpResponseEntity2.getData());
        projectEntity.setProjectName(null);
        HttpResponseEntity httpResponseEntity3 = projectController.addProjectInfo(projectEntity);
        System.out.println(httpResponseEntity3.getData());
    }

    @Test
    void modifyProjectInfo() {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectName("test-junit-modify");
        projectEntity.setProjectContent("test-junit-modify");
        HttpResponseEntity httpResponseEntity = projectController.addProjectInfo(projectEntity);
        System.out.println(httpResponseEntity.getData());
        HttpResponseEntity httpResponseEntity1 = projectController.queryProjectList(projectEntity);
        String result = httpResponseEntity1.getData().toString();
        System.out.println(result);
        String id = result.substring(result.indexOf("\"id\":")+6,result.indexOf(", \"userId\"")-1);
        System.out.println(id);
        projectEntity.setId(id);
        projectEntity.setProjectName("test-junit-modify-modify");
        projectEntity.setProjectContent("test-junit-modify-modify");
        HttpResponseEntity httpResponseEntity2 = projectController.modifyProjectInfo(projectEntity);
        System.out.println(httpResponseEntity2.getData());
        HttpResponseEntity httpResponseEntity3 = projectController.queryProjectList(projectEntity);
        System.out.println(httpResponseEntity3.getData());
        projectEntity.setProjectName("test-junit-modify-modify-modify-modify-modify-modify-modify-modify-modify-modify-modify-modify-modify-modify-modify-modify-modify-modify-modify-modify-modify-modify-modify-modify-modify");
        HttpResponseEntity httpResponseEntity4 = projectController.modifyProjectInfo(projectEntity);
        System.out.println(httpResponseEntity4.getData());
        HttpResponseEntity httpResponseEntity5 = projectController.deleteProjectById(projectEntity);
        System.out.println(httpResponseEntity5.getData());

    }

    @Test
    void deleteProjectById() {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectName("test-junit-delete");
        HttpResponseEntity httpResponseEntity = projectController.addProjectInfo(projectEntity);
        System.out.println(httpResponseEntity.getData());
        HttpResponseEntity httpResponseEntity1 = projectController.queryProjectList(projectEntity);
        String result = httpResponseEntity1.getData().toString();
        System.out.println(result);
        String id = result.substring(result.indexOf("\"id\":")+6,result.indexOf(", \"userId\"")-1);
        System.out.println(id);
        projectEntity.setId(id);
        HttpResponseEntity httpResponseEntity2 = projectController.deleteProjectById(projectEntity);
        System.out.println(httpResponseEntity2.getData());
        projectEntity.setId(null);
        HttpResponseEntity httpResponseEntity3 = projectController.deleteProjectById(projectEntity);
        System.out.println(httpResponseEntity3.getData());
        System.out.println(httpResponseEntity3.getMessage());
    }
}