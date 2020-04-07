package by.barbuk.epam.spring.hometask.service.implementation.dao.user;

import by.barbuk.epam.spring.hometask.service.UserService;
import by.barbuk.epam.spring.hometask.service.implementation.dao.StorageEnum;

public class UserDaoFactory {
    public static UserService getUserDAO(StorageEnum vaultType) {
        switch (vaultType) {
            case REPOSITORY:
                return new UserRepositoryImpl();
            case MYSQL:
                return new UserDaoSqlImpl();
            default:
                return new UserRepositoryImpl();
        }
    }
}
