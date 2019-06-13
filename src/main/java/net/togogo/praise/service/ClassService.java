package net.togogo.praise.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.togogo.praise.entity.TClass;
import net.togogo.praise.mapper.TClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static net.togogo.praise.utils.MyUtils.*;

/**
 * ClassService
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/11 18:52
 */
@Service
public class ClassService {

    @Autowired
    private TClassMapper classMapper;

    /**
     * 获取班级列表
     *
     * @param request
     * @return
     */
    public PageInfo<TClass> getClasses(HttpServletRequest request) {
        // 初始化分页
        initPaging(request);
        // 获取分页后的数据
        List<TClass> classes = classMapper.selectAll();
        // 获取分页信息
        PageInfo<TClass> pageInfo = new PageInfo<>(classes);
        // 设置末页停留防止跳转至首页
        if (pageInfo.getNextPage() == 0) {
            pageInfo.setNextPage(pageInfo.getNavigateLastPage());
        }
        return pageInfo;
    }

    /**
     * 根据班号获取班级
     *
     * @param classId
     * @return
     */
    public TClass getClassById(Integer classId) {
        return classMapper.selectByPrimaryKey(classId);
    }

    /**
     * 修改班级信息
     *
     * @param tClass
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateClass(TClass tClass) {
        try {
            classMapper.updateByPrimaryKey(tClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 新增班级
     *
     * @param tClass
     */
    @Transactional(rollbackFor = Exception.class)
    public void insertClass(TClass tClass) {
        try {
            classMapper.insertSelective(tClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除班级
     *
     * @param classId
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteClass(Integer classId) {
        try {
            classMapper.deleteByPrimaryKey(classId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
