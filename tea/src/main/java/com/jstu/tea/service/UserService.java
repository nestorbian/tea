package com.jstu.tea.service;

import com.jstu.tea.model.User;

public interface UserService {
    public User getUserByUserName(String userName);

    public User getUserByPhone(String phone);

    public int addUser(User user);
}
