package com.rain.dao;

import static com.rain.util.common.Constants.DEPTTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import com.rain.dao.provider.DeptDynaSqlProvider;
import com.rain.domain.Dept;
public interface DeptDao {
	//查询
	@Select("select * from "+DEPTTABLE+" ")
	List<Dept> selectAllDept();
	@Select("select * from "+DEPTTABLE+" ")
	List<Dept> getAllDept();
	@Select("select * from "+DEPTTABLE+" where name  like CONCAT('%',#{content},'%') " )
//	@Select("select * from "+DEPTTABLE+" where name  like CONCAT('%',#{content},'%') " )
	List<Dept> selectLikeAllDept(String content);

//	@Select("select * from "+DEPTTABLE+" where dept_id  like CONCAT('%',#{id},'%') ")
//	List<Dept> selectLikeAllDeptID(Integer id);


//	@Select("select count(*) from "+DEPTTABLE+" ")
//	Dept count(Integer dept_id);
	
	
	@SelectProvider(type=DeptDynaSqlProvider.class,method="insert_Dept")
	void save(Dept dept);
	
	@Select("select * from "+DEPTTABLE+" where dept_id = #{id}")
	Dept get_Info(Integer id);

	@SelectProvider(type=DeptDynaSqlProvider.class,method="update_Dept")
	void update_DeptInfo(Dept dept);
	// 根据id删除部门
	@Delete(" delete from "+DEPTTABLE+" where dept_id = #{id} ")
	void delete_Info(Integer id);



}
