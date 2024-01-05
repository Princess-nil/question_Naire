package com.lyingedu.questionnaire.service;

import com.lyingedu.questionnaire.dao.ProjectEntityMapper;
import com.lyingedu.questionnaire.dao.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectEntityMapper projectEntityMapper;

    public ProjectService(ProjectEntityMapper projectEntityMapper) {
        this.projectEntityMapper = projectEntityMapper;
    }

    public List<ProjectEntity> queryProjectList(ProjectEntity projectEntity) {
        List<ProjectEntity> result = projectEntityMapper.queryProjectList(projectEntity);
        return result;
    }

    public int addProjectInfo(ProjectEntity projectEntity) {
        int result = projectEntityMapper.addProjectInfo(projectEntity);
        return result;
    }

    public int modifyProjectInfo(ProjectEntity projectEntity) {
        int result = projectEntityMapper.updateByPrimaryKeySelective(projectEntity);
        return result;
    }

    public int deleteProjectById(ProjectEntity projectEntity) {
        int result = projectEntityMapper.deleteProjectById(projectEntity);
        return result;
    }
}
