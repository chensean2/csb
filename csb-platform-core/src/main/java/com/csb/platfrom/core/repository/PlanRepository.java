package com.csb.platfrom.core.repository;

import org.springframework.stereotype.Repository;

import com.csb.platform.core.entity.Plan;

@Repository
public interface PlanRepository extends BaseRepository<Plan, Long> {

    public Plan findByEventId(String eventId);
}
