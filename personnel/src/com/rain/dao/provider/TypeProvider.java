package com.rain.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import static com.rain.util.common.Constants.TYPETABLE;

import com.rain.domain.Type;

public class TypeProvider {

    // 动态插入
    public String insert_Type(Type type){

        return new SQL(){
            {
                INSERT_INTO(TYPETABLE);
                if(type.getName() != null && !type.getName().equals("") ){
                    VALUES("name", "#{name}");
                }
                if(type.getRemark() != null && !type.getRemark().equals("")){
                    VALUES("remark", "#{remark}");
                }

            }
        }.toString();
    }
    // 动态更新
    public String update_Type(Type type){

        return new SQL(){
            {
                UPDATE(TYPETABLE);
                if(type.getName() != null ){
                    SET(" name = #{name} ");
                }

                if(type.getRemark() != null){
                    SET(" remark = #{remark} ");
                }

                WHERE("type_id= #{id} ");
            }
        }.toString();
    }
}
