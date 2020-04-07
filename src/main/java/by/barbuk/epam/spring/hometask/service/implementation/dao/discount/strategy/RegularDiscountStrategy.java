package by.barbuk.epam.spring.hometask.service.implementation.dao.discount.strategy;

import by.barbuk.epam.spring.hometask.service.TicketService;
import by.barbuk.epam.spring.hometask.service.implementation.dao.StorageEnum;
import by.barbuk.epam.spring.hometask.service.implementation.dao.ticket.TicketDaoFactory;
import by.barbuk.epam.spring.hometask.service.implementation.dao.ticket.TicketRepositoryImpl;
import by.barbuk.epam.spring.hometask.domain.Ticket;
import by.barbuk.epam.spring.hometask.domain.User;
import by.barbuk.epam.spring.hometask.service.implementation.dao.ticket.TicketStorage;

import java.time.LocalDateTime;
import java.util.Collection;

public class RegularDiscountStrategy implements AbstractDiscountStrategy {

    private static final int REGULAR_DISCOUNT = 5;  // 50% for every 10th ticket purchased by user.
    private static final int TICKETS_TO_GET_DISCOUNT = 10;

    private TicketStorage ticketStorage;
    private TicketService ticketDAO = TicketDaoFactory.getTicketDAO(StorageEnum.REPOSITORY);

    public void setTicketRepository(TicketStorage ticketStorage) {
        this.ticketStorage = ticketStorage;
    }

    @Override
    public int getDiscount(User user, LocalDateTime airDate, long numberOfTickets) {
        Collection<Ticket> ticketsByEmail = ticketDAO.getTicketsByEmail(user.getEmail());
        assert ticketsByEmail != null;
        int restFromBoughtTickets = ticketsByEmail.size() % TICKETS_TO_GET_DISCOUNT;
        int ticketsForDiscount = (int) (numberOfTickets + restFromBoughtTickets) / TICKETS_TO_GET_DISCOUNT;
        return ticketsForDiscount * REGULAR_DISCOUNT;
    }
}
