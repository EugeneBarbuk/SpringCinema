package by.barbuk.epam.spring.hometask.service.implementation.dao.user;

import by.barbuk.epam.spring.hometask.domain.User;

import java.util.Map;

public class UserStorage {
    public static Map<Long, User> users;

    private UserStorage(Map<Long, User> users) {
        UserStorage.users = users;
    }

    private UserStorage() {
    }
}
