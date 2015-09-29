package com.csb.core.platform.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.csb.core.common.BaseRepository;
import com.csb.core.platform.entity.SaasPlan;
import com.csb.core.platform.entity.SaasProvisionResponse;

@Repository
public interface SaasProvisionResponseRepository extends BaseRepository<SaasProvisionResponse, Long> {
	 public List<SaasProvisionResponse> findBySaasPlan(SaasPlan saasPlan);
}
