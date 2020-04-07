package by.barbuk.epam.spring.hometask.domain;


import by.barbuk.epam.spring.hometask.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestEvent extends BaseTest {

	private Event testEvent = (Event) context.getBean("summerParty");
	private Auditorium testAuditorium = (Auditorium) context.getBean("greenAuditorium");


	@BeforeTest
	public void initEvent() {
		LocalDateTime now = LocalDateTime.now();

		testEvent.addAirDateTime(now);
		testEvent.addAirDateTime(now.plusDays(1));
		testEvent.addAirDateTime(now.plusDays(2));
	}

	@Test
	public void testAddRemoveAirDates() {
        SoftAssert softAssert = new SoftAssert();
		int size = testEvent.getAirDates().size();
		LocalDateTime date = LocalDateTime.now().plusDays(5);

		testEvent.addAirDateTime(date);
        softAssert.assertEquals(size + 1, testEvent.getAirDates().size());
        softAssert.assertTrue(testEvent.getAirDates().contains(date));

		testEvent.removeAirDateTime(date);
        softAssert.assertEquals(size, testEvent.getAirDates().size());
        softAssert.assertFalse(testEvent.getAirDates().contains(date));
        softAssert.assertAll();
	}

	@Test
	public void testCheckAirDates() {
        SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(testEvent.airsOnDate(LocalDate.now()));
		softAssert.assertTrue(testEvent.airsOnDate(LocalDate.now().plusDays(1)));
		softAssert.assertFalse(testEvent.airsOnDate(LocalDate.now().minusDays(10)));

		softAssert.assertTrue(testEvent.airsOnDates(LocalDate.now().atStartOfDay(), LocalDate.now().plusDays(10).atStartOfDay()));
		softAssert.assertTrue(testEvent.airsOnDates(LocalDate.now().minusDays(10).atStartOfDay(), LocalDate.now().plusDays(10).atStartOfDay()));
		softAssert.assertTrue(testEvent.airsOnDates(LocalDate.now().plusDays(1).atStartOfDay(), LocalDate.now().plusDays(2).atStartOfDay()));
		softAssert.assertFalse(testEvent.airsOnDates(LocalDate.now().minusDays(10).atStartOfDay(), LocalDate.now().minusDays(5).atStartOfDay()));

		LocalDateTime time = LocalDateTime.now().plusHours(4);
		testEvent.addAirDateTime(time);
        softAssert.assertTrue(testEvent.airsOnDateTime(time));

		time = time.plusHours(30);
        softAssert.assertFalse(testEvent.airsOnDateTime(time));
        softAssert.assertAll();
	}

	@Test
	public void testAddRemoveAuditoriums() {
        SoftAssert softAssert = new SoftAssert();
		LocalDateTime time = testEvent.getAirDates().first();

        softAssert.assertTrue(testEvent.getAuditoriums().isEmpty());

		testEvent.assignAuditorium(time, testAuditorium);
        softAssert.assertFalse(testEvent.getAuditoriums().isEmpty());

		testEvent.removeAuditoriumAssignment(time);
        softAssert.assertTrue(testEvent.getAuditoriums().isEmpty());
        softAssert.assertAll();
	}

	@Test
	public void testAddRemoveAuditoriumsWithAirDates() {
		SoftAssert softAssert = new SoftAssert();

		LocalDateTime time = LocalDateTime.now().plusDays(10);

		softAssert.assertTrue(testEvent.getAuditoriums().isEmpty());

		testEvent.addAirDateTime(time, testAuditorium);
		softAssert.assertFalse(testEvent.getAuditoriums().isEmpty());

		testEvent.removeAirDateTime(time);
		softAssert.assertTrue(testEvent.getAuditoriums().isEmpty());
		softAssert.assertAll();
	}

	@Test
	public void testNotAddAuditoriumWithoutCorrectDate() {
		SoftAssert softAssert = new SoftAssert();
		LocalDateTime time = LocalDateTime.now().plusDays(10);

		boolean result = testEvent.assignAuditorium(time, testAuditorium);
		softAssert.assertFalse(result);
		softAssert.assertTrue(testEvent.getAuditoriums().isEmpty());

		result = testEvent.removeAirDateTime(time);
		softAssert.assertFalse(result);
		softAssert.assertTrue(testEvent.getAuditoriums().isEmpty());
		softAssert.assertAll();
	}
}
