package com.rain.dao;

import static com.rain.util.common.Constants.TYPETABLE;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import com.rain.dao.provider.TypeProvider;
import com.rain.domain.Type;
public interface TypeDao {
    //查询
    @Select("select * from "+TYPETABLE+" ")
//    List<Type> get_List();
    List<Type> selectAllType();
    @Select("select * from "+TYPETABLE+" where name like CONCAT('%',#{content},'%')")
    List<Type> selectLikeAllType(String content);
//    List<Type> get_LikeList(String content);

    @SelectProvider(type=TypeProvider.class,method="insert_Type")
    void save(Type type);

    @Select("select * from "+TYPETABLE+" where type_id = #{type_id}")
    Type get_Info(Integer t_id);

    @SelectProvider(type=TypeProvider.class,method="update_Type")
    void update_Info(Type type);
    // 根据id删除部门
    @Delete(" delete from "+TYPETABLE+" where type_id = #{type_id} ")
    void delete_Info(Integer t_id);



}
