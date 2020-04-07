package by.barbuk.epam.spring.hometask.service.implementation.dao.auditorium;

import by.barbuk.epam.spring.hometask.service.AuditoriumService;
import by.barbuk.epam.spring.hometask.service.implementation.dao.StorageEnum;

public class AuditoriumDaoFactory {
    public static AuditoriumService getAuditoriumDAO(StorageEnum vaultType) {
        switch (vaultType) {
            case REPOSITORY:
                return new AuditoriumRepositoryImpl();
            case MYSQL:
                return new AuditoriumDaoSqlImpl();
            default:
                return new AuditoriumRepositoryImpl();
        }
    }
}
