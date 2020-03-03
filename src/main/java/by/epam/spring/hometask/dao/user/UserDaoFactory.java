package by.epam.spring.hometask.dao.user;

import by.epam.spring.hometask.dao.AbstractDao;
import by.epam.spring.hometask.dao.VaultEnum;
import by.epam.spring.hometask.domain.User;

public class UserDaoFactory {
    public static AbstractDao<User> getUserDAO(String type) {
        if (type.equalsIgnoreCase(String.valueOf(VaultEnum.REPOSITORY))) {
            return new UserDaoRepositoryImpl();
        } else if (type.equalsIgnoreCase(String.valueOf(VaultEnum.MYSQL))) {
            return new UserDaoSqlImpl();
        } else {
            return new UserDaoRepositoryImpl();
        }
    }
}
