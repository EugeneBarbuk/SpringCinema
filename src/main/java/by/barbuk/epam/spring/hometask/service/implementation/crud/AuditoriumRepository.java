package by.barbuk.epam.spring.hometask.service.implementation.crud;

import by.barbuk.epam.spring.hometask.domain.Auditorium;
import org.springframework.data.repository.CrudRepository;
// TODO rework storage from repository to DB and implement CrudRepository
public interface AuditoriumRepository  extends CrudRepository<Auditorium, Long> {
    Auditorium findByName(String name);
}
