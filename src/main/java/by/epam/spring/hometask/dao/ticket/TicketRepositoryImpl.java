package by.epam.spring.hometask.dao.ticket;

import by.epam.spring.hometask.domain.DomainObject;
import by.epam.spring.hometask.domain.Event;
import by.epam.spring.hometask.domain.Ticket;
import by.epam.spring.hometask.domain.User;
import by.epam.spring.hometask.service.AbstractDomainObjectService;
import by.epam.spring.hometask.service.BookingService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TicketRepositoryImpl implements BookingService, AbstractDomainObjectService<Ticket> {

    private static Set<Ticket> tickets = new HashSet<>();

    @Override
    public Ticket save(@Nonnull Ticket object) {
        tickets.add(object);
        return object;
    }

    @Override
    public void remove(@Nonnull Ticket object) {
        tickets.remove(object);
    }

    @Override
    public Ticket getById(@Nonnull Long id) {
        List<Ticket> list = tickets.stream().filter(ticket -> ticket.getId().equals(id)).collect(Collectors.toList());
        return list.isEmpty() ? null : list.get(0);
    }

    @Nonnull
    @Override
    public Collection getAll() {
        return tickets;
    }

    @Override
    public double getTicketsPrice(@Nonnull Event event, @Nonnull LocalDateTime dateTime, @Nullable User user, @Nonnull Set<Long> seats) {
        return 0;
    }

    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets) {

    }

    @Nonnull
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(@Nonnull Event event, @Nonnull LocalDateTime dateTime) {
        return null;
    }
}
