package com.sy.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.sy.dao.UsersDao;
import com.sy.pojo.Users;
import com.sy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by haswell on 2018/4/4.
 */
@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    public UsersDao usersDao;

    @Override
    public List<Users> getListUsers(int id) {
        PageHelper.startPage(1, 3);
        return usersDao.getListUsers(id);
    }
}
