package com.teacher.praise.service;

import com.github.pagehelper.PageInfo;
import com.teacher.praise.entity.TStudent;
import com.teacher.praise.mapper.TStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.teacher.praise.utils.MyUtils.*;

/**
 * StudentService
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/11 21:00
 */
@Service
public class StudentService {

    @Autowired
    private TStudentMapper studentMapper;

    /**
     * 获取学生列表
     *
     * @param request
     * @return
     */
    public PageInfo<TStudent> getStudents(HttpServletRequest request) {
        // 初始化分页
        initPaging(request);
        // 获取分页后的数据
        List<TStudent> students = studentMapper.selectAll();
        // 获取分页信息
        PageInfo<TStudent> pageInfo = new PageInfo<>(students);
        // 设置末页停留防止跳转至首页
        if (pageInfo.getNextPage() == 0) {
            pageInfo.setNextPage(pageInfo.getNavigateLastPage());
        }
        return pageInfo;
    }

    /**
     * 根据班号获取学生列表
     *
     * @param request
     * @return
     */
    public PageInfo<TStudent> getStudentsByCid(HttpServletRequest request, Integer classId) {
        // 初始化分页
        initPaging(request);
        // 获取 Example
        Example example = getExample(TStudent.class, "classId", classId);
        // 获取分页后的数据
        List<TStudent> students = studentMapper.selectByExample(example);
        // 获取分页信息
        PageInfo<TStudent> pageInfo = new PageInfo<>(students);
        // 设置末页停留防止跳转至首页
        if (pageInfo.getNextPage() == 0) {
            pageInfo.setNextPage(pageInfo.getNavigateLastPage());
        }
        return pageInfo;
    }

    /**
     * 修改学生信息
     *
     * @param student 学生对象
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateStudent(TStudent student) {
        try {
            studentMapper.updateByPrimaryKey(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 新增学生
     *
     * @param student
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertStudent(TStudent student) {
        try {
            studentMapper.insertSelective(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除学生
     *
     * @param studentId
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteStudent(Integer studentId) {
        try {
            studentMapper.deleteByPrimaryKey(studentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
