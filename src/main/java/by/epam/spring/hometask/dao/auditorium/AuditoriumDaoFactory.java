package by.epam.spring.hometask.dao.auditorium;

import by.epam.spring.hometask.dao.AbstractDao;
import by.epam.spring.hometask.dao.VaultEnum;
import by.epam.spring.hometask.dao.user.UserDaoRepositoryImpl;
import by.epam.spring.hometask.dao.user.UserDaoSqlImpl;
import by.epam.spring.hometask.domain.Auditorium;
import by.epam.spring.hometask.domain.User;

public class AuditoriumDaoFactory {
    public static AbstractDao<Auditorium> getUserDAO(String type) {
        if (type.equalsIgnoreCase(String.valueOf(VaultEnum.REPOSITORY))) {
            return new UserDaoRepositoryImpl();
        } else if (type.equalsIgnoreCase(String.valueOf(VaultEnum.MYSQL))) {
            return new UserDaoSqlImpl();
        } else {
            return new UserDaoRepositoryImpl();
        }
    }

}
