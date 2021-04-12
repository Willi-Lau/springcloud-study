package com.lwy.demo.dao;

import com.lwy.demo.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper   //使用这个就不用@MapperScan了
public interface PaymentDao {

     int create(Payment payment);

     Payment getPaymentById(Long id);
}
