package com.csb.core.platform.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.csb.core.common.BaseRepository;
import com.csb.core.platform.entity.SaaSPlan;
import com.csb.core.platform.entity.SaaSProvisionResponse;

@Repository
public interface SaaSProvisionResponseRepository extends BaseRepository<SaaSProvisionResponse, Long> {
	 public List<SaaSProvisionResponse> findBySaasPlan(SaaSPlan saasPlan);
}
