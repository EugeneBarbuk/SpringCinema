package by.barbuk.epam.spring.hometask.domain;

import by.barbuk.epam.spring.hometask.BaseTest;
import by.barbuk.epam.spring.hometask.service.UserService;
import by.barbuk.epam.spring.hometask.service.implementation.dao.StorageEnum;
import by.barbuk.epam.spring.hometask.service.implementation.dao.user.UserDaoFactory;
import by.barbuk.epam.spring.hometask.service.implementation.dao.user.UserStorage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestUserDao extends BaseTest {

    private UserStorage userStorage = (UserStorage) context.getBean("userRepositoryImpl");
    private User testUser = (User) testDataContext.getBean("testUser");
    private UserService userService = UserDaoFactory.getUserDAO(StorageEnum.REPOSITORY);


    @Test
    public void testSave() {
        int userCount = userService.getAll().size();

        userService.save(testUser);
        Assert.assertEquals(userCount + 1, userService.getAll().size());
    }

    @Test
    public void testRemove() {
        int userCount = userService.getAll().size();
        User user_2 = userService.getUserByEmail("Email2@epam.com");

        userService.remove(user_2);
        Assert.assertEquals(userCount - 1, userService.getAll().size());
    }

    @Test
    public void testGetById() {
        Long id = 1L;

        User randomUser = (User) userService.getAll().toArray()[0];

        User gottenUser = userService.getById(id);
        Assert.assertEquals(id, gottenUser.getId());
    }

    @Test
    public void testGetAll() {
        int userCount = userService.getAll().size();

        userService.save(testUser);
        Assert.assertEquals(userCount + 1, userService.getAll().size());
    }

    @Test
    public void testGetByEmail() {
        String email = "Email2@epam.com";

        User gottenUser = userService.getUserByEmail(email);
        Assert.assertEquals(email, gottenUser.getEmail());
    }
}
