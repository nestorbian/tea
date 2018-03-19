package com.jstu.tea.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jstu.tea.enums.Sex;
import com.jstu.tea.model.Teacher;
import com.jstu.tea.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/shell")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @ResponseBody
    @RequestMapping(value = "/teacher", method = RequestMethod.POST)
    public String addTeacher(@RequestBody Teacher teacher) {
        teacher.setSax(Sex.MALE.getSex());
        int i = teacherService.addTeacher(teacher);
        if (i < 0) {
            return "FAILED";
        }
        return "SUCCESS";
    }

    @ResponseBody
    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public Teacher getTeacher(@RequestParam(name = "id", defaultValue = "") String id) {
        return teacherService.findTeacher(id);
    }

    @ResponseBody
    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public Object getTeacher() {
        Logger logger = LoggerFactory.getLogger(TeacherController.class);
        logger.info("logger daily");
        logger.error("logger{}", 1);
        PageHelper.startPage(1, 2);
        List<Teacher> teacherList = teacherService.getAllTeacher();
        PageInfo pageInfo = new PageInfo(teacherList);
        return pageInfo;
    }


}
