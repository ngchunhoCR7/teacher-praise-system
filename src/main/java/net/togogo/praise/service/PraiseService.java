package net.togogo.praise.service;

import net.togogo.praise.entity.TMessage;
import net.togogo.praise.entity.TPraise;
import net.togogo.praise.entity.TStudent;
import net.togogo.praise.mapper.TPraiseMapper;
import net.togogo.praise.mapper.TStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PraiseService
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/10 21:57
 */
@Service
public class PraiseService {

    @Autowired
    private TStudentMapper studentMapper;

    @Autowired
    private TPraiseMapper praiseMapper;

    /**
     * 提交点赞
     *
     * @param praise 点赞信息
     */
    @Transactional(rollbackFor = Exception.class)
    public void submitPraise(TPraise praise) {
        try {
            // 查询学生
            TStudent student = studentMapper.selectByPrimaryKey(praise.getStudentId());
            // 设置班级编号
            praise.setClassId(student.getClassId());
            praiseMapper.insertSelective(praise);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
