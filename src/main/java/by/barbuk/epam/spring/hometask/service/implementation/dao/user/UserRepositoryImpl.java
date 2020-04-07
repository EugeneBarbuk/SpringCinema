package by.barbuk.epam.spring.hometask.service.implementation.dao.user;

import by.barbuk.epam.spring.hometask.service.UserService;
import by.barbuk.epam.spring.hometask.domain.User;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public class UserRepositoryImpl implements UserService {

    @Override
    public User save(@Nonnull User user) {
        UserStorage.users.put(user.getId(), user);
        return user;
    }

    @Override
    public void remove(@Nonnull User user) {
        UserStorage.users.remove(user.getId());
    }

    @Override
    public User getById(@Nonnull Long id) {
        Optional<User> exist = UserStorage.users.values().stream().filter(user -> user.getId().equals(id)).findAny();
        return exist.orElse(null);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return new HashSet<>(UserStorage.users.values());
    }

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        Optional<User> exist = UserStorage.users.values().stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).findAny();
        return exist.orElse(null);
    }
}
