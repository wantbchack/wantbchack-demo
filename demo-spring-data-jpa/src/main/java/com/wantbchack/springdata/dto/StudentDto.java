package com.wantbchack.springdata.dto;

import com.wantbchack.springdata.entity.Teacher;
import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author: fanxiaobin
 * @Date: 2021/08/24/16:51
 */
@Data
public class StudentDto {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 上次更新时间
     */
    private Date lastUpdateTime;

    /**
     * stu_name
     */
    private String stuName;

    /**
     * sex
     */
    private String sex;

    /**
     * age
     */
    private Integer age;

    private List<TeacherDto> teacherDtos;
}
