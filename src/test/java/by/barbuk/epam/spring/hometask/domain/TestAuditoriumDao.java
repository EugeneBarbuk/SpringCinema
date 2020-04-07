package by.barbuk.epam.spring.hometask.domain;

import by.barbuk.epam.spring.hometask.BaseTest;

import by.barbuk.epam.spring.hometask.service.AuditoriumService;
import by.barbuk.epam.spring.hometask.service.implementation.dao.StorageEnum;
import by.barbuk.epam.spring.hometask.service.implementation.dao.auditorium.AuditoriumDaoFactory;
import by.barbuk.epam.spring.hometask.service.implementation.dao.auditorium.AuditoriumStorage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAuditoriumDao extends BaseTest {
    private AuditoriumStorage auditoriumStorage = (AuditoriumStorage) context.getBean("auditoriumRepositoryImpl");
    AuditoriumService auditoriumService = AuditoriumDaoFactory.getAuditoriumDAO(StorageEnum.REPOSITORY);

    @Test
    public void testGetAll() {
        int expectAuditoriumCount = 2;
        Assert.assertEquals(expectAuditoriumCount, auditoriumService.getAll().size());
    }

    @Test
    public void testGetByName() {
        String auditoriumName = "GreenAuditorium";

        Auditorium gottenEvent = auditoriumService.getByName(auditoriumName);
        System.out.println(gottenEvent.getId());
        Assert.assertEquals(auditoriumName, gottenEvent.getName());
    }
}
