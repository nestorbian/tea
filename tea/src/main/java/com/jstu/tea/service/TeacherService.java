package com.jstu.tea.service;


import com.jstu.tea.model.Teacher;

import java.util.List;

public interface TeacherService {
    public List<Teacher> getAllTeacher();

    public Teacher findTeacher(String teacher_id);

    public int addTeacher(Teacher teacher);

}
