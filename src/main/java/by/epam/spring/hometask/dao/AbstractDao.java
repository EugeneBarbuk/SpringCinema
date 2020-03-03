package by.epam.spring.hometask.dao;

import by.epam.spring.hometask.domain.DomainObject;

import java.util.Collection;

public interface AbstractDao <T extends DomainObject>{

    T add(T object);

    void remove(T object);

    Collection<T> getAll();

    Long getById(Long id);

}
