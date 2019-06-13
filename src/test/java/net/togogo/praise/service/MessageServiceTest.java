package net.togogo.praise.service;

import com.github.pagehelper.PageHelper;
import net.togogo.praise.entity.TMessage;
import net.togogo.praise.mapper.TMessageMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static net.togogo.praise.utils.MyUtils.getExampleDesc;

/**
 * MessageServiceTest
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/10 20:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageServiceTest {

    @Autowired
    private TMessageMapper messageMapper;

    @Test
    public void testWrite() {
        TMessage message = new TMessage();
        message.setStudentId(1600502101);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        message.setMessageTime(LocalDateTime.now().format(df));
        message.setNote("我好惨啊怎么又被扣分了~");
        messageMapper.insertSelective(message);
    }

    @Test
    public void testUpdate() {
        TMessage message = messageMapper.selectByPrimaryKey(1);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        message.setMessageTime(LocalDateTime.now().format(df));
        messageMapper.updateByPrimaryKey(message);
    }

    @Test
    public void testSelect() {
        PageHelper.startPage(1, 1);
        Example example = getExampleDesc(TMessage.class, "messageId");
        List<TMessage> messages = messageMapper.selectByExample(example);
        for(TMessage tm : messages) {
            System.out.println(tm.getMessageId() + " " + tm.getMessageTime() + " " + tm.getNote());
        }
    }

}