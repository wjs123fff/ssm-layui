package com.rain.controller;
//公告管理
import java.util.List;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.rain.domain.Job;
import com.rain.domain.Notice;
import com.rain.service.RainService;

@Controller
public class NoticeController {
	@Autowired
	@Qualifier("RainService")
	private RainService rainservice;
	// 如果在目录下输入为空，则跳转到指定链接
		@RequestMapping(value="/notice/")
		 public ModelAndView index2(ModelAndView mv){
			mv.setViewName("notice/list");
			return mv;
		}
		// 如果在目录下输入任何不存在的参数，则跳转到list
		@RequestMapping(value="/notice/{formName}")
		 public String index2(@PathVariable String formName){
			String blank = "/notice/list";
			return blank;
		}
		@RequestMapping(value="/notice/list",method=RequestMethod.GET)
		 public String index(Model model, String content, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5")int size){
			List<Notice> notice_list = rainservice.get_NoticeList(page,size);
			PageInfo pageInfo=new PageInfo(notice_list);
		    model.addAttribute("pageInfo",pageInfo);
			if (content!=null){
				notice_list = rainservice.get_NoticeLikeList(content);
			}
			model.addAttribute("list",notice_list);
			return "notice/list";
		}
		@RequestMapping(value="/notice/add",method=RequestMethod.GET)
		 public String add(Model model,Integer id){
			if(id!=null){
				Notice notice = rainservice.get_NoticeInfo(id);
				model.addAttribute("notice",notice);
			}
			return "/notice/add";
		}
		@RequestMapping(value="/notice/add",method=RequestMethod.POST) //修改+添加
		 public ModelAndView add(ModelAndView mv,@ModelAttribute Notice notice ,Integer id){
			System.out.println(id);
			if(id!=null){
				rainservice.update_NoticeInfo(notice);
			}else{
				rainservice.insert_NoticeInfo(notice);
			}
			mv.setViewName("redirect:/notice/list");
			return mv;
		}
		@RequestMapping(value="/notice/delete",method=RequestMethod.GET)
		 public void delete(Integer id){
			System.out.println(id);
			if(id!=null){
				rainservice.delete_NoticeInfo(id);
			}
		}
}
