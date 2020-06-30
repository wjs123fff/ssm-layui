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
import com.rain.domain.Quit;
import com.rain.domain.Job;
import com.rain.domain.Type;
import com.rain.service.RainService;

@Controller
public class QuitController {
    @Autowired
    @Qualifier("RainService")
    private RainService rainservice;
    // 如果在目录下输入为空，则跳转到指定链接
    @RequestMapping(value="/quit/")
    public ModelAndView index2(ModelAndView mv){
        mv.setViewName("quit/list");
        return mv;
    }
    // 如果在目录下输入任何不存在的参数，则跳转到list
    @RequestMapping(value="/quit/{formName}")
    public String index2(@PathVariable String formName){
        String blank = "/quit/list";
        return blank;
    }
    @RequestMapping(value="/quit/list",method=RequestMethod.GET)
    public String index(Model model, String content,  @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int size){
        List<Quit> quit_list = rainservice.get_QuitList(page,size);
//        List<Quit> list = rainservice.findAllQuit(page,size);
        PageInfo pageInfo=new PageInfo(quit_list);
        model.addAttribute("pageInfo",pageInfo);
        if (content!=null){
            quit_list = rainservice.get_QuitLikeList(content);
        }
        model.addAttribute("list",quit_list);
//        model.addAttribute("list",list);
        return "quit/list";
    }


//    @RequestMapping(value="/quit/list/get",method=RequestMethod.GET)
//    public String index(Model model,   @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int size){
//        List<Quit> quit_list = rainservice.findAllQuit(page,size);
//        PageInfo pageInfo=new PageInfo(quit_list);
//        model.addAttribute("pageInfo",pageInfo);
//        model.addAttribute("list",quit_list);
//        return "quit/list";
//    }


    @RequestMapping(value="/quit/add",method=RequestMethod.GET)
    public String add(Model model,Integer id){
        if(id!=null){
            Quit quit = rainservice.get_QuitInfo(id);
            model.addAttribute("quit",quit);
        }
        List<Type> type_list = rainservice.findAllType();
        List<Dept> dept_list = rainservice.findAllDept();
        List<Job> job_list = rainservice.findAllJob();
        model.addAttribute("type_list", type_list);
        model.addAttribute("job_list", job_list);
        model.addAttribute("dept_list",dept_list);
        return "/quit/add";
    }
    @RequestMapping(value="/quit/add",method=RequestMethod.POST)
    public ModelAndView add(ModelAndView mv,@ModelAttribute Quit quit ,Integer id){
//			System.out.println(id);
        if(id!=null){
            rainservice.update_QuitInfo(quit);
        }else{
            rainservice.insert_QuitInfo(quit);
        }
        mv.setViewName("redirect:/quit/list");
        return mv;
    }
    @RequestMapping(value="/quit/delete",method=RequestMethod.GET)
    public void delete(Integer id){
        if(id!=null){
            rainservice.delete_QuitInfo(id);
        }
    }
}
