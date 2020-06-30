package com.rain.service;
import java.util.List;

import com.rain.domain.*;

public interface RainService {
	/**
	 * 部门信息的service
	 * @param content
	 * @return
	 */
	List<Dept> findAllDept(String content);
//	List<Dept> findAllDeptID(Integer id);
	void addDept(Dept dept);

	void update_DeptInfo(Dept dept);

	void delete_Info(Integer id);
	Dept get_Info(Integer id);
	List<Dept> findAllDept();
	List<Dept> getAllDept(Integer page,Integer size);
//	Dept count(Integer id);

	/**
	 * 职位信息的service
	 * @return
	 */

	List<Job> findAllJob();
	List<Job> getAllJob(Integer page,Integer size);
	List<Job> findAllJob(String content);

	Job get_JobInfo(Integer id);

	void update_JobInfo(Job job);

	void insert_JobInfo(Job job);

	void delete_JobInfo(Integer id);
	/**
	 * 员工信息的service
	 */
//	List<Employee> get_EmployeeList();

	List<Employee> get_EmployeeList(Integer page,Integer size);
	List<Employee> get_EmployeeLikeList(String content);
	Employee get_EmployeeInfo(Integer id);
	void update_EmployeeInfo(Employee data);
	void insert_EmployeeInfo(Employee data);
	void delete_EmployeeInfo(Integer id);
	List<Employee> findAllEmployee(Integer page, Integer size);



//	List<Notice> get_NoticeList();

	List<Notice> get_NoticeList(Integer page,Integer size);

	List<Notice> get_NoticeLikeList(String content);

	Notice get_NoticeInfo(Integer id);

	void update_NoticeInfo(Notice notice);

	void insert_NoticeInfo(Notice notice);

	void delete_NoticeInfo(Integer id);




//	List<Document> get_DocumentList();

	List<Document> get_DocumentList(Integer page,Integer size);

	List<Document> get_DocumentLikeList(String content);

	Document get_DocumentInfo(Integer documentid);

	void update_DocumentInfo(Document document);

	void insert_DocumentInfo(Document document);

	void delete_DocumentInfo(Integer documentid);




	User login(String loginname, String password);

//	List<User> get_UserList();
List<User> get_UserList(Integer page,Integer size);

	List<User> get_UserLikeList(String content);

	User get_UserInfo(Integer id);

	void update_UserInfo(User user);

	void insert_UserInfo(User user);

	void delete_UserInfo(Integer id);
	User Count(Integer count);




//	Dept get_DeptInfo(Integer dept_id);

	//离职管理
//    List<Quit> get_QuitList();

	List<Quit> get_QuitList(Integer page,Integer size);
    List<Quit> get_QuitLikeList(String content);
    Quit get_QuitInfo(Integer id);
    void update_QuitInfo(Quit data);
    void insert_QuitInfo(Quit data);
    void delete_QuitInfo(Integer id);
	List<Quit> findAllQuit(Integer  page,Integer size);

  //离职类型
  List<Type> findAllType(String content);

    void addType(Type type);

    void update_Info(Type type);

    void delete_TypeInfo(Integer id);

    List<Type> findAllType();
    Type get_TypeInfo(Integer id);

//	List<Type> get_TypeList();
//
//	List<Type> get_TypeLikeList(String content);

	//薪资类型管理

	List<Salary> get_SalaryList(Integer page,Integer size);
	List<Salary> get_SalaryLikeList(String content);
	Salary get_SalaryInfo(Integer id);
	void update_SalaryInfo(Salary data);
	void insert_SalaryInfo(Salary data);
	void delete_SalaryInfo(Integer id);
	List<Salary> findAllSalary(Integer page, Integer size);
}
