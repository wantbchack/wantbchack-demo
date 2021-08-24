package com.wantbchack.springdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wantbchack.springdata.entity.base.AbstractAuditModel;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author: fanxiaobin
 * @Date: 2021/08/24/15:51
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Getter
@Setter
@Table(name = "student")
public class Student extends AbstractAuditModel {
    /**
     * stu_name
     */
    @Column(name="stu_name")
    private String stuName;

    /**
     * sex
     */
    @Column(name="sex")
    private String sex;

    /**
     * age
     */
    @Column(name="age")
    private Integer age;

    /**
     * stu_num
     */
    @Column(name="stu_num")
    private Integer stuNum;


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "student_teacher",joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id")
            ,inverseJoinColumns =@JoinColumn(name = "teacher_id",referencedColumnName = "id"))
    private List<Teacher> teachers;
}
