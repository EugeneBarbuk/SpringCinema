package by.barbuk.epam.spring.hometask.service.implementation.dao.booking;

import by.barbuk.epam.spring.hometask.domain.Auditorium;
import by.barbuk.epam.spring.hometask.domain.Event;
import by.barbuk.epam.spring.hometask.domain.EventRatingEnum;
import by.barbuk.epam.spring.hometask.domain.Ticket;
import by.barbuk.epam.spring.hometask.domain.User;
import by.barbuk.epam.spring.hometask.service.BookingService;
import by.barbuk.epam.spring.hometask.service.DiscountService;
import by.barbuk.epam.spring.hometask.service.TicketService;
import by.barbuk.epam.spring.hometask.service.implementation.dao.StorageEnum;
import by.barbuk.epam.spring.hometask.service.implementation.dao.auditorium.AuditoriumStorage;
import by.barbuk.epam.spring.hometask.service.implementation.dao.ticket.TicketDaoFactory;
import by.barbuk.epam.spring.hometask.service.implementation.dao.ticket.TicketStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;

import java.util.Set;

public class BookingServiceImpl implements BookingService {

    float highRate = 1.2f;
    float vipRate = 2;

    private DiscountService discountService;
    private TicketService ticketService = TicketDaoFactory.getTicketDAO(StorageEnum.REPOSITORY);

    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }


    @Override
    public double getTicketsPrice(
            @Nonnull Event event,
            @Nonnull LocalDateTime dateTime,
            @Nullable User user,
            @Nonnull Set<Long> seats) {

        Auditorium auditorium = event.getAuditoriums().get(dateTime);
        long vipSeatsCount = auditorium.countVipSeats(seats);
        long regularSeats = seats.size() - vipSeatsCount;

        double eventPrice = getPrice(event);

        int discount = discountService.getDiscount(user, event, dateTime, seats.size());

        return (eventPrice * regularSeats + eventPrice * vipSeatsCount * vipRate) * (((double) 100 - discount) / 100);

    }

    @Override
    public void bookTickets(Set<Ticket> tickets) {
        tickets.forEach(ticket -> ticketService.save(ticket));
    }

    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(
            @Nonnull Event event,
            @Nonnull LocalDateTime dateTime) {
        return ticketService.getTicketsByEvent(event, dateTime);
    }

    private double getPrice(Event event) {
        double basePrice = event.getBasePrice();
        return event.getRating() == EventRatingEnum.HIGH ? basePrice * highRate : basePrice;
    }
}
