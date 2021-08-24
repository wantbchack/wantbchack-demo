package com.wantbchack.springdata.repository;


import com.alibaba.fastjson.JSON;
import com.wantbchack.springdata.dto.StudentDto;
import com.wantbchack.springdata.dto.TeacherDto;
import com.wantbchack.springdata.entity.Student;
import com.wantbchack.springdata.entity.Teacher;
import com.wantbchack.springdata.entity.User;
import com.wantbchack.springdata.SpringBootDemoOrmJpaApplicationTests;

import com.wantbchack.springdata.entity.UserClass;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * <p>
 * jpa 测试类
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-11-07 14:09
 */
@Slf4j
public class UserDaoTest extends SpringBootDemoOrmJpaApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserClassRepository userClassRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void test01(){

        Optional<User> byId = userRepository.findById(1);
        User user = byId.get();
        String s = JSON.toJSONString(user);
        log.info("{}",s);
    }



    @Test
    public void test02(){

//        List<Student> all = studentRepository.findAll();
        Optional<Student> byId = studentRepository.findById(1);
        Student student = byId.get();
        StudentDto studentDto =new StudentDto();
        studentDto.setAge(student.getAge());
        studentDto.setId(student.getId());
        studentDto.setSex(student.getSex());
        studentDto.setStuName(student.getStuName());
        List<TeacherDto> teacherDtos= new ArrayList<>();
        TeacherDto teacherDto;
        for (Teacher teacher : student.getTeachers()) {
            teacherDto= new TeacherDto();
            teacherDto.setSex(teacher.getSex());
            teacherDto.setTeaName(teacher.getTeaName());
            teacherDtos.add(teacherDto);
        }
        studentDto.setTeacherDtos(teacherDtos);
        String s = JSON.toJSONString(studentDto);
        log.info("{}",s);
    }


    @Test
    public void test03(){
        Optional<Teacher> byId = teacherRepository.findById(1);
        Teacher teacher = byId.get();
        TeacherDto teacherDto = new TeacherDto();
        teacherDto= new TeacherDto();
        teacherDto.setSex(teacher.getSex());
        teacherDto.setTeaName(teacher.getTeaName());
        List<StudentDto> studentDtos= new ArrayList<>();
        for (Student student : teacher.getStudents()) {
            StudentDto studentDto =new StudentDto();
            studentDto.setAge(student.getAge());
            studentDto.setId(student.getId());
            studentDto.setSex(student.getSex());
            studentDto.setStuName(student.getStuName());
            studentDtos.add(studentDto);
        }
        teacherDto.setStudents(studentDtos);
        log.info("t:{}",JSON.toJSON(teacherDto));
    }

}
