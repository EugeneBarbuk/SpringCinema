package by.barbuk.epam.spring.hometask.service.implementation.dao.user;

import by.barbuk.epam.spring.hometask.domain.User;
import by.barbuk.epam.spring.hometask.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

/**
 * Mock class for future actions
 */

public class UserDaoSqlImpl implements UserService {

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        return null;
    }

    @Override
    public User save(@Nonnull User object) {
        return null;
    }

    @Override
    public void remove(@Nonnull User object) {

    }

    @Override
    public User getById(@Nonnull Long id) {
        return null;
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return null;
    }
}
