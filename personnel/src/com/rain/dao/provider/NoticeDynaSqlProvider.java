package com.rain.dao.provider;

import static com.rain.util.common.Constants.NOTICETABLE;

import org.apache.ibatis.jdbc.SQL;

import com.rain.domain.Notice;

public class NoticeDynaSqlProvider {
			// 动态插入
			public String insert_Notice(Notice notice){
				
				return new SQL(){
					{
						INSERT_INTO(NOTICETABLE);
						if(notice.getTitle() != null ){
							VALUES("title", "#{title}");
						}
						if(notice.getUser_id()!=null){
							VALUES("user_id","#{user_id}");
						}
						if(notice.getContent()!=null){
							VALUES("content","#{content}");
						}
						if(notice.getCreate_date()!=null){
							VALUES("create_date","#{create_date}");
						}
					
						
					}
				}.toString();
			}	
			// 动态更新
			public String update_Notice(Notice notice){
				
				return new SQL(){
					{
						UPDATE(NOTICETABLE);
						if(notice.getTitle() != null ){
							SET("title = #{title}");
						}
						if(notice.getUser_id()!=null){
							SET("user_id = #{user_id}");
						}
						if(notice.getContent()!=null){
							SET("content = #{content}");
						}
						if(notice.getCreate_date()!=null){
							SET("create_date = #{create_date}");
						}
				
						
						
						WHERE(" id = #{id} ");
					}
				}.toString();
			}
}
