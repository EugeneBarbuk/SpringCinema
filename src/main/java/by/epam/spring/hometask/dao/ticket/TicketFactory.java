package by.epam.spring.hometask.dao.ticket;

import by.epam.spring.hometask.dao.StorageEnum;
import by.epam.spring.hometask.dao.auditorium.AuditoriumDaoSqlImpl;
import by.epam.spring.hometask.dao.auditorium.AuditoriumRepositoryImpl;
import by.epam.spring.hometask.domain.Auditorium;
import by.epam.spring.hometask.domain.Ticket;
import by.epam.spring.hometask.service.AbstractDomainObjectService;

public class TicketFactory {
    public static AbstractDomainObjectService<Ticket> getAuditoriumDAO(StorageEnum vaultType) {
        switch (vaultType) {
            case REPOSITORY:
                return new TicketRepositoryImpl();
            case MYSQL:
                return new TicketDaoSqlImpl();
            default:
                return new TicketRepositoryImpl();
        }
    }
}
