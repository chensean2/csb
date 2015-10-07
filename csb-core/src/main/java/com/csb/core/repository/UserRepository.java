package com.csb.core.repository;

import org.springframework.stereotype.Repository;

import com.csb.core.common.BaseRepository;
import com.csb.core.entity.User;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

    User findByUserName(String userName);
}
