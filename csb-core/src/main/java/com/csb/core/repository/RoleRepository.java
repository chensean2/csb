package com.csb.core.repository;

import org.springframework.stereotype.Repository;

import com.csb.core.common.BaseRepository;
import com.csb.core.entity.Role;

@Repository
public interface RoleRepository extends BaseRepository<Role, Long> {

}
