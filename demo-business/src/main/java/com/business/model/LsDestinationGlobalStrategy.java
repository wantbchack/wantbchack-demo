package com.business.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ls_destination_global_strategy")
public class LsDestinationGlobalStrategy implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    /**
     * id
     */
    @Column(name="id")
    private Integer id;

    /**
     * 标题
     */
    @Column(name="title")
    private String title;

    /**
     * 攻略类型 文章、动态
     */
    @Column(name="strategy_type")
    private Integer strategyType;

    /**
     * 对应的文章或者动态的id
     */
    @Column(name="target_id")
    private Integer targetId;

    /**
     * 攻略来源
     */
    @Column(name="strategy_source")
    private String strategySource;

    /**
     * 功略作者
     */
    @Column(name="strategy_author")
    private String strategyAuthor;

    /**
     * 关联ls_basic_sregion的id 城市级别
     */
    @Column(name="region_id")
    private Integer regionId;



    public LsDestinationGlobalStrategy() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(Integer strategyType) {
        this.strategyType = strategyType;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getStrategySource() {
        return strategySource;
    }

    public void setStrategySource(String strategySource) {
        this.strategySource = strategySource;
    }

    public String getStrategyAuthor() {
        return strategyAuthor;
    }

    public void setStrategyAuthor(String strategyAuthor) {
        this.strategyAuthor = strategyAuthor;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }
}
