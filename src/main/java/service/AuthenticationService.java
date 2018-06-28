package service;

import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;

import java.io.IOException;
import java.util.Objects;

public class AuthenticationService {

    private UserDAO userDAO = new UserDAOImpl();

    public Boolean validateUser(String login, String password) throws IOException {
        User user = userDAO.getUser(login);
        return Objects.equals(user.getLogin(), login) && Objects.equals(user.getPassword(), password);
    }

    public User getUserInfo(String login) throws IOException {
        return userDAO.getUser(login);
    }

}
