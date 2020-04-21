package com.teacher.praise.service;

import com.github.pagehelper.PageHelper;
import com.teacher.praise.entity.TStudent;
import com.teacher.praise.mapper.TStudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

import static com.teacher.praise.utils.MyUtils.getExample;

/*
 * StudentServiceTest
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/11 21:23
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private TStudentMapper studentMapper;

    @Test
    public void getStudentsByCid() {
        // 初始化分页
        PageHelper.startPage(1, 1);
        // 获取 Example
        Example example = getExample(TStudent.class, "classId", 1);
        // 获取分页后的数据
        List<TStudent> students = studentMapper.selectByExample(example);

        for(TStudent ts : students) {
            System.out.println(ts.getStudentId() + " " + ts.getStudentName() + " " + ts.getPhoneNumber());
        }
    }
}
