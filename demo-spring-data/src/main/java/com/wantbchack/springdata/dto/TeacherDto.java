package com.wantbchack.springdata.dto;


import lombok.Data;

import java.util.List;

/**
 * @author: fanxiaobin
 * @Date: 2021/08/24/16:55
 */
@Data
public class TeacherDto {
    /**
     * tea_name
     */
    private String teaName;

    /**
     * sex
     */
    private String sex;



    private List<StudentDto> students;
}
