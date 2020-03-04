package by.epam.spring.hometask.dao.auditorium;

import by.epam.spring.hometask.dao.StorageEnum;
import by.epam.spring.hometask.domain.Auditorium;
import by.epam.spring.hometask.service.AbstractDomainObjectService;

public class AuditoriumDaoFactory {
    public static AbstractDomainObjectService<Auditorium> getAuditoriumDAO(StorageEnum vaultType) {
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
