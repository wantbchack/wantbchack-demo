package com.wantbchack.springdata.repository;

import com.wantbchack.springdata.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: fanxiaobin
 * @Date: 2021/08/24/16:01
 */
public interface StudentRepository  extends JpaRepository<Student,Integer> {
}
