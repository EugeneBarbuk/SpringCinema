package by.barbuk.epam.spring.hometask.domain.unit;

import by.barbuk.epam.spring.hometask.BaseTest;
import by.barbuk.epam.spring.hometask.domain.Auditorium;
import by.barbuk.epam.spring.hometask.domain.Event;
import by.barbuk.epam.spring.hometask.domain.Ticket;
import by.barbuk.epam.spring.hometask.domain.User;
import by.barbuk.epam.spring.hometask.service.AuditoriumService;
import by.barbuk.epam.spring.hometask.service.BookingService;
import by.barbuk.epam.spring.hometask.service.DiscountService;
import by.barbuk.epam.spring.hometask.service.EventService;
import by.barbuk.epam.spring.hometask.service.TicketService;
import by.barbuk.epam.spring.hometask.service.UserService;
import by.barbuk.epam.spring.hometask.service.implementation.dao.StorageEnum;
import by.barbuk.epam.spring.hometask.service.implementation.dao.auditorium.AuditoriumDaoFactory;
import by.barbuk.epam.spring.hometask.service.implementation.dao.auditorium.AuditoriumStorage;
import by.barbuk.epam.spring.hometask.service.implementation.dao.event.EventDaoFactory;
import by.barbuk.epam.spring.hometask.service.implementation.dao.event.EventStorage;
import by.barbuk.epam.spring.hometask.service.implementation.dao.ticket.TicketDaoFactory;
import by.barbuk.epam.spring.hometask.service.implementation.dao.ticket.TicketStorage;
import by.barbuk.epam.spring.hometask.service.implementation.dao.user.UserDaoFactory;
import by.barbuk.epam.spring.hometask.service.implementation.dao.user.UserStorage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;


public class TestBookingService extends BaseTest {

    private Event event;
    private User user1, user2;
    private Ticket ticket1, ticket2, ticket3, ticket4, ticket5;

    private EventStorage eventStorage = (EventStorage) context.getBean("eventRepositoryImpl");
    private AuditoriumStorage auditoriumStorage = (AuditoriumStorage) context.getBean("auditoriumRepositoryImpl");
    private UserStorage userStorage = (UserStorage) context.getBean("userRepositoryImpl");
    private TicketStorage ticketStorage = (TicketStorage) context.getBean("ticketRepositoryImpl");
    private DiscountService discountService = (DiscountService) context.getBean("discountServiceImpl");
    private EventService eventService = EventDaoFactory.getEventDAO(StorageEnum.REPOSITORY);
    private AuditoriumService auditoriumService = AuditoriumDaoFactory.getAuditoriumDAO(StorageEnum.REPOSITORY);
    private UserService userService = UserDaoFactory.getUserDAO(StorageEnum.REPOSITORY);
    private TicketService ticketService = TicketDaoFactory.getTicketDAO(StorageEnum.REPOSITORY);
    private BookingService bookingService = (BookingService) context.getBean("bookingServiceImpl");


    @BeforeTest
    public void init() {
        final String USER_EMAIL_1 = "Email1@epam.com";
        final String USER_EMAIL_2 = "Email1@epam.com";
        final String EVENT_NAME = "Name1";
        final String AUDITORIUM1_NAME = "greenAuditorium";
        final String AUDITORIUM2_NAME = "redAuditorium";
        final String AIR_DATE_EVENT = "2019-11-08T10:00";

        event = eventService.getByName(EVENT_NAME);
        LocalDateTime airDate = LocalDateTime.parse(AIR_DATE_EVENT);
        Auditorium auditorium1 = auditoriumService.getByName(AUDITORIUM1_NAME);
        Auditorium auditorium2 = auditoriumService.getByName(AUDITORIUM2_NAME);
        event.addAirDateTime(airDate, auditorium1);
        event.addAirDateTime(airDate.plusDays(1), auditorium2);

        user1 = userService.getUserByEmail(USER_EMAIL_1);
        user2 = userService.getUserByEmail(USER_EMAIL_2);

        ticket1 = new Ticket(1L, user1, event, event.getAirDates().first(), 1);
        ticket2 = new Ticket(2L, user1, event, event.getAirDates().first(), 2);
        ticket3 = new Ticket(3L, user1, event, event.getAirDates().first(), 3);
        ticket4 = new Ticket(4L, user1, event, event.getAirDates().first(), 4);
        ticket5 = new Ticket(5L, user2, event, event.getAirDates().first(), 5);
    }

    @Test
    public void testGetTicketsPrice() {
        double ticketsPrice = bookingService.getTicketsPrice(event, event.getAirDates().first(), user1,
                new HashSet<>(Arrays.asList(ticket1.getSeat(), ticket2.getSeat(), ticket3.getSeat(), ticket4.getSeat())));
        Assert.assertEquals(8.4, ticketsPrice, 0.001);
    }
}
