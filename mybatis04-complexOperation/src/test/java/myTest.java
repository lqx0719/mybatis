import lqx.dao.StudentMapper;
import lqx.dao.TeacherMapper;
import lqx.pojo.Student;
import lqx.pojo.Teacher;
import lqx.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class myTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudents();
        for (Student s:students) {
            System.out.println(s.toString());
        }
        sqlSession.close();
    }
}
