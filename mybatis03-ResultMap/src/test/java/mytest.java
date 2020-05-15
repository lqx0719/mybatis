import lqx.mapper.User;
import lqx.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class mytest {
    static Logger logger = Logger.getLogger(mytest.class);

    @Test
    public void getUsersTest(){
        SqlSession sqlSession = MybatisUtils.getSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getUsers();
        logger.info("info：进入selectUser方法");
        logger.debug("debug：进入selectUser方法");
        logger.error("error: 进入selectUser方法");
        for(User u:users){
            System.out.println(u.toString());
        }
    }

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
        mapper.insert(new User(3,"haha","1111"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession session = MybatisUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserByID(1);
        user.setPassword("asdfgh");
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
