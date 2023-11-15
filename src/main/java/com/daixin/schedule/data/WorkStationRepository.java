package com.daixin.schedule.data;

import com.daixin.schedule.models.WorkStation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkStationRepository extends CrudRepository<WorkStation, Integer> {
}
