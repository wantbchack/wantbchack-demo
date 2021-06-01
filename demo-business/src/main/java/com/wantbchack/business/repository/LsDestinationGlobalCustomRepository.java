package com.wantbchack.business.repository;


import com.wantbchack.business.model.LsDestinationGlobalCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LsDestinationGlobalCustomRepository extends JpaRepository<LsDestinationGlobalCustom,Integer> {



    LsDestinationGlobalCustom findByDestinationIdAndTargetId(Integer destinationId, Integer targetId);
}