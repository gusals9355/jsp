package com.example.boardver6_1.model.dao;

import com.example.boardver6_1.model.vo.UserEntity;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public interface UserDAO {

    void insertUser(UserEntity vo);
    String UserIdChk(UserEntity vo);
}
