package com.wantbchack.springdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wantbchack.springdata.entity.base.AbstractAuditModel;
import lombok.*;

import javax.persistence.*;

/**
 * @author: fanxiaobin
 * @Date: 2021/08/23/15:54
 */

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Getter
@Setter
@Table(name = "user_class")
public class UserClass extends AbstractAuditModel {

    /**
     * user_id
     */
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id",updatable = false)
    @JsonIgnoreProperties({"userClass"})
    private User user;

    /**
     * class_id
     */
    @Column(name="class_id")
    private Integer classId;

    /**
     * class_name
     */
    @Column(name="class_name")
    private String className;

}
