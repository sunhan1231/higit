package com.qiliang.web.mapper;



import com.qiliang.web.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface YJFXMapper {
    @Select("select * from `ql`.`bzhlist` where status='1'")
    List<Bzhlist> bzhlist();
}
