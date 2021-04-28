package com.lwy.cloudalibaba.service;


public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Integer productId, Integer count);
}
