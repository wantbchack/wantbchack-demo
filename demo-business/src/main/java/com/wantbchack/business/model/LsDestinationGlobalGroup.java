package com.wantbchack.business.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ls_destination_global_group")
public class LsDestinationGlobalGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    /**
     * id
     */
    @Column(name="id")
    private Integer id;

    /**
     * 目的地id
     */
    @Column(name="destination_id")
    private Integer destinationId;

    /**
     * 分组名称
     */
    @Column(name="name")
    private String name;

    /**
     * 优先级
     */
    @Column(name="priority")
    private Integer priority;

    public LsDestinationGlobalGroup() {
    }
}
