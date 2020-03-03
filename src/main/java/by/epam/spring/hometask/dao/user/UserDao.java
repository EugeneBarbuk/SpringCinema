package by.epam.spring.hometask.dao.user;

import by.epam.spring.hometask.dao.AbstractDao;
import by.epam.spring.hometask.domain.User;

public interface UserDao extends AbstractDao {
    User getUserByEmail(String email);
}
