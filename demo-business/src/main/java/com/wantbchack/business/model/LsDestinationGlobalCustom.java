package com.wantbchack.business.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ls_destination_global_custom")
public class LsDestinationGlobalCustom implements Serializable {

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
     * 分组id
     */
    @Column(name="group_id")
    private Integer groupId;

    /**
     * 目标内容id
     */
    @Column(name="target_id")
    private Integer targetId;

    /**
     * 目标内容类型
     */
    @Column(name="target_type")
    private Integer targetType;

    /**
     * 推荐值
     */
    @Column(name="recommend")
    private Integer recommend;

    /**
     * 是否大卡片 0:是 1:否
     */
    @Column(name="is_big_card")
    private Integer isBigCard;

    /**
     * 是否展示标题 0:是 1:否
     */
    @Column(name="is_display_title")
    private Integer isDisplayTitle;

    /**
     * 是否目的地显示 0:是 1:否
     */
    @Column(name="is_destination_display")
    private Integer isDestinationDisplay;

    /**
     * 修改后的原图地址
     */
    @Column(name="original_picture")
    private String originalPicture;

    /**
     * 推荐标签
     */
    @Column(name="recommended_label")
    private String recommendedLabel;

    public LsDestinationGlobalCustom() {
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

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    public Integer getIsBigCard() {
        return isBigCard;
    }

    public void setIsBigCard(Integer isBigCard) {
        this.isBigCard = isBigCard;
    }

    public Integer getIsDisplayTitle() {
        return isDisplayTitle;
    }

    public void setIsDisplayTitle(Integer isDisplayTitle) {
        this.isDisplayTitle = isDisplayTitle;
    }

    public Integer getIsDestinationDisplay() {
        return isDestinationDisplay;
    }

    public void setIsDestinationDisplay(Integer isDestinationDisplay) {
        this.isDestinationDisplay = isDestinationDisplay;
    }

    public String getOriginalPicture() {
        return originalPicture;
    }

    public void setOriginalPicture(String originalPicture) {
        this.originalPicture = originalPicture;
    }

    public String getRecommendedLabel() {
        return recommendedLabel;
    }

    public void setRecommendedLabel(String recommendedLabel) {
        this.recommendedLabel = recommendedLabel;
    }
}
