package com.wantbchack.business.repository;


import com.wantbchack.business.model.LsDestination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LsDestinationRepository extends JpaRepository<LsDestination,Integer>,JpaSpecificationExecutor<LsDestination> {
    LsDestination findByDestinationId(Integer destinationId) ;

    List<LsDestination> findByPid(Integer id);
}
