package by.barbuk.epam.spring.hometask.service.implementation.dao.ticket;

import by.barbuk.epam.spring.hometask.service.AuditoriumService;
import by.barbuk.epam.spring.hometask.service.TicketService;
import by.barbuk.epam.spring.hometask.service.implementation.dao.StorageEnum;
import by.barbuk.epam.spring.hometask.service.implementation.dao.auditorium.AuditoriumDaoSqlImpl;
import by.barbuk.epam.spring.hometask.service.implementation.dao.auditorium.AuditoriumRepositoryImpl;

public class TicketDaoFactory {
    public static TicketService getTicketDAO(StorageEnum vaultType) {
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
