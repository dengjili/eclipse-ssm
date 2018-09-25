package priv.dengjl.mapper;

import java.util.List;

import priv.dengjl.entity.Student;

public interface StudentMapper {
	// 增加学生信息
	public int addStu(Student student);

	// 通过id查找学生信息
	public Student findStuById(int studentNo);

	// 修改学生信息
	public int updateStu(Student student);

	// 通过id删除学生
	public int deleteStu(int studentNo);

	// 查询所有学生所属年级（学生，多对一，年级）
	public List<Student> getStudentsGrade();

	// 查询学生的所有课程的成绩（学生，一对多，成绩，一对一，课程）
	public Student getStudentResults(int studentNo);

	// 查询学生
	public List<Student> getStudents();
}
