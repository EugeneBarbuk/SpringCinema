package by.epam.spring.hometask.dao.user;

import by.epam.spring.hometask.domain.DomainObject;
import by.epam.spring.hometask.domain.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDaoRepositoryImpl implements UserDao {
    private static Set<User> users = new HashSet<>();

    @Override
    public User getUserByEmail(String email) {

    users.stream().findFirst().ifPresent(user -> user.getEmail().equalsIgnoreCase(email));
        return null;
    }

    @Override
    public Long getById(Long id) {
        return null;
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
