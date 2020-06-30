package com.rain.dao.provider;

import static com.rain.util.common.Constants.USERTABLE;

import org.apache.ibatis.jdbc.SQL;

import com.rain.domain.User;

public class UserDynaSqlProvider {
			// 动态插入
			public String insert_User(User user){
				
				return new SQL(){
					{
						INSERT_INTO(USERTABLE);
						if(user.getLoginname() != null ){
							VALUES("loginname", "#{loginname}");
						}
						if(user.getPassword()!=null){
							VALUES("password","#{password}");
						}
						if(user.getUsername()!=null){
							VALUES("username","#{username}");
						}
//						if(job.getCreate_date()!=null){
//							VALUES("create_date","#{create_date}");
//						}
					
						
					}
				}.toString();
			}	
			// 动态更新
			public String update_User(User user){
				
				return new SQL(){
					{
						UPDATE(USERTABLE);
						if(user.getLoginname() != null ){
							SET("loginname = #{loginname}");
						}
						if(user.getPassword()!=null){
							SET("password = #{password}");
						}
						if(user.getUsername()!=null){
							SET("username = #{username}");
						}
						WHERE(" id = #{id}");
					}
				}.toString();
			}
}
