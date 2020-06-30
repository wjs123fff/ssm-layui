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
import com.rain.domain.Employee;
import com.rain.domain.Job;
import com.rain.service.RainService;

@Controller
public class EmployeeController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	// 如果在目录下输入为空，则跳转到指定链接
		@RequestMapping(value="/employee/")
		 public ModelAndView index2(ModelAndView mv){
			mv.setViewName("employee/list");
			return mv;
		}
		// 如果在目录下输入任何不存在的参数，则跳转到list
		@RequestMapping(value="/employee/{formName}")
		 public String index2(@PathVariable String formName){
			String blank = "/employee/list";
			return blank;
		}
		@RequestMapping(value="/employee/list",method=RequestMethod.GET)
	public String index(Model model, String content, @RequestParam(name="page",required = true,defaultValue = "1") int page,  @RequestParam(name="size",required = true,defaultValue = "5")int size){
		List<Employee> emp_list = rainservice.get_EmployeeList(page,size);
			PageInfo pageInfo=new PageInfo(emp_list);
         	model.addAttribute("pageInfo",pageInfo);
		if (content!=null){
			emp_list = rainservice.get_EmployeeLikeList(content);
		}
		model.addAttribute("list",emp_list);
		return "employee/list";
	}

//	@RequestMapping(value="/employee/list/get",method=RequestMethod.GET)
//	public String index(Model model, @RequestParam(name="page",required = true,defaultValue = "1") int page,  @RequestParam(name="size",required = true,defaultValue = "5")int size){
//		List<Employee> emp_list = rainservice.findAllEmployee(page,size);
//		PageInfo pageInfo=new PageInfo(emp_list);
//		model.addAttribute("pageInfo",pageInfo);
////			model.addAttribute("list",list);
//		model.addAttribute("list",emp_list);
//		return "employee/list";
//	}




	@RequestMapping(value="/employee/add",method=RequestMethod.GET)
	public String add(Model model,Integer id){
		if(id!=null){
			Employee employee = rainservice.get_EmployeeInfo(id);
			model.addAttribute("emp",employee);
		}
		List<Dept> dept_list = rainservice.findAllDept();
		List<Job> job_list = rainservice.findAllJob();
		model.addAttribute("job_list", job_list);
		model.addAttribute("dept_list",dept_list);
		return "/employee/add";
	}

		@RequestMapping(value="/employee/add",method=RequestMethod.POST)
		 public ModelAndView add(ModelAndView mv,@ModelAttribute Employee employee ,Integer id){
//			System.out.println(id);
			if(id!=null){
				rainservice.update_EmployeeInfo(employee);
			}else{
				rainservice.insert_EmployeeInfo(employee);
			}
			mv.setViewName("redirect:/employee/list");
			return mv;
		}
		@RequestMapping(value="/employee/delete",method=RequestMethod.GET)
		 public void delete(Integer id){
//			System.out.println(id);
			if(id!=null){
				rainservice.delete_EmployeeInfo(id);
			}
		}
}
