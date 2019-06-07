package com.dao;

import com.domain.ReceiveAddress;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiveAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReceiveAddress record);

    int insertSelective(ReceiveAddress record);

    ReceiveAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReceiveAddress record);

    int updateByPrimaryKey(ReceiveAddress record);
}