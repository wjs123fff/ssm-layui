package com.rain.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.rain.dao.*;
import com.rain.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rain.service.RainService;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("RainService")
public class RainServiceImpl implements RainService {

	@Autowired
	private DeptDao deptDao;
	@Autowired
	private JobDao jobDao;
	@Autowired
	private EmployeeDao employeedao;
	@Autowired
	private NoticeDao noticedao;
	@Autowired
	private DocumentDao documentdao;
	@Autowired
	private UserDao userdao;
	@Autowired
	private QuitDao quitdao;
	@Autowired
	private TypeDao typedao;
	@Autowired
	private SalaryDao salarydao;
	/**
	 * 部门信息的管理
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Dept> findAllDept() {
		return deptDao.selectAllDept();
	}

	@Override
	public List<Dept> getAllDept(Integer page,Integer size) {
		PageHelper.startPage(page,size);
		return deptDao.getAllDept();
	}

//	@Override
//	public List<Dept> getAllDept(Integer page,Integer size){
//		PageHelper.startPage(page,size);
//		return deptDao.selectAllDept();
//	}

	@Override
	public void addDept(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.save(dept);
	}

	@Override
	public Dept get_Info(Integer id) {
		// TODO Auto-generated method stub
		Dept dept = deptDao.get_Info(id);
		return dept;
	}

	@Override
	public void update_DeptInfo(Dept dept) {
		// TODO Auto-generated method stub
		deptDao.update_DeptInfo(dept);
	}

	@Override
	public void delete_Info(Integer id) {
		// TODO Auto-generated method stub
		deptDao.delete_Info(id);
	}

	@Override
	public List<Dept> findAllDept(String content) {
		// TODO Auto-generated method stub
		System.out.println(content);
		return deptDao.selectLikeAllDept(content);
	}

//	@Override
//	public List<Dept> findAllDeptID(Integer id) {
//		// TODO Auto-generated method stub
//		System.out.println(id);
//		return deptDao.selectLikeAllDeptID(id);
//	}

//	@Override
//	public Dept count(Integer id) {
//		// TODO Auto-generated method stub
//		Dept dept = deptDao.count(id);
//		return dept;
//	}


	/**
	 * 职位管理的操作
	 */
	@Override
	public List<Job> findAllJob() {
		// TODO Auto-generated method stub
		return jobDao.get_List();
	}

	@Override
	public List<Job> getAllJob(Integer page,Integer size) {
		PageHelper.startPage(page,size);
		return jobDao.getAllJob();
	}

	@Override
	public List<Job> findAllJob(String content) {
		// TODO Auto-generated method stub
		return jobDao.get_LikeList(content);
	}

	@Override
	public Job get_JobInfo(Integer id) {
		// TODO Auto-generated method stub
		return jobDao.get_Info(id);
	}

	@Override
	public void update_JobInfo(Job job) {
		// TODO Auto-generated method stub
		jobDao.update_JobInfo(job);
	}

	@Override
	public void insert_JobInfo(Job job) {
		// TODO Auto-generated method stub
		jobDao.insert_Info(job);
	}

	@Override
	public void delete_JobInfo(Integer id) {
		// TODO Auto-generated method stub
		jobDao.delete_Info(id);
	}

	/**
	 * 员工信息的管理
	 */
	@Override
	public List<Employee> get_EmployeeList(Integer page,Integer size) {
		// TODO Auto-generated method stub
		/**
		 * 将部门，职位id中的信息提取出来
		 */

		PageHelper.startPage(page,size);
		List<Employee> list = employeedao.get_List();
		int size1 = list.size();
		List<Employee> list2 = new ArrayList<>();
		for (int i = 0; i < size1; i++) {
			Employee data = list.get(i);
			Dept dept = deptDao.get_Info(data.getDept_id());
			data.setDept(dept);
			Job job = jobDao.get_Info(data.getJob_id());
			data.setJob(job);
			list2.add(i, data);
		}
		return list2;
	}

	@Override
	public List<Employee> get_EmployeeLikeList(String content) {
		// TODO Auto-generated method stub
		/**
		 * 将部门，职位id中的信息提取出来
		 */
		List<Employee> list = employeedao.get_LikeList(content);
		int size = list.size();
		List<Employee> list2 = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			Employee data = list.get(i);
			Dept dept = deptDao.get_Info(data.getDept_id());
			data.setDept(dept);
			Job job = jobDao.get_Info(data.getJob_id());
			data.setJob(job);
			list2.add(i, data);
		}
		return list2;
	}

	@Override
	public Employee get_EmployeeInfo(Integer id) {
		// TODO Auto-generated method stub
		Employee data = employeedao.get_Info(id);
		Dept dept = deptDao.get_Info(data.getDept_id());
		data.setDept(dept);
		Job job = jobDao.get_Info(data.getJob_id());
		data.setJob(job);
		return data;
	}

	@Override
	public void update_EmployeeInfo(Employee data) {
		// TODO Auto-generated method stub
		employeedao.update_Info(data);
	}

	@Override
	public void insert_EmployeeInfo(Employee data) {
		// TODO Auto-generated method stub
		/**
		 * 将职位id和部门id提取，或者不管，因为直接存到数据库了，不管
		 */
		Date date = new Date();
		String year = String.format("%tY", date);
		String month = String.format("%tB", date);
		String day = String.format("%te", date);
		data.setCreate_date(year + month + day);
		employeedao.insert_Info(data);
	}


	@Override
	public void delete_EmployeeInfo(Integer id) {
		// TODO Auto-generated method stub
		employeedao.delete_EmployeeInfo(id);
	}

	@Override
	public List<Employee> findAllEmployee(Integer page, Integer size) {
		PageHelper.startPage(page,size);
		return employeedao.selectAllEmployee();
	}

//	public List<Employee> findAllEmployee(String content) {
//		// TODO Auto-generated method stub
//		System.out.println(content);
//		return employeedao.selectLikeAllEmployee(content);
//	}

	/**
	 * 公告管理
	 */
	@Override
	public List<Notice> get_NoticeList(Integer page,Integer size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,size);
		return noticedao.get_List();
	}

	@Override
	public List<Notice> get_NoticeLikeList(String content) {
		// TODO Auto-generated method stub
		return noticedao.get_LikeList(content);
	}

	@Override
	public Notice get_NoticeInfo(Integer id) {
		// TODO Auto-generated method stub
		return noticedao.get_Info(id);
	}

	@Override
	public void update_NoticeInfo(Notice notice) {
		// TODO Auto-generated method stub
		noticedao.update_NoticeInfo(notice);
	}

	@Override
	public void insert_NoticeInfo(Notice notice) {
		// TODO Auto-generated method stub
		Date date = new Date();
		String year = String.format("%tY", date);
		String month = String.format("%tB", date);
		String day = String.format("%te", date);
		notice.setCreate_date(year+month+day);
		noticedao.insert_Info(notice);
	}

	@Override
	public void delete_NoticeInfo(Integer id) {
		// TODO Auto-generated method stub
		noticedao.delete_Info(id);
	}

	/**
	 * 文档管理
	 */
	@Override
	public List<Document> get_DocumentList(Integer page,Integer size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,size);
		return documentdao.get_List();
	}

	@Override
	public List<Document> get_DocumentLikeList(String content) {
		// TODO Auto-generated method stub
		return documentdao.get_LikeList(content);
	}

	@Override
	public Document get_DocumentInfo(Integer id) {
		// TODO Auto-generated method stub
		return documentdao.get_Info(id);
	}

	@Override
	public void update_DocumentInfo(Document document) {
		// TODO Auto-generated method stub
		documentdao.update_DocumentInfo(document);
	}

	@Override
	public void insert_DocumentInfo(Document document) {
		// TODO Auto-generated method stub
		Date date = new Date();
		String year = String.format("%tY", date);
		String month = String.format("%tB", date);
		String day = String.format("%te", date);
		document.setCreate_date(year+month+day);
		documentdao.insert_Info(document);
	}

	@Override
	public void delete_DocumentInfo(Integer id) {
		// TODO Auto-generated method stub
		documentdao.delete_Info(id);
	}




//用户管理
	@Override
	public User login(String loginname, String password) {
		// TODO Auto-generated method stub
		User user = userdao.get_login(loginname, password);
		return user;
	}

	@Override
	public User Count(Integer count) {
		// TODO Auto-generated method stub
		User user = userdao.get_count(count);
		return user;
	}



	@Override
	public List<User> get_UserList(Integer page,Integer size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page,size);
		return userdao.get_List();
	}

	@Override
	public List<User> get_UserLikeList(String content) {
		// TODO Auto-generated method stub
		return userdao.get_LikeList(content);
	}

	@Override
	public User get_UserInfo(Integer id) {
		// TODO Auto-generated method stub
		return userdao.get_Info(id);
	}

	@Override
	public void update_UserInfo(User user) {
		// TODO Auto-generated method stub
		userdao.update_UserInfo(user);
	}

	@Override
	public void insert_UserInfo(User user) {
		// TODO Auto-generated method stub
		Date date = new Date();
		String year = String.format("%tY", date);
		String month = String.format("%tB", date);
		String day = String.format("%te", date);
//		notice.setCreate_date(year+month+day);
		userdao.insert_Info(user);
	}

	@Override
	public void delete_UserInfo(Integer id) {
		// TODO Auto-generated method stub
		userdao.delete_Info(id);
	}


	//离职管理
@Override
public List<Quit> get_QuitList(Integer page,Integer size) {
	// TODO Auto-generated method stub
	/**
	 * 将部门，职位id中的信息提取出来
	 */
	PageHelper.startPage(page,size);
	List<Quit> list = quitdao.get_List();
	int size1 = list.size();
	List<Quit> list2 = new ArrayList<>();
	for (int i = 0; i < size1; i++) {
		Quit data = list.get(i);

		Type type = typedao.get_Info(data.getType_id());
		data.setType(type);
		Dept dept = deptDao.get_Info(data.getDept_id());
		data.setDept(dept);
		Job job = jobDao.get_Info(data.getJob_id());
		data.setJob(job);
		list2.add(i, data);
	}
	return list2;
}

	@Override
	public List<Quit> get_QuitLikeList(String content) {
		// TODO Auto-generated method stub
		/**
		 * 将部门，职位id中的信息提取出来
		 */
		List<Quit> list = quitdao.get_LikeList(content);
		int size = list.size();
		List<Quit> list2 = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			Quit data = list.get(i);

			Type type = typedao.get_Info(data.getType_id());
			data.setType(type);
			Dept dept = deptDao.get_Info(data.getDept_id());
			data.setDept(dept);
			Job job = jobDao.get_Info(data.getJob_id());
			data.setJob(job);
			list2.add(i, data);
		}
		return list2;
	}

	@Override
	public Quit get_QuitInfo(Integer id) {
		// TODO Auto-generated method stub
		Quit data = quitdao.get_Info(id);

//		Type type = typedao.get_Info(data.getType_id());
//		data.setType(type);
		Type type = typedao.get_Info(data.getType_id());
		data.setType(type);
	Dept dept = deptDao.get_Info(data.getDept_id());
		data.setDept(dept);
	Job job = jobDao.get_Info(data.getJob_id());
		data.setJob(job);
		return data;
}

	@Override
	public void update_QuitInfo(Quit data) {
		// TODO Auto-generated method stub
		quitdao.update_QuitInfo(data);
	}

	@Override
	public void insert_QuitInfo(Quit data) {
		// TODO Auto-generated method stub
		/**
		 * 将职位id和部门id提取，或者不管，因为直接存到数据库了，不管
		 */
		Date date = new Date();
		String year = String.format("%tY", date);
		String month = String.format("%tB", date);
		String day = String.format("%te", date);
		data.setCreate_date(year + month + day);
		quitdao.insert_Info(data);
	}


	@Override
	public void delete_QuitInfo(Integer id) {
		// TODO Auto-generated method stub
		quitdao.delete_QuitInfo(id);
	}

	@Override
	public List<Quit> findAllQuit(Integer  page,Integer size) {
		PageHelper.startPage(page,size);
		return quitdao.selectAllQuit();
	}

	public List<Quit> findAllQuit(String content) {
		// TODO Auto-generated method stub
		System.out.println(content);
		return quitdao.selectLikeAllQuit(content);
	}



	//离职类型
	@Override
	public List<Type> findAllType() {
		return typedao.selectAllType();
	}

	@Override
	public void addType(Type type) {
		// TODO Auto-generated method stub
		typedao.save(type);
	}

    @Override
    public Type get_TypeInfo(Integer id) {
        // TODO Auto-generated method stub
        Type type = typedao.get_Info(id);
        return type;
    }

    @Override
    public void update_Info(Type type) {
        // TODO Auto-generated method stub
        typedao.update_Info(type);
    }

    @Override
    public void delete_TypeInfo(Integer id) {
        // TODO Auto-generated method stub
        typedao.delete_Info(id);
    }

    @Override
    public List<Type> findAllType(String content) {
        // TODO Auto-generated method stub
        System.out.println(content);
        return typedao.selectLikeAllType(content);
    }

//薪资管理
@Override
public List<Salary> get_SalaryList(Integer page,Integer size) {
	// TODO Auto-generated method stub
	/**
	 * 将部门，职位id中的信息提取出来
	 */

		PageHelper.startPage(page,size);
	List<Salary> list = salarydao.get_List();
	int size1 = list.size();
	List<Salary> list2 = new ArrayList<>();
	for (int i = 0; i < size1; i++) {
		Salary data = list.get(i);
		Dept dept = deptDao.get_Info(data.getDept_id());
		data.setDept(dept);
		Job job = jobDao.get_Info(data.getJob_id());
		data.setJob(job);
		list2.add(i, data);
	}
	return list2;
}

	@Override
	public List<Salary> get_SalaryLikeList(String content) {
		// TODO Auto-generated method stub
		/**
		 * 将部门，职位id中的信息提取出来
		 */
		List<Salary> list = salarydao.get_LikeList(content);
		int size = list.size();
		List<Salary> list2 = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			Salary data = list.get(i);
			Dept dept = deptDao.get_Info(data.getDept_id());
			data.setDept(dept);
			Job job = jobDao.get_Info(data.getJob_id());
			data.setJob(job);
			list2.add(i, data);
		}
		return list2;
	}

	@Override
	public Salary get_SalaryInfo(Integer id) {
		// TODO Auto-generated method stub
		Salary data = salarydao.get_Info(id);
		Dept dept = deptDao.get_Info(data.getDept_id());
		data.setDept(dept);
		Job job = jobDao.get_Info(data.getJob_id());
		data.setJob(job);
		return data;
	}

	@Override
	public void update_SalaryInfo(Salary data) {
		// TODO Auto-generated method stub
		salarydao.update_Info(data);
	}

	@Override
	public void insert_SalaryInfo(Salary data) {
		// TODO Auto-generated method stub
		/**
		 * 将职位id和部门id提取，或者不管，因为直接存到数据库了，不管
		 */
		salarydao.insert_Info(data);
	}


	@Override
	public void delete_SalaryInfo(Integer id) {
		// TODO Auto-generated method stub
		salarydao.delete_SalaryInfo(id);
	}

	@Override
	public List<Salary> findAllSalary(Integer page, Integer size) {
		PageHelper.startPage(page,size);
		return salarydao.selectAllSalary();
	}

	public List<Salary> findAllSalary(String content) {
		// TODO Auto-generated method stub
		System.out.println(content);
		return salarydao.selectLikeAllSalary(content);
	}

}