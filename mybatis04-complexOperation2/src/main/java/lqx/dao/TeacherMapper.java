package lqx.dao;

import lqx.pojo.Student;
import lqx.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    @Select("select * from teacher where id=#{id}")
    Teacher getTeacher(@Param("id") int id);

    Teacher getStudents(int id);
}
