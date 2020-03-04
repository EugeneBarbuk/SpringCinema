package by.epam.spring.hometask.dao.user;

import by.epam.spring.hometask.dao.StorageEnum;
import by.epam.spring.hometask.domain.User;
import by.epam.spring.hometask.service.AbstractDomainObjectService;

public class UserDaoFactory {
    public static AbstractDomainObjectService<User> getUserService(StorageEnum vaultType) {
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
