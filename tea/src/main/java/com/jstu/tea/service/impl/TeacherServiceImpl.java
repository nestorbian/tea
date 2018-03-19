package com.jstu.tea.service.impl;

import com.jstu.tea.dao.TeacherDao;
import com.jstu.tea.model.Teacher;
import com.jstu.tea.service.TeacherService;
import com.jstu.tea.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherMapper;

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherMapper.getAllTeacher();
    }

    @Override
    public Teacher findTeacher(String teacher_id) {
        return teacherMapper.findTeacher(teacher_id);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        teacher.setTeacherId(IdUtil.getUUID());
        return teacherMapper.addTeacher(teacher);
    }
}
