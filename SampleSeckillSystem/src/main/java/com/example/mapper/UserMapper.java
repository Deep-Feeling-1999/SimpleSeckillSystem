package com.example.mapper;

import com.example.domain.mUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Deep-Feeling-1999
 * @create 2021/1/4
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 获得所有用户信息
     * @return 用户信息的List列表
     */
    List<mUser> getAllUser();

    /**
     * 增加一个用户
     * @param user 集成好的员工类
     */
    void addUser(mUser user);

    /**
     * 删除对应账号的用户
     * @param uAccount 用户账号
     */
    void deleteUserWithAccount(String uAccount);

    /**
     * 获取对应账号的用户信息
     * @param uAccount 用户编号
     * @return 集成好的用户类
     */
    mUser getUserWithAccount(String uAccount);

    /**
     * 更新用户密码
     * @param user 修改好的对应用户类
     */
    void updateUser(mUser user);
}
