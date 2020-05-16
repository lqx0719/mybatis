package lqx.dao;

import lqx.pojo.Student;
import lqx.pojo.Teacher;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudents();
    Teacher getTeacher(int id);
}
