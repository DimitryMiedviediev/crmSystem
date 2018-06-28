package dao;

import entity.User;

import java.io.IOException;
import java.util.List;

public interface UserDAO {

    void createUser(User user) throws IOException;

    User getUser(Integer id) throws IOException;

    User getUser(String login) throws IOException;

    List<User> getUserList() throws IOException;

    void updateUser(User user) throws IOException;

}
