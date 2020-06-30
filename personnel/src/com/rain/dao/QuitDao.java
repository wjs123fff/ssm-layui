package com.rain.dao;

import static com.rain.util.common.Constants.QUITTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.rain.dao.provider.QuitProvider;
import com.rain.domain.Quit;

public interface QuitDao {
    /**
     *
     * @return
     */
    //查询
    @Select("select * from "+QUITTABLE+" ")
    List<Quit> get_List();
    @Select("select * from "+QUITTABLE+" ")
    List<Quit> selectAllQuit();

    @Select("select * from "+QUITTABLE+"  where name like CONCAT('%',#{content},'%')")
    List<Quit> get_LikeList(String content);
    List<Quit> selectLikeAllQuit(String content);


    @SelectProvider(type=QuitProvider.class,method="insert_Quit")
    void insert_Info(Quit quit);

    @Select("select * from "+QUITTABLE+" where quit_id = #{id}")
    Quit get_Info(Integer id);

    @SelectProvider(type=QuitProvider.class,method="update_Quit")
    void update_QuitInfo(Quit quit);
    // 根据id删除部门
    @Delete(" delete from "+QUITTABLE+" where quit_id = #{id}")
    void delete_QuitInfo(Integer id);
}
