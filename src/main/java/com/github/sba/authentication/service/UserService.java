package com.github.sba.authentication.service;

import com.github.sba.authentication.bean.UserBean;
import com.github.sba.authentication.crud.BaseCrud;
import com.github.sba.authentication.entity.User;

public interface UserService extends BaseCrud<User, UserBean, String> {

}
