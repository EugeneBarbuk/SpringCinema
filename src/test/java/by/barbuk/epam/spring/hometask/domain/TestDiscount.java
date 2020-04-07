package by.barbuk.epam.spring.hometask.domain;

import by.barbuk.epam.spring.hometask.BaseTest;
import by.barbuk.epam.spring.hometask.domain.Auditorium;
import by.barbuk.epam.spring.hometask.domain.Event;
import by.barbuk.epam.spring.hometask.domain.Ticket;
import by.barbuk.epam.spring.hometask.domain.User;
import by.barbuk.epam.spring.hometask.service.AuditoriumService;
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



public class TestDiscount extends BaseTest {

    private Event event;
    private User user1, user2;
    private Ticket ticket1, ticket2;

    private EventStorage eventStorage = (EventStorage) context.getBean("eventRepositoryImpl");
    private AuditoriumStorage auditoriumStorage = (AuditoriumStorage) context.getBean("auditoriumRepositoryImpl");
    private UserStorage userStorage = (UserStorage) context.getBean("userRepositoryImpl");
    private TicketStorage ticketStorage = (TicketStorage) context.getBean("ticketRepositoryImpl");
    private DiscountService discountService = (DiscountService) context.getBean("discountServiceImpl");
    private EventService eventService = EventDaoFactory.getEventDAO(StorageEnum.REPOSITORY);
    private AuditoriumService auditoriumService = AuditoriumDaoFactory.getAuditoriumDAO(StorageEnum.REPOSITORY);
    private UserService userService = UserDaoFactory.getUserDAO(StorageEnum.REPOSITORY);
    private TicketService ticketService = TicketDaoFactory.getTicketDAO(StorageEnum.REPOSITORY);


    @BeforeTest
    public void init() {
        final String USER_EMAIL_1 = "Email1@epam.com";
        final String USER_EMAIL_2 = "Email2@epam.com";
        final String EVENT_NAME = "Name1";
        final String AUDITORIUM1_NAME = "Auditorium1";
        final String AIR_DATE_EVENT = "2019-11-18T10:00";
        final String BIRTHDAY = "1985-11-13T08:00";

        event = eventService.getByName(EVENT_NAME);
        LocalDateTime airDate = LocalDateTime.parse(AIR_DATE_EVENT);
        Auditorium auditorium1 = auditoriumService.getByName(AUDITORIUM1_NAME);
        event.addAirDateTime(airDate, auditorium1);

        user1 = userService.getUserByEmail(USER_EMAIL_1);
        user1.setBirthday(LocalDateTime.parse(BIRTHDAY));

        user2 = userService.getUserByEmail(USER_EMAIL_2);

        ticket1 = new Ticket(1L, user1, event, event.getAirDates().first(), 1);
        ticket2 = new Ticket(2L, user2, event, event.getAirDates().first(), 1);
    }

    @Test
    public void testBirthdayDiscount() {
        int discount = discountService.getDiscount(user1, event, ticket1.getDateTime(), 1);

        Assert.assertEquals(5, discount);
    }

    @Test
    public void testRegularCustomerDiscount() {
        int discount = discountService.getDiscount(user2, event, ticket2.getDateTime(), 19);

        Assert.assertEquals(10, discount);
    }
}
