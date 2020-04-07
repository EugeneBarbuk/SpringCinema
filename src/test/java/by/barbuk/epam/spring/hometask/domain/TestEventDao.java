package by.barbuk.epam.spring.hometask.domain;


import by.barbuk.epam.spring.hometask.BaseTest;
import by.barbuk.epam.spring.hometask.domain.Event;
import by.barbuk.epam.spring.hometask.service.EventService;
import by.barbuk.epam.spring.hometask.service.implementation.dao.StorageEnum;
import by.barbuk.epam.spring.hometask.service.implementation.dao.event.EventDaoFactory;
import by.barbuk.epam.spring.hometask.service.implementation.dao.event.EventStorage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestEventDao extends BaseTest {

    private EventStorage eventStorage = (EventStorage) context.getBean("eventRepositoryImpl");
    private Event testEvent = (Event) testDataContext.getBean("testEvent");
    private EventService eventService = EventDaoFactory.getEventDAO(StorageEnum.REPOSITORY);


    @Test
    public void testSave() {
        int eventCount = eventService.getAll().size();
        eventService.save(testEvent);

        Assert.assertEquals(eventCount + 1, eventService.getAll().size());
    }

    @Test
    public void testRemove() {
        int eventCount = eventService.getAll().size();
        Event event = (Event) eventService.getAll().toArray()[0];

        eventService.remove(event);
        Assert.assertEquals(eventCount - 1, eventService.getAll().size());
    }

    @Test
    public void testGetById() {
        Long id = 1L;

        Event randomEvent = (Event) eventService.getAll().toArray()[0];

        Event gottenUser = eventService.getById(id);
        Assert.assertEquals(id, gottenUser.getId());
    }

    @Test
    public void testGetAll() {
        int eventCount = eventService.getAll().size();

        eventService.save(testEvent);
        Assert.assertEquals(eventCount + 1, eventService.getAll().size());
    }

    @Test
    public void testGetByName() {
        String eventName = "Name1";

        Event gottenEvent = eventService.getByName(eventName);
        Assert.assertEquals(eventName, gottenEvent.getName());
    }
}
