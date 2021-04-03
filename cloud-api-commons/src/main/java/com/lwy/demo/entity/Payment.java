package com.lwy.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor  //全参构造
@AllArgsConstructor   //无参构造
public class Payment implements Serializable
{
    private long id;
    private String serial;
}
