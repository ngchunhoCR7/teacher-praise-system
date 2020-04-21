package com.teacher.praise.controller;

import com.github.pagehelper.PageInfo;
import com.teacher.praise.service.MessageService;
import com.teacher.praise.service.StudentService;
import com.teacher.praise.entity.TClass;
import com.teacher.praise.entity.TMessage;
import com.teacher.praise.entity.TStudent;
import com.teacher.praise.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * TeacherController
 *
 * @author ngchunho
 * @version 1.0.0
 * @description
 * @date 2019/6/10 22:05
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ClassService classService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private MessageService messageService;

    /**
     * 获取班级列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String getClasses(HttpServletRequest request, Model model) {
        PageInfo<TClass> classes = classService.getClasses(request);
        model.addAttribute("pageList", classes);
        // 设置分页跳转链接
        model.addAttribute("url", "/teacher/index");
        return "index";
    }

    /**
     * 根据班号获取班级
     *
     * @param classId
     * @param model
     * @return
     */
    @RequestMapping("/getclassbyid")
    public String getClassById(Integer classId, Model model) {
        TClass tClass = classService.getClassById(classId);
        List<TClass> list = new ArrayList<TClass>() {
            {
                add(tClass);
            }
        };
        // 设置分页信息
        PageInfo<TClass> classes = new PageInfo<>();
        classes.setList(list);
        classes.setNavigatepageNums(new int[]{1});
        model.addAttribute("pageList", classes);
        // 设置分页跳转链接
        model.addAttribute("url", "/teacher/index");
        return "index";
    }

    /**
     * 修改班级信息
     *
     * @param tClass
     * @return
     */
    @RequestMapping("/upadateclass")
    public String updateClass(TClass tClass) {
        classService.updateClass(tClass);
        return "redirect:/teacher/index";
    }

    /**
     * 新增班级
     *
     * @param tClass
     * @return
     */
    @RequestMapping("/insertclass")
    public String insertClass(TClass tClass) {
        classService.insertClass(tClass);
        return "redirect:/teacher/index";
    }

    /**
     * 删除班级
     *
     * @param classId
     * @return
     */
    @RequestMapping("/deleteclass")
    public String deleteClass(Integer classId) {
        classService.deleteClass(classId);
        return "redirect:/teacher/index";
    }

    /**
     * 获取学生列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/stumanage")
    public String getStudents(HttpServletRequest request, Model model) {
        PageInfo<TStudent> students = studentService.getStudents(request);
        model.addAttribute("pageList", students);
        // 设置分页跳转链接
        model.addAttribute("url", "/teacher/stumanage");
        return "stumanage";
    }

    /**
     * 根据班号获取学生列表
     *
     * @param request
     * @param classId
     * @param model
     * @return
     */
    @RequestMapping("/getstudentsbycid")
    public String getStudentsByCid(HttpServletRequest request, Integer classId, Model model) {
        PageInfo<TStudent> students = studentService.getStudentsByCid(request, classId);
        model.addAttribute("pageList", students);
        // 设置分页跳转链接
        model.addAttribute("url", "/teacher/stumanage");
        return "stumanage";
    }

    /**
     * 修改学生信息
     *
     * @param student
     * @return
     */
    @RequestMapping("/upadatestudent")
    public String updateStudent(TStudent student) {
        studentService.updateStudent(student);
        return "redirect:/stumanage";
    }

    /**
     * 新增学生
     *
     * @param student
     * @return
     */
    @RequestMapping("/insertstudent")
    public String insertStudent(TStudent student) {
        studentService.insertStudent(student);
        return "redirect:/stumanage";
    }

    /**
     * 删除学生
     *
     * @param studentId
     * @return
     */
    @RequestMapping("/deletestudent")
    public String deleteStudent(Integer studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/stumanage";
    }


    /**
     * 获取留言板列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/message")
    public String getMessages(HttpServletRequest request, Model model) {
        PageInfo<TMessage> messages = messageService.getMessages(request);
        model.addAttribute("pageList", messages);
        // 设置分页跳转链接
        model.addAttribute("url", "/teacher/message");
        return "message";
    }

    /**
     * 删除留言
     *
     * @param messageId
     * @return
     */
    @RequestMapping("/deletemessage")
    public String deleteMessage(Integer messageId) {
        messageService.deleteMessage(messageId);
        return "redirect:/message";
    }

    /**
     * 获取点赞列表
     *
     * @return
     */
    @RequestMapping("/praise")
    public String getPraises() {
        return "praise";
    }

}
