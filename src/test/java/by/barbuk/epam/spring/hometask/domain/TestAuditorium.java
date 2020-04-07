package by.barbuk.epam.spring.hometask.domain;

import by.barbuk.epam.spring.hometask.BaseTest;
import by.barbuk.epam.spring.hometask.domain.Auditorium;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class TestAuditorium extends BaseTest {

    private Auditorium testAuditorium = (Auditorium) testDataContext.getBean("testAuditorium");


	@Test
	public void testCountVips() {
        SoftAssert softAssert = new SoftAssert();
        testAuditorium.setVipSeats(Stream.of(1L, 2L, 3L).collect(Collectors.toSet()));
        softAssert.assertEquals(0, testAuditorium.countVipSeats(Arrays.asList(10L, 20L, 30L)));
        softAssert.assertEquals(1, testAuditorium.countVipSeats(Arrays.asList(10L, 2L, 30L)));
        softAssert.assertEquals(2, testAuditorium.countVipSeats(Arrays.asList(10L, 2L, 3L, 4L, 5L, 6L)));
        softAssert.assertAll();
    }

    @Test
	public void testGetAllSeats() {
        testAuditorium.setNumberOfSeats(10);
        Assert.assertEquals(10, testAuditorium.getAllSeats().size());
	}

}
