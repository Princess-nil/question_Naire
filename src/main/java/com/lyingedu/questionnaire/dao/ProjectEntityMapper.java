package com.lyingedu.questionnaire.dao;

import com.lyingedu.questionnaire.dao.entity.ProjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ProjectEntityMapper {
    List<ProjectEntity> queryProjectList(ProjectEntity projectEntity);
    int addProjectInfo(ProjectEntity projectEntity);
    int updateByPrimaryKeySelective(ProjectEntity projectEntity);
    int deleteProjectById(ProjectEntity projectEntity);
}
