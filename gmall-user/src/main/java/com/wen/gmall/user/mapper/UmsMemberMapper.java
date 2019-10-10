package com.wen.gmall.user.mapper;

import com.wen.gmall.user.entity.UmsMember;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UmsMemberMapper extends Mapper<UmsMember> {

    List<UmsMember> selectAllUser();
}
