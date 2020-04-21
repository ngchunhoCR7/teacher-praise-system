package com.teacher.praise.service;

import com.teacher.praise.mapper.TClassMapper;
import com.teacher.praise.entity.TClass;
import com.teacher.praise.entity.TTeacher;
import com.teacher.praise.mapper.TTeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * TeacherService
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/10 19:46
 */
@Service
public class TeacherService {

    @Autowired
    private TTeacherMapper teacherMapper;

    @Autowired
    private TClassMapper classMapper;

    /**
     * 获取老师列表
     *
     * @return
     */
    public List<TTeacher> getTeachers() {
        return teacherMapper.selectAll();
    }

    /**
     * 获取老师列表
     *
     * @return
     */
    public List<String> getTeachersByClasses() {
        List<String> teachers = new ArrayList<>();
        List<TClass> classes = classMapper.selectAll();
        for (TClass tClass : classes) {
            if (!StringUtils.isEmpty(tClass.getClassTeacher())) {
                teachers.add(tClass.getClassTeacher());
            }
        }
        return teachers;
    }
}
