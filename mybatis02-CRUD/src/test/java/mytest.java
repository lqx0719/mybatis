import lqx.mapper.User;
import lqx.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class mytest {
    @Test
    public void getUserByIDTest(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByID(1);
        System.out.println(user.toString());
        sqlSession.close();
    }

    @Test
    public void insertTest(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.insert(new User(5,"haha","1111"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserByID(1);
        user.setPwd("asdfgh");
        int i = mapper.update(user);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        user = mapper.getUserByID(1);
        System.out.println(user.toString());
        session.close();
    }

    @Test
    public void testDeleteUser() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.delete(3);
        System.out.println(i);
        session.commit(); //提交事务,重点!不写的话不会提交到数据库
        session.close();
    }
}
