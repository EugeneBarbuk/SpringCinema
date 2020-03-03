package by.epam.spring.hometask.dao.auditorium;

import by.epam.spring.hometask.dao.AbstractDao;
import by.epam.spring.hometask.domain.Auditorium;

public interface AuditoriumDao extends AbstractDao {
    Auditorium getByName(String name);
}
