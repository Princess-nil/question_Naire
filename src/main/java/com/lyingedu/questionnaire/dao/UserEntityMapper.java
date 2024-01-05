package com.lyingedu.questionnaire.dao;

import com.lyingedu.questionnaire.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

//@Repository
@Component
@Mapper
public interface UserEntityMapper {
    /**
     * Query user list
     * */
    List<UserEntity> queryUserList(UserEntity userEntity);

    /**
     * Create user base information
     * */
    int insert(UserEntity userEntity);

    /**
     * Delete user by id
     * */
    int deleteUserById(UserEntity userEntity);
    /**
     * Delete user by name
     * */
    int deleteUserByName(UserEntity userEntity);

    /**
     * edit user information
     * */
    int updateByPrimaryKeySelective(UserEntity userEntity);

    /**
     * Find user
     * */
    List<UserEntity> selectUserInfo(UserEntity userEntity);
}
