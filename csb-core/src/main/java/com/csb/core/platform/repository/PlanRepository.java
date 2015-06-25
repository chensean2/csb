package com.csb.core.platform.repository;

import org.springframework.stereotype.Repository;

import com.csb.core.common.BaseRepository;
import com.csb.core.platform.entity.Plan;

@Repository
public interface PlanRepository extends BaseRepository<Plan, Long> {

    public Plan findByEventId(String eventId);
}
