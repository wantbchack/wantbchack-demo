package com.business.repository;


import com.business.model.LsDestinationGlobalGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LsDestinationGlobalGroupRepository extends JpaRepository<LsDestinationGlobalGroup,Integer> {



}
