package com.rain.dao;

import static com.rain.util.common.Constants.SALARYTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.rain.dao.provider.SalaryProvider;
import com.rain.domain.Salary;

public interface SalaryDao {
    /**
     *
     * @return
     */
    //查询
    @Select("select * from "+SALARYTABLE+" ")
    List<Salary> get_List();
    @Select("select * from "+SALARYTABLE+" ")
    List<Salary> selectAllSalary();

    @Select("select * from "+SALARYTABLE+"  where name like CONCAT('%',#{content},'%')")
    List<Salary> get_LikeList(String content);
    List<Salary> selectLikeAllSalary(String content);


    @SelectProvider(type=SalaryProvider.class,method="insert_Salary")
    void insert_Info(Salary salary);

    @Select("select * from "+SALARYTABLE+" where s_id = #{id}")
    Salary get_Info(Integer id);

    @SelectProvider(type=SalaryProvider.class,method="update_Salary")
    void update_Info(Salary salary);
    // 根据id删除部门
    @Delete(" delete from "+SALARYTABLE+" where s_id = #{id}")
    void delete_SalaryInfo(Integer id);
}
