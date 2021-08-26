package com.wantbchack.springdata.repository;

import com.wantbchack.springdata.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author: fanxiaobin
 * @Date: 2021/08/24/16:02
 */
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
