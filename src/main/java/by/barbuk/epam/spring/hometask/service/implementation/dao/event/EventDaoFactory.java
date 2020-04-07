package by.barbuk.epam.spring.hometask.service.implementation.dao.event;

import by.barbuk.epam.spring.hometask.service.EventService;
import by.barbuk.epam.spring.hometask.service.implementation.dao.StorageEnum;

public class EventDaoFactory {
    public static EventService getEventDAO(StorageEnum vaultType) {
        switch (vaultType) {
            case REPOSITORY:
                return new EventRepositoryImpl();
            case MYSQL:
                return new EventDaoSqlImpl();
            default:
                return new EventRepositoryImpl();
        }
    }
}
