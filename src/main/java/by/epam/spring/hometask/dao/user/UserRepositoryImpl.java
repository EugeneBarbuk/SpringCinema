package by.epam.spring.hometask.dao.user;

import by.epam.spring.hometask.domain.User;
import by.epam.spring.hometask.service.UserService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryImpl implements UserService {

    private static Map<Long, User> users = new HashMap<>();

    @Override
    public User save(@Nonnull User object) {
        users.put(object.getId(), object);
        return object;
    }

    @Override
    public void remove(@Nonnull User object) {
        users.remove(object.getId());
    }

    @Override
    public User getById(@Nonnull Long id) {
        Optional<User> exist = users.values().stream().filter(user -> user.getId().equals(id)).findAny();
        return exist.orElse(null);
    }

    @Nonnull
    @Override
    public Collection<User> getAll() {
        return new HashSet<>(users.values());
    }

    @Nullable
    @Override
    public User getUserByEmail(@Nonnull String email) {
        Optional<User> exist = users.values().stream().filter(user -> user.getEmail().equalsIgnoreCase(email)).findAny();
        return exist.orElse(null);
    }
}
