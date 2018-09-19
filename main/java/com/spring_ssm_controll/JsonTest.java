package com.spring_ssm_controll;


import com.spring_ssm_po.StudentCustom;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//json交互
@Component
@RestController//Controller+ResponseBody   只能返回json，xml等不能呢个返回html，jsp页面
public class JsonTest {
    // 请求json串返回json
    @PostMapping(value = "/requestJson")
    public StudentCustom requestJson(@RequestBody StudentCustom studentCustom) {

        return studentCustom;
    }
    // 请求json串返回json
    @PostMapping(value = "/requestJsonString")
    public String requestJsonString(@RequestBody String name1) {

        return name1;
    }
    // 请求key/value返json
    @RequestMapping("/responseJson")
    public StudentCustom responseJson(StudentCustom studentCustom) {

        return studentCustom;
    }


    //
}
