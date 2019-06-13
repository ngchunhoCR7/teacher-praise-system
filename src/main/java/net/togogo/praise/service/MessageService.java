package net.togogo.praise.service;

import com.github.pagehelper.PageInfo;
import net.togogo.praise.entity.TMessage;
import net.togogo.praise.mapper.TMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static net.togogo.praise.utils.MyUtils.*;

/**
 * MessageService
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/10 19:46
 */
@Service
public class MessageService {

    @Autowired
    private TMessageMapper messageMapper;

    /**
     * 获取留言板列表
     *
     * @param request
     * @return
     */
    public PageInfo<TMessage> getMessages(HttpServletRequest request) {
        //初始化分页
        initPaging(request);
        // 获取 Example
        Example example = getExampleDesc(TMessage.class, "messageId");
        // 获取分页后的数据
        List<TMessage> messages = messageMapper.selectByExample(example);
        // 获取分页信息
        PageInfo<TMessage> pageInfo = new PageInfo<>(messages);
        // 设置末页停留防止跳转至首页
        if (pageInfo.getNextPage() == 0) {
            pageInfo.setNextPage(pageInfo.getNavigateLastPage());
        }
        return pageInfo;
    }

    /**
     * 新增留言
     *
     * @param message 留言信息
     */
    @Transactional(rollbackFor = Exception.class)
    public void writeMessage(TMessage message) {
        try {
            messageMapper.insertSelective(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除留言
     *
     * @param messageId 留言编号
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteMessage(Integer messageId) {
        try {
            messageMapper.deleteByPrimaryKey(messageId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
