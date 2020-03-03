package by.epam.spring.hometask.dao.user;

import by.epam.spring.hometask.domain.DomainObject;
import by.epam.spring.hometask.domain.User;

import java.util.Collection;

public class UserDaoSqlImpl implements UserDao {
    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public Long getById(Long id) {
        return id;
    }

    @Override
    public DomainObject add(DomainObject object) {
        return null;
    }

    @Override
    public void remove(DomainObject object) {

    }

    @Override
    public Collection getAll() {
        return null;
    }
}
