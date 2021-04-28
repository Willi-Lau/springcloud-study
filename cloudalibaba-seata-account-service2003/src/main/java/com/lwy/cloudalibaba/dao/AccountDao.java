package com.lwy.cloudalibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.ConcurrentMap;

@Resource
public interface AccountDao {

    /**
     * 扣减账户余额
     */
    @Update("UPDATE t_account" +
            "        SET" +
            "          residue = residue - #{money},used = used + #{money}" +
            "        WHERE" +
            "          user_id = #{userId};")
    void decrease(@Param("userId") Integer userId, @Param("money") BigDecimal money);
}
