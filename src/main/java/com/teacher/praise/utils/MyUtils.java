package com.teacher.praise.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.ui.Model;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * MyUtils
 *
 * @author ngchunho
 * @version 1.0.0
 * @description 工具类
 * @date 2019/6/10 20:04
 */
public class MyUtils {

    /**
     * 默认分页页码
     */
    private static int PAGE_INDEX = 1;

    /**
     * 默认分页条数
     */
    private static int PAGE_SIZE = 5;

    /**
     * 获取当前 Date
     *
     * @return
     */
    public static String getDate() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.now().format(df);
    }

    /**
     * 获取当前 Datetime
     *
     * @return
     */
    public static String getTime() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(df);
    }

    /**
     * 获取 Example
     *
     * @param entityClass 实体类
     * @param property    对象参数
     * @param value       设置值
     * @return 设置规则后的 example
     */
    public static Example getExample(Class<?> entityClass, String property, Object value) {
        Example example = new Example(entityClass);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(property, value);
        return example;
    }

    /**
     * 获取倒序排序后的 Example
     *
     * @param entityClass 实体类
     * @param property    对象参数
     * @return 倒序排序后的 example
     */
    public static Example getExampleDesc(Class<?> entityClass, String property) {
        Example example = new Example(entityClass);
        example.orderBy(property).desc();
        return example;
    }

    /**
     * 初始化分页
     *
     * @param request HttpServletRequest请求
     */
    public static void initPaging(HttpServletRequest request) {
        // 设置当前页码
        int currentPage = getPage(request);
        // 设置每页显示数量
        int pageSize = getSize(request);
        // 设置分页信息
        PageHelper.startPage(currentPage, pageSize);
    }

    /**
     * 获取查询的页码
     *
     * @param request HttpServletRequest请求
     * @return currentPage 当前页码
     */
    private static int getPage(HttpServletRequest request) {
        HttpSession session = request.getSession();

        int currentPage;
        String page = request.getParameter("pageNum");
        String firstPage = request.getParameter("firstPage");
        String lastPage = request.getParameter("lastPage");
        Integer pageBySession = (Integer) session.getAttribute("pageNum");

        // 判断是否为空
        if (isNotNull(page)) {
            // 设置分页查询的页码
            currentPage = Integer.parseInt(page);
        } else if (isNotNull(pageBySession)) {
            // 再从session中查找
            currentPage = pageBySession;
        } else {
            currentPage = PAGE_INDEX;
        }

        // 判断是否为首页和末页，并配置弹窗信息
        if (isNotNull(firstPage) && "true".equals(firstPage)) {
            session.setAttribute("alert", "已是首页！");
        }
        if (isNotNull(lastPage) && "true".equals(lastPage)) {
            session.setAttribute("alert", "已是末页！");
        }
        // 把page保存在session中
        session.setAttribute("pageNum", currentPage);

        return currentPage;
    }

    /**
     * 获取每页查询的条数
     *
     * @param request HttpServletRequest请求
     * @return size 每页查询的条数
     */
    private static int getSize(HttpServletRequest request) {
        HttpSession session = request.getSession();
        // 获取参数
        String pageSize = request.getParameter("pageSize");
        Integer pageSizeBySession = (Integer) session.getAttribute("pageSize");

        Integer size;
        // 判断每页条数是否为空
        if (isNotNull(pageSize)) {
            // 先从request中查找
            size = Integer.parseInt(pageSize);
        } else if (isNotNull(pageSizeBySession)) {
            // 再从session中查找
            size = pageSizeBySession;
        } else {
            // 若都没有则默认设置为10
            size = PAGE_SIZE;
        }
        // 把pageSize保存在session中
        session.setAttribute("pageSize", size);

        return size;
    }

    /**
     * 判断object是否为空
     *
     * @param object 泛型
     * @return true or false
     */
    private static boolean isNotNull(Object object) {
        return object != null && !"".equals(object);
    }
}
