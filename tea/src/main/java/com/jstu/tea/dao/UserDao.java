package com.jstu.tea.dao;

import com.jstu.tea.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface UserDao {
    public User getUserByUserName(@Param("userName") String userName);

    public User getUserByPhone(@Param("phone") String phone);

    public int addUser(User user);

}
