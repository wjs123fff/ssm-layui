package com.rain.dao.provider;

import static com.rain.util.common.Constants.QUITTABLE;

import org.apache.ibatis.jdbc.SQL;

import com.rain.domain.Quit;

public class QuitProvider {
    // 动态插入
    public String insert_Quit(Quit quit){

        return new SQL(){
            {
                INSERT_INTO(QUITTABLE);
                if(quit.getName() != null ){
                    VALUES("name", "#{name}");
                }
                if(quit.getCard_id()!=null){
                    VALUES("card_id","#{card_id}");
                }
                if(quit.getAddress()!=null){
                    VALUES("address","#{address}");
                }
                if(quit.getPost_code()!=null){
                    VALUES("post_code","#{post_code}");
                }
                if(quit.getTel()!=null){
                    VALUES("tel","#{tel}");
                }
                if(quit.getPhone()!=null){
                    VALUES("phone","#{phone}");
                }
                if(quit.getQq_num()!=null){
                    VALUES("qq_nul","#{qq_num}");
                }
                if(quit.getEmail()!=null){
                    VALUES("email","#{email}");
                }
                if(quit.getSex()!=null){
                    VALUES("sex","#{sex}");
                }
                if(quit.getParty()!=null){
                    VALUES("party","#{party}");
                }
                if(quit.getBirthday()!=null){
                    VALUES("birthday","#{birthday}");
                }
                if(quit.getRace()!=null){
                    VALUES("race","#{race}");
                }
                if(quit.getEducation()!=null){
                    VALUES("education","#{education}");
                }
                if(quit.getSpeciality()!=null){
                    VALUES("speciality","#{speciality}");
                }
                if(quit.getHobby()!=null){
                    VALUES("hobby","#{hobby}");
                }
                if(quit.getRemark()!=null){
                    VALUES("remark","#{remark}");
                }
                if(quit.getCreate_date()!=null){
                    VALUES("create_date","#{create_date}");
                }
                if(quit.getDept_id()!=null){
                    VALUES("dept_id","#{dept_id}");
                }
                if(quit.getJob_id()!=null){
                    VALUES("job_id","#{job_id}");
                }
                if(quit.getType_id()!= null){
                    VALUES("type_id","#{type_id}");
                }
//                if(job.getT_name() != null){
//                    VALUES("t_name", "#{t_name}");
//                }
            }
        }.toString();
    }
    // 动态更新
    public String update_Quit(Quit quit){

        return new SQL(){
            {
                UPDATE(QUITTABLE);
                if(quit.getName() != null ){
                    SET("name = #{name}");
                }
                if(quit.getCard_id()!=null){
                    SET("card_id = #{card_id}");
                }
                if(quit.getAddress()!=null){
                    SET("address = #{address}");
                }
                if(quit.getPost_code()!=null){
                    SET("post_code = #{post_code}");
                }
                if(quit.getTel()!=null){
                    SET("tel = #{tel}");
                }
                if(quit.getPhone()!=null){
                    SET("phone = #{phone}");
                }
                if(quit.getQq_num()!=null){
                    SET("qq_nul = #{qq_num}");
                }
                if(quit.getEmail()!=null){
                    SET("email = #{email}");
                }
                if(quit.getSex()!=null){
                    SET("sex = #{sex}");
                }
                if(quit.getParty()!=null){
                    SET("party = #{party}");
                }
                if(quit.getBirthday()!=null){
                    SET("birthday = #{birthday}");
                }
                if(quit.getRace()!=null){
                    SET("race = #{race}");
                }
                if(quit.getEducation()!=null){
                    SET("education = #{education}");
                }
                if(quit.getSpeciality()!=null){
                    SET("speciality = #{speciality}");
                }
                if(quit.getHobby()!=null){
                    SET("hobby = #{hobby}");
                }
                if(quit.getRemark()!=null){
                    SET("remark = #{remark}");
                }
                if(quit.getCreate_date()!=null){
                    SET("create_date = #{create_date}");
                }
                if(quit.getDept_id()!=null){
                    SET("dept_id = #{dept_id}");
                }
                if(quit.getJob_id()!=null){
                    SET("job_id = #{job_id}");
                }

                if(quit.getType_id()!=null){
                    SET("type_id = #{type_id}");
                }
                WHERE(" quit_id = #{id} ");
            }
        }.toString();
    }
}
