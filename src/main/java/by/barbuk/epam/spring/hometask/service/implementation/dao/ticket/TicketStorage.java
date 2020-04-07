package by.barbuk.epam.spring.hometask.service.implementation.dao.ticket;

import by.barbuk.epam.spring.hometask.domain.Ticket;

import java.util.Map;

public class TicketStorage {
    public static Map<Long, Ticket> tickets;

    private TicketStorage(Map<Long, Ticket> tickets) {
        TicketStorage.tickets = tickets;
    }

    private TicketStorage() {
    }
}
