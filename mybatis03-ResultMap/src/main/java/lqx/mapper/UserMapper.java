package lqx.mapper;

import java.util.List;

public interface UserMapper {
    List<User> getUsers();
    User getUserByID(int id);
    int insert(User user);
    int delete(int id);
    int update(User user);
}
