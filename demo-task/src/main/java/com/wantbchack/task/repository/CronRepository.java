package com.wantbchack.task.repository;

import com.wantbchack.task.entity.Cron;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author: fanxiaobin
 * @Date: 2021/11/12/9:54
 */
@Repository
    public interface CronRepository  extends JpaRepository<Cron,Integer> {

    @Query(value = "select  *  from  Cron where  cron_id =?1" ,nativeQuery = true)
    Cron findByCronId(int i);
}
