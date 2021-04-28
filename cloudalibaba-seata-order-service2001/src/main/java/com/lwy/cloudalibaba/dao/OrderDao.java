package com.lwy.cloudalibaba.dao;

import com.lwy.cloudalibaba.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import javax.annotation.Resource;

/**
 * @auther zzyy
 * @create 2020-02-26 15:17
 */
@Resource
public interface OrderDao
{
    //1 新建订单
    @Insert(" insert into t_order (id,user_id,product_id,count,money,status)" +
            "        values (null,#{userId},#{productId},#{count},#{money},0);")
    void create(Order order);

    //2 修改订单状态，从零改为1
    @Update(" update t_order set status = 1" +
            "        where user_id=#{userId} and status = #{status};")
    void update(@Param("userId") Integer userId,@Param("status") Integer status);
}