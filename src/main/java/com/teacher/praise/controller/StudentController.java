package com.teacher.praise.controller;

import com.github.pagehelper.PageInfo;
import com.teacher.praise.service.MessageService;
import com.teacher.praise.service.PraiseService;
import com.teacher.praise.entity.TMessage;
import com.teacher.praise.entity.TPraise;
import com.teacher.praise.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.teacher.praise.utils.MyUtils.getTime;

/**
 * StudentController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description 学生控制类
 * @date 2019/6/10 19:28
 */

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private PraiseService praiseService;

    /**
     * 学生点赞页面
     *
     * @param model
     * @return
     */
    @RequestMapping("/praise")
    public String praise(HttpServletRequest request, Model model) {
        // 获取老师列表
        List<String> teachers = teacherService.getTeachersByClasses();
        model.addAttribute("teacherList", teachers);
        // 获取留言板列表
        PageInfo<TMessage> messages = messageService.getMessages(request);
        model.addAttribute("pageList", messages);
        // 设置分页跳转链接
        model.addAttribute("url", "/student/praise");
        return "student";
    }

    /**
     * 新增留言
     *
     * @return
     */
    @RequestMapping("/write")
    public String writeMessage(TMessage message) {
        message.setMessageTime(getTime());
        messageService.writeMessage(message);
        return "redirect:/student/praise";
    }

    /**
     * 提交点赞
     *
     * @return
     */
    @RequestMapping("/submit")
    public String submitPraise(TPraise praise) {
        praise.setPraiseTime(getTime());
        praiseService.submitPraise(praise);
        return "redirect:/student/praise";
    }
}

