package by.epam.spring.hometask.dao.ticket;

import by.epam.spring.hometask.domain.Event;
import by.epam.spring.hometask.domain.Ticket;
import by.epam.spring.hometask.domain.User;
import by.epam.spring.hometask.service.AbstractDomainObjectService;
import by.epam.spring.hometask.service.BookingService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

public class TicketDaoSqlImpl implements BookingService, AbstractDomainObjectService<Ticket> {
    @Override
    public Ticket save(@Nonnull Ticket object) {
        return null;
    }

    @Override
    public void remove(@Nonnull Ticket object) {

    }

    @Override
    public Ticket getById(@Nonnull Long id) {
        return null;
    }

    @Nonnull
    @Override
    public Collection<Ticket> getAll() {
        return null;
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
