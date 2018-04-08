package com.sy.dao;

import com.sy.pojo.Users;

import java.util.List;

/**
 * Created by haswell on 2018/4/4.
 */
public interface UsersDao {

    List<Users> getListUsers(int id);

}
