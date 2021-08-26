package com.wantbchack.springdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wantbchack.springdata.entity.base.AbstractAuditModel;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author: fanxiaobin
 * @Date: 2021/08/24/15:53
 */

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Getter
@Setter
@Table(name = "teacher")
public class Teacher extends AbstractAuditModel {


    /**
     * tea_name
     */
    @Column(name="tea_name")
    private String teaName;

    /**
     * sex
     */
    @Column(name="sex")
    private String sex;


    @ManyToMany(mappedBy = "teachers",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Student> students;

}
