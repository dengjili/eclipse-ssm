package priv.dengjl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import priv.dengjl.entity.Student;
import priv.dengjl.mapper.StudentMapper;

/*
指定为Service类，影响到Controller的注入，可以自定义名称
 */
@Service(value = "StuService")
public class StudentService {

    /*
    spring会根据类型自动装配
     */
    @Resource
    private StudentMapper studentMapper;

    /*
    以下方法都被增强，具有事务，进入方法前开启事务，方法执行完成后递交事务
     */
    public int addStu(Student student) {
        return studentMapper.addStu(student);
    }

    public Student findStuById(int studentNo) {
        return studentMapper.findStuById(studentNo);
    }

    public int updateStu(Student student) {
        return studentMapper.updateStu(student);
    }

    public int deleteStu(int studentNo) {
        //手动制造异常，如果非正常退出方法，事务回滚至进入方法前
        int n = 1 / 0;
        return studentMapper.deleteStu(studentNo);
    }

    public List<Student> getStudentsGrade() {
        return studentMapper.getStudentsGrade();
    }

    public Student getStudentResults(int studentNo) {
        return studentMapper.getStudentResults(studentNo);
    }
    
    public List<Student> getStudents() {
    	return studentMapper.getStudents();
    }
}