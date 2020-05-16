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
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getStudents(1);
        for(Student s:teacher.getStudents()){
            System.out.println(s.toString());
        }
        sqlSession.close();
    }
}
