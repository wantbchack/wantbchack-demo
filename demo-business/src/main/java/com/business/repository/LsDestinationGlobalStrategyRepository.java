package com.business.repository;


import com.business.model.LsDestinationGlobalStrategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

;


@Repository
public interface LsDestinationGlobalStrategyRepository extends JpaRepository<LsDestinationGlobalStrategy,Integer>
                                    ,JpaSpecificationExecutor<LsDestinationGlobalStrategy> {



}