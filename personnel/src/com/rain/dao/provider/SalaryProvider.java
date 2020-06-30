package com.rain.dao.provider;

import static com.rain.util.common.Constants.SALARYTABLE;

import org.apache.ibatis.jdbc.SQL;

import com.rain.domain.Salary;

public class SalaryProvider {
    // 动态插入
    public String insert_Salary(Salary salary){

        return new SQL(){
            {
                INSERT_INTO(SALARYTABLE);
                if(salary.getName() != null ){
                    VALUES("name", "#{name}");
                }
                if(salary.getCard_id()!=null){
                    VALUES("card_id","#{card_id}");
                }
                if(salary.getAddress()!=null){
                    VALUES("address","#{address}");
                }
                if(salary.getEducation()!=null){
                    VALUES("education","#{education}");
                }
                if(salary.getEmail()!=null){
                    VALUES("email","#{email}");
                }

                if(salary.getPhone()!=null){
                    VALUES("phone","#{phone}");
                }
                if(salary.getDept_id()!=null){
                    VALUES("dept_id","#{dept_id}");
                }
                if(salary.getJob_id()!=null){
                    VALUES("job_id","#{job_id}");
                }
            }
        }.toString();
    }
    // 动态更新
    public String update_Salary(Salary salary){

        return new SQL(){
            {
                UPDATE(SALARYTABLE);
                if(salary.getName() != null ){
                    SET("name = #{name}");
                }
                if(salary.getCard_id()!=null){
                    SET("card_id = #{card_id}");
                }
                if(salary.getAddress()!=null){
                    SET("address = #{address}");
                }
                if(salary.getEducation()!=null){
                    SET(" education = #{ education}");
                }
                if(salary.getEmail()!=null){
                    SET("email = #{email}");
                }

                if(salary.getPhone()!=null){
                    SET("phone  = #{phone }");
                }
                if(salary.getDept_id()!=null){
                    SET("dept_id = #{dept_id}");
                }
                if(salary.getJob_id()!=null){
                    SET("job_id = #{job_id}");
                }

                WHERE(" s_id = #{id} ");
            }
        }.toString();
    }
}
