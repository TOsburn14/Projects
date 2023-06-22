package com.techelevator.dao;

import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);
    private Park testPark;
    private JdbcParkDao sut;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
        testPark = new Park(0,"Test Park",LocalDate.now(),0,false);
    }

    @Test
    public void getParkById_returns_correct_park() {
        Park parkReturned = sut.getParkById(1);
        Assert.assertEquals(PARK_1,parkReturned);

        parkReturned = sut.getParkById(3);
        Assert.assertEquals(PARK_3,parkReturned);
    }

    @Test
    public void getParkById_returns_null_when_id_not_found() {
        Park parkReturned = sut.getParkById(99);
        Assert.assertNull(parkReturned);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        List<Park> parks = sut.getParksByState("AA");
        Assert.assertEquals(2,parks.size());
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        List<Park> parks = sut.getParksByState("XX");
        Assert.assertEquals(0,parks.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        Park createdPark = sut.createPark(testPark);

        int newPark = createdPark.getParkId();
        Assert.assertTrue(newPark > 0);

        Park retrievedPark = sut.getParkById(newPark);
        Assert.assertEquals(createdPark,retrievedPark);
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        Park parkToUpdate = sut.getParkById(1);

        parkToUpdate.setParkName("Updated");
        parkToUpdate.setDateEstablished(LocalDate.now());
        parkToUpdate.setArea(999);
        parkToUpdate.setHasCamping(false);

        sut.updatePark( parkToUpdate );
        Park updatedPark = sut.getParkById(1);

        Assert.assertEquals(parkToUpdate,updatedPark);
    }

    @Test
    public void deleted_park_cant_be_retrieved() {
        sut.deleteParkById(1);

        Assert.assertNull(sut.getParkById(1));
    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
        sut.linkParkState(2,"CC");
        List<Park> parksReturned = sut.getParksByState("CC");
        Assert.assertEquals(2,parksReturned.size());
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        sut.unlinkParkState(1,"AA");
        List<Park> parksReturned = sut.getParksByState("AA");
        Assert.assertEquals(1,parksReturned.size());
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
