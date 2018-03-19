package com.jstu.tea.service.impl;

import com.jstu.tea.dao.UserDao;
import com.jstu.tea.exception.ParameterException;
import com.jstu.tea.model.User;
import com.jstu.tea.service.UserService;
import com.jstu.tea.util.IdUtil;
import com.jstu.tea.util.LogUtil;
import com.jstu.tea.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByUserName(String userName) {
        User user = null;
        if (!StringUtil.isEmpty(userName)) {
            throw new ParameterException("用户名不能为空");
        } else {
            userName = userName.trim();
        }
        try {
            user = userDao.getUserByUserName(userName);
        } catch (Exception e) {
            LogUtil.LogMessageAndError(e);
            throw new RuntimeException("数据库根据用户名获取用户信息出错");
        }
        return user;
    }

    @Override
    public User getUserByPhone(String phone) {
        User user = null;
        if (!StringUtil.isEmpty(phone)) {
            throw new ParameterException("手机号不能为空");
        } else {
            phone = phone.trim();
        }
        if (!phone.matches("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$")) {
            throw new ParameterException("手机号格式不正确");
        }
        try {
            user = userDao.getUserByPhone(phone);
        } catch (Exception e) {
            LogUtil.LogMessageAndError(e);
            throw new RuntimeException("数据库根据手机号获取用户信息出错");
        }
        return user;
    }

    @Override
    public int addUser(User user) {
        int i;
        user.setUserId(IdUtil.getUUID());
        user.setCreateTime(new Timestamp(new Date().getTime()));
        if (!StringUtil.isEmpty(user.getUserName())) {
            throw new ParameterException("用户名不能为空");
        } else {
            user.setUserName(user.getUserName().trim());
            User userByUserName = null;
            try {
                userByUserName = userDao.getUserByUserName(user.getUserName());
            } catch (Exception e) {
                LogUtil.LogMessageAndError(e);
                throw new RuntimeException("数据库根据用户名获取用户信息出错");
            }
            if (userByUserName != null) {
                throw new RuntimeException("用户名已存在");
            }
        }
        if (!StringUtil.isEmpty(user.getPassword())) {
            throw new ParameterException("密码不能为空");
        } else {
            user.setPassword(user.getPassword().trim());
        }
        if (!StringUtil.isEmpty(user.getPhone())) {
            throw new ParameterException("手机号不能为空");
        } else {
            user.setPhone(user.getPhone().trim());
        }
        if (!user.getPhone().matches("^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$") || user.getPhone().length() < 11) {
            throw new ParameterException("手机号格式不正确");
        } else {
            User userByPhone = null;
            try {
                userByPhone = userDao.getUserByPhone(user.getPhone());
            } catch (Exception e) {
                LogUtil.LogMessageAndError(e);
                throw new RuntimeException("数据库根据手机号获取用户信息出错");
            }
            if (userByPhone != null) {
                throw new RuntimeException("手机号已被绑定");
            }
        }
        try {
            i = userDao.addUser(user);
        } catch (Exception e) {
            LogUtil.LogMessageAndError(e);
            System.out.println(e);
            throw new RuntimeException("数据库注册用户信息出错");
        }
        return i;
    }
}
