package com.spring_ssm_controll;

import com.spring_ssm_po.StudentCustom;
import com.spring_ssm_po.StudentVo;
import com.spring_ssm_service.StudentService;
import com.spring_ssm_service_impl.StudentServiceImpl;
import com.spring_ssm_valitation.ValidGroup1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;//使用接口

    //商品显示下拉框
    @ModelAttribute("studentTypes")
    public Map<String, String> getstudentTypes() {
        Map<String, String> map = new HashMap<>();
        map.put("xu", "xue");
        map.put("te", "tea");
        return map;
    }

    @RequestMapping("student")
    public ModelAndView selectStudent(StudentVo studentVo) throws Exception {
        List<StudentCustom> list = studentService.selectStudent(studentVo);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("/index.jsp");
        return modelAndView;
    }

    @RequestMapping("studentId")
    //@RequestParam绑定参数，required = true必须传入参数
    //defaultValue可以设置默认值，如果id没有传入参数，将默认值与形参绑定
    public ModelAndView selectIdStudent(@RequestParam(value = "id", required = true) Integer tid)
            throws Exception {
        StudentCustom studentCustom = studentService.getIdStudent(tid);


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studentCustom1", studentCustom);
        modelAndView.setViewName("/showIdStudent.jsp");
        return modelAndView;
    }

    //限制请求的方法
    //@Validated与bindingResult必须配对使用，位置固定
    //@Validated(value = ValidGroup1.class)定义组，只执行该组的的校验
    //@ModelAttribute("studentCustom1")指定回显pojo在request的key，如果页面的pojo名称与这里相同默认回显不需要特别指定
    @RequestMapping(value = "UpdateSccese", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView updateIdStudent(@Validated(value = ValidGroup1.class) @ModelAttribute("studentCustom1") StudentCustom studentCustom,
                                        BindingResult bindingResult, Integer id, Model model,
                                        MultipartFile student_pic) throws Exception {
//        int id = Integer.parseInt(request.getParameter("id"));
//        String name = request.getParameter("name");
//        String address = request.getParameter("address");

        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            System.out.println(studentCustom.getName1());
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            modelAndView.addObject("allErrors", allErrors);

            //另一种回显
            modelAndView.addObject("studentCustom1", studentCustom);
            System.out.println(allErrors.get(0).getDefaultMessage());

            modelAndView.setViewName("/showIdStudent.jsp");
            return modelAndView;
        }
        String originalFilename = student_pic.getOriginalFilename();
        if (student_pic != null && originalFilename != null && !originalFilename.equals("")) {
            //存储图片的物理路径
            String pic_path = "/home/lgh/Pictures/";
            //获取图片名称


            //新的图片名称
            String newfilename = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));

            //将图片名称写入studentCustom
            studentCustom.setPic(newfilename);
            //新图片
            File newFile = new File(pic_path + newfilename);

            //将内存中的数据写入磁盘
            student_pic.transferTo(newFile);


        }

        System.out.println(studentCustom.getPic());
        studentService.updateIdStudentCustom(id, studentCustom);


        //重定向到商品查询页面
        modelAndView.setViewName("redirect:student.action");
        return modelAndView;
    }

    @RequestMapping("deleteStudent")
    public String deleteStudentId(Integer[] student_id) {

        if (student_id != null && !student_id.equals("")) {
            studentService.deleteIdStudent(student_id);
        }


        return "redirect:student.action";
    }

    @RequestMapping("updateListStudent")
    public String updateListStudent(StudentVo studentVo) {


        return "redirect:student.action";
    }

    //REST
    //springREST/{id}的{id}为url的参数传到@PathVariable指定的名称当中
    //输出json
    @RequestMapping("springREST/{id}/{type}")
    public @ResponseBody StudentCustom springREST(@PathVariable("id") Integer iddd,@PathVariable("type") Integer type) throws Exception {
        StudentCustom studentCustom = studentService.getIdStudent(iddd);
        System.out.println(type);
        return studentCustom;
    }

}
