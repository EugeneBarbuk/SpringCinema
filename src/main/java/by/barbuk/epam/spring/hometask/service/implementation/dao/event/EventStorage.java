package by.barbuk.epam.spring.hometask.service.implementation.dao.event;

import by.barbuk.epam.spring.hometask.domain.Event;

import java.util.Map;

public class EventStorage {
    public static Map<Long, Event> events;

    private EventStorage(Map<Long, Event> events) {
        EventStorage.events = events;
    }

    private EventStorage() {
    }
}
