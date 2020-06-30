package com.rain.controller;

import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.rain.domain.Dept;
import com.rain.domain.Salary;
import com.rain.domain.Job;
import com.rain.service.RainService;

@Controller
public class SalaryController {
    @Autowired
    @Qualifier("RainService")
    private RainService rainservice;
    // 如果在目录下输入为空，则跳转到指定链接
    @RequestMapping(value="/salary/")
    public ModelAndView index2(ModelAndView mv){
        mv.setViewName("salary/list");
        return mv;
    }
    // 如果在目录下输入任何不存在的参数，则跳转到list
    @RequestMapping(value="/salary/{formName}")
    public String index2(@PathVariable String formName){
        String blank = "/salary/list";
        return blank;
    }
    @RequestMapping(value="/salary/list",method=RequestMethod.GET)
    public String index(Model model, String content, @RequestParam(name="page",required = true,defaultValue = "1") int page,  @RequestParam(name="size",required = true,defaultValue = "5")int size){
        List<Salary> salary_list = rainservice.get_SalaryList(page,size);
        PageInfo pageInfo=new PageInfo(salary_list);
        model.addAttribute("pageInfo",pageInfo);
        if (content!=null){
            salary_list = rainservice.get_SalaryLikeList(content);
        }
        model.addAttribute("list",salary_list);
        return "salary/list";
    }




    @RequestMapping(value="/salary/add",method=RequestMethod.GET)
    public String add(Model model,Integer id){
        if(id!=null){
            Salary salary = rainservice.get_SalaryInfo(id);
            model.addAttribute("salary",salary);
        }
        List<Dept> dept_list = rainservice.findAllDept();
        List<Job> job_list = rainservice.findAllJob();
        model.addAttribute("job_list", job_list);
        model.addAttribute("dept_list",dept_list);
        return "/salary/add";
    }

    @RequestMapping(value="/salary/add",method=RequestMethod.POST)
    public ModelAndView add(ModelAndView mv,@ModelAttribute Salary salary ,Integer id){
			System.out.println(id);
        if(id!=null){
            rainservice.update_SalaryInfo(salary);
        }else{
            rainservice.insert_SalaryInfo(salary);
        }
        mv.setViewName("redirect:/salary/list");
        return mv;
    }
    @RequestMapping(value="/salary/delete",method=RequestMethod.GET)
    public void delete(Integer id){
//			System.out.println(id);
        if(id!=null){
            rainservice.delete_SalaryInfo(id);
        }
    }
}
