package com.wantbchack.springdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wantbchack.springdata.entity.base.AbstractAuditModel;
import lombok.*;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.util.List;

/**
 * @author: fanxiaobin
 * @Date: 2021/08/23/15:22
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Getter
@Setter
@Table(name = "user")
public class User extends AbstractAuditModel {

    /**
     * username
     */
    @Column(name="username")
    private String username;

    /**
     * password
     */
    @Column(name="password")
    private String password;

    /**
     * 关联用户课程
     */
    @OneToMany(targetEntity = UserClass.class,cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    @JsonIgnoreProperties({"user"})
    private List<UserClass> userClassList;

}
