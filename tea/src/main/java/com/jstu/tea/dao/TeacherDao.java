package com.jstu.tea.dao;

import com.jstu.tea.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherDao {

        public List<Teacher> getAllTeacher();

        public Teacher findTeacher(String teacher_id);

        public int addTeacher(Teacher teacher);

}
