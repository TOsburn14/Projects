package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao dao;
    private Timesheet testTimesheet;

    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
        testTimesheet = new Timesheet(0, 1, 1,
                LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet Test Timesheet");

    }

    @Test
    public void getTimesheetById_returns_correct_timesheet_for_id() {
        Timesheet timesheetReturned = dao.getTimesheetById(1);
        Assert.assertEquals(TIMESHEET_1,timesheetReturned);
    }

    @Test
    public void getTimesheetById_returns_null_when_id_not_found() {
        Timesheet timesheetReturn = dao.getTimesheetById(99);
        Assert.assertNull(timesheetReturn);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        List<Timesheet> timesheets = dao.getTimesheetsByEmployeeId(1);
        Assert.assertEquals(2,timesheets.size());
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {
        List<Timesheet> timesheets = dao.getTimesheetsByProjectId(1);
        Assert.assertEquals(3,timesheets.size());
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {
        Timesheet createdTimesheet = dao.createTimesheet(testTimesheet);
        int newTimesheet = createdTimesheet.getTimesheetId();
        Assert.assertTrue(newTimesheet > 0);

        Timesheet retrievedTimesheet = dao.getTimesheetById(newTimesheet);
        Assert.assertEquals(createdTimesheet,retrievedTimesheet);
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        Timesheet timesheetToUpdate = dao.getTimesheetById(1);

        timesheetToUpdate.setEmployeeId(1);
        timesheetToUpdate.setProjectId(1);
        timesheetToUpdate.setBillable(true);
        timesheetToUpdate.setDateWorked(LocalDate.now());
        timesheetToUpdate.setDescription("Hard Worker");
        timesheetToUpdate.setHoursWorked(8);

        dao.updateTimesheet(timesheetToUpdate);
        Timesheet updatedTimesheet = dao.getTimesheetById(1);

        Assert.assertEquals(timesheetToUpdate,updatedTimesheet);
    }

    @Test
    public void deleted_timesheet_can_no_longer_be_retrieved() {
        dao.deleteTimesheetById(1);
        Assert.assertNull(dao.getTimesheetById(1));
    }

    @Test
    public void getBillableHours_returns_correct_total() {
        double returnedTimesheet = dao.getBillableHours(2,2);
        Assert.assertEquals(0.00,returnedTimesheet,.009);
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
