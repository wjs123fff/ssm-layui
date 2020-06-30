package com.rain.controller;

import java.util.List;

//import com.rain.domain.Type;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.rain.domain.Dept;
import com.rain.service.RainService;

@Controller
public class DeptController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	
	// 如果在目录下输入为空，则跳转到指定链接
	@RequestMapping(value="/dept/")
	 public ModelAndView index2(ModelAndView mv){
		mv.setViewName("dept/list");
		return mv;
	}
	// 如果在目录下输入任何不存在的参数，则跳转到list
	@RequestMapping(value="/dept/{formName}")
	 public String index2(@PathVariable String formName){
//		return formName;
		String blank = "/dept/list";
		return blank;
	}
	//按查询
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	 public String index(Model model, String content, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int size){
//		System.out.println("4234");
		List<Dept> dept_list = rainservice.findAllDept();
		List<Dept> list = rainservice.getAllDept(page, size);
	    PageInfo pageInfo=new PageInfo( list);
		model.addAttribute("pageInfo",pageInfo);
		if (content!=null){
			list = rainservice.findAllDept(content);
		}
		model.addAttribute("list",dept_list);
		model.addAttribute("list",list);

		return "dept/list";
	}



//	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
//	public String index(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int size){
////		System.out.println("4234");
//		List<Dept> dept_list = rainservice.getAllDept(page, size);
////		List<Dept> dept_list = rainservice.getAllDept(page, size);
//		PageInfo pageInfo=new PageInfo(dept_list);
//		model.addAttribute("pageInfo",pageInfo);
//		model.addAttribute("list",dept_list);
//		return "dept/list";
//	}


//	@RequestMapping(value = "/dept/list",method=RequestMethod.GET)
//	public ModelAndView findall(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int size){
//		ModelAndView mv =new ModelAndView();
//		List<Dept> list = rainservice.getAllDept(page, size);
//		PageInfo pageInfo =new PageInfo(list);
//		mv.addObject("pageInfo",pageInfo);
////		mv.setViewName("list",list);
//		mv.setViewName("redirect:/dept/findAll");
//		return mv;
//	}


	@RequestMapping(value="/dept/add",method=RequestMethod.GET)
	 public String add(Model model,Integer id){
		System.out.println(id);
		if(id!=null){
			Dept dept = rainservice.get_Info(id);
			model.addAttribute("dept",dept);
		}
		return "/dept/add";
	}
	//增加
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	 public ModelAndView add(ModelAndView mv,@ModelAttribute Dept dept ,Integer id){
		System.out.println(id);
		if(id!=null){
			rainservice.update_DeptInfo(dept);
		}else{
			rainservice.addDept(dept);
		}
		mv.setViewName("redirect:/dept/list");
		return mv;
	}


	@RequestMapping(value="/dept/delete",method=RequestMethod.GET)
	 public void delete(Integer id){
		System.out.println(id);
		if(id!=null){
			rainservice.delete_Info(id);
		}
	}


}
