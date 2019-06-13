package net.togogo.praise.service;

import net.togogo.praise.entity.TClass;
import net.togogo.praise.mapper.TClassMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

/**
 * ClassServiceTest
 *
 * @author ngchunho
 * @date 2019/6/7 22:00
 * @description
 * @version 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    private TClassMapper tClassMapper;

    @Test
    public void testInsert() {
        TClass tClass = new TClass();
        tClass.setClassName("外包161");
        tClass.setClassSize(67);
        tClass.setClassType("外包特色班");
        int result = tClassMapper.insertSelective(tClass);
        System.out.println(result);
    }

    @Test
    public void testSelect() {
        List<TClass> tClasses = tClassMapper.selectAll();
        for (TClass tc : tClasses) {
            System.out.println(tc.getClassId() + " " + tc.getClassName() + " " + tc.getClassSize());
        }
    }

    @Test
    public void testUpdate() {
        TClass tClass = tClassMapper.selectByPrimaryKey(1);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
        tClass.setClassStartTime(localDate.toString());
        tClass.setClassEndTime(localDate.plusDays(2).toString());
        tClassMapper.updateByPrimaryKey(tClass);
        TClass tc = tClassMapper.selectByPrimaryKey(1);
        System.out.println(tc.getClassId() + " " + tc.getClassName() + " " + tc.getClassSize()
                + " " + tc.getClassStartTime() + " " + tc.getClassEndTime());
    }
}
