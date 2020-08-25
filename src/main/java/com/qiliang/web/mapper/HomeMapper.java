package com.qiliang.web.mapper;



import com.qiliang.web.entity.Learnlist;
import com.qiliang.web.entity.Mapdate;
import com.qiliang.web.entity.Messagelist;
import com.qiliang.web.entity.Supportlist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HomeMapper {

@Select("select * from `ql`.`learnlist`")
    List<Learnlist> leanlis();
    @Select("select * from `ql`.`messagelist`")
    List<Messagelist> messagelist();
    @Select("select * from `ql`.`supportlist`")
    List<Supportlist> supportlist();

    @Select("select * from `ql`.`mapdate`")
    List<Mapdate> maplist();
}
