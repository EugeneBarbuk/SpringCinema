package by.barbuk.epam.spring.hometask.service.implementation.dao.auditorium;

import by.barbuk.epam.spring.hometask.domain.Auditorium;

import java.util.Map;


public class AuditoriumStorage {
    public static Map<Long, Auditorium> auditoriums;

    private AuditoriumStorage(Map<Long, Auditorium> auditoriums) {
        AuditoriumStorage.auditoriums = auditoriums;
    }

    private AuditoriumStorage() {
    }
}
