package net.togogo.praise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;
/**
 * PraiseApplication
 *
 * @author ngchunho
 * @date 2019/6/7 21:18
 * @description 系统启动类
 * @version 1.0.0
 */
@SpringBootApplication
//扫描 mybatis mapper 包路径
@MapperScan(basePackages = "net.togogo.praise.mapper")
public class PraiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(PraiseApplication.class, args);
    }

}
