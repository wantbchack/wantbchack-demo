package com.wantbchack.task.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: fanxiaobin
 * @Date: 2021/11/12/9:52
 */
@Entity
@Data
@Table(name="cron")
public class Cron  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    /**
     * cron_id
     */
    @Column(name="cron_id")
    private String cronId;

    /**
     * cron
     */
    @Column(name="cron")
    private String cron;

}
