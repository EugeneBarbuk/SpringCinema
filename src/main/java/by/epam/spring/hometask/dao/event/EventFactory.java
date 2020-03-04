package by.epam.spring.hometask.dao.event;

import by.epam.spring.hometask.dao.StorageEnum;
import by.epam.spring.hometask.domain.Event;
import by.epam.spring.hometask.service.AbstractDomainObjectService;

public class EventFactory {
    public static AbstractDomainObjectService<Event> getUserService(StorageEnum vaultType) {
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
