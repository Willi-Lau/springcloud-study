package com.lwy.cloudalibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import javax.annotation.Resource;

@Resource
public interface StorageDao {

    //扣减库存
    @Update("  UPDATE" +
            "            t_storage" +
            "        SET" +
            "            used = used + #{count},residue = residue - #{count}" +
            "        WHERE" +
            "            product_id = #{productId}")
    void decrease(@Param("productId") Integer productId, @Param("count") Integer count);
}
