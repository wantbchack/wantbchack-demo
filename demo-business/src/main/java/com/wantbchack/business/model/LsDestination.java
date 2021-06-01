package com.wantbchack.business.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ls_destination")
public class LsDestination implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    /**
     * id
     */
    @Column(name="id")
    private Integer id;

    /**
     * 父id
     */
    @Column(name="pid")
    private Integer pid;

    /**
     * 目的地id
     */
    @Column(name="destination_id")
    private Integer destinationId;

    /**
     * region_id
     */
    @Column(name="region_id")
    private Integer regionId;

    /**
     * 名称
     */
    @Column(name="name")
    private String name;

    /**
     * 等级
     */
    @Column(name="level")
    private Integer level;

    public LsDestination() {
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}