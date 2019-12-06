package com.dashboard.repository;

import com.dashboard.model.Config;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigRepository extends PagingAndSortingRepository<Config, String> {

}
