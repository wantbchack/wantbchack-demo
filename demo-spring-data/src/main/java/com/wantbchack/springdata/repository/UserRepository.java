package com.wantbchack.springdata.repository;

import com.wantbchack.springdata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: fanxiaobin
 * @Date: 2021/08/23/15:58
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
