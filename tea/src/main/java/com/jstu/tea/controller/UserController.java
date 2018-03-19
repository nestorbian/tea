package com.jstu.tea.controller;

import com.jstu.tea.enums.Status;
import com.jstu.tea.model.Result;
import com.jstu.tea.model.User;
import com.jstu.tea.service.UserService;
import com.jstu.tea.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/tea")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    public Result register(@RequestBody User user) {
        Result result = new Result();
        try {
            int i = userService.addUser(user);
            if (i > 0) {
                result.setStatus(Status.SUCCESS.getCode());
                result.setMessage(Message.SUCCESS);
                result.setData(null);
            }
        } catch (Exception e) {
            result.setStatus(Status.FAIL.getCode());
            result.setMessage(e.getMessage());
            result.setData(null);
            return result;
        }
        return result;
    }

    @RequestMapping(path = "/users/{userName}", method = RequestMethod.GET)
    public Result getUserByUserName(@PathVariable String userName) {
        Result result = new Result();
        try {
            User user = userService.getUserByUserName(userName);
            result.setStatus(Status.SUCCESS.getCode());
            result.setMessage(Message.SUCCESS);
            result.setData(user);

        } catch (Exception e) {
            result.setStatus(Status.FAIL.getCode());
            result.setMessage(e.getMessage());
            result.setData(null);
            return result;
        }
        return result;
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public Result getUserByPhone(@RequestParam(name = "phone", value = "") String phone) {
        Result result = new Result();
        try {
            User user = userService.getUserByPhone(phone);
            result.setStatus(Status.SUCCESS.getCode());
            result.setMessage(Message.SUCCESS);
            result.setData(user);

        } catch (Exception e) {
            result.setStatus(Status.FAIL.getCode());
            result.setMessage(e.getMessage());
            result.setData(null);
            return result;
        }
        return result;
    }
}
