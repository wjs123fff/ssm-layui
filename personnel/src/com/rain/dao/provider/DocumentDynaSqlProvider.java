package com.rain.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import static com.rain.util.common.Constants.DOCUMENTTABLE;

import com.rain.domain.Document;

public class DocumentDynaSqlProvider {
	
	// 动态插入
		public String insert_Document(Document document){
			
			return new SQL(){
				{
					INSERT_INTO(DOCUMENTTABLE);
					if(document.getTitle() != null ){
						VALUES("title", "#{title}");
					}
					if(document.getRemark() != null ){
						VALUES("remark", "#{remark}");
					}
					if(document.getCreate_date() != null ){
						VALUES("create_date", "#{create_date}");
					}
					if(document.getUser_id() != null ){
						VALUES("user_id", "#{user_id}");
					}
					if(document.getFilename() != null ){
						VALUES("filename", "#{filename}");
					}
				}
			}.toString();
		}	
		// 动态更新
		public String update_Document(Document document){
			
			return new SQL(){
				{
					UPDATE(DOCUMENTTABLE);
					if(document.getTitle() != null){
						SET(" title = #{title} ");
					}
				
					if(document.getRemark() != null){
						SET(" remark = #{remark} ");
					}
					WHERE(" id = #{id} ");
				}
			}.toString();
		}
}
