package com.csb.core.service;

import com.csb.core.model.User;

public interface UserService extends BaseService<User>{
    
    public void register(User user);
    
    public void active(User user);
}
