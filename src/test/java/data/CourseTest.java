package data;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import services.PublicHolidayService;
import java.time.ZonedDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.when;

public class CourseTest {
    ZonedDateTime start_date = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
    ZonedDateTime end_date = ZonedDateTime.parse("2020-02-01T00:00:00.000+00:00[UTC]");
    private Teatcher teatcher = new Teatcher("Uudo", "Uudishimulik", "Unts", start_date);
    @Mock
    private PublicHolidayService publicHolidayService = new PublicHolidayService();

    @InjectMocks
    private Course course = new Course(1,"Astronoomiline teleportatsioon",teatcher, start_date, end_date, 20);

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void getLengthTest(){
        //given
        long expected_result = 32L;
        //when
        long result = course.getLength();
        //then
        assertEquals(expected_result, result);
    }
    @Test
    public void getLengthReversedInput(){
        //given
        start_date = ZonedDateTime.parse("2020-02-01T00:00:00.000+00:00[UTC]");
        end_date = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
        Course course = new Course(1,"Astronoomiline teleportatsioon",teatcher, start_date, end_date, 20);
        long expecterd_result = -30L;
        //when
        long result = course.getLength();
        //then
        assertEquals(expecterd_result,result);
    }

    @Test
    public void getWorkingDays() {
        //given
        start_date = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
        end_date = ZonedDateTime.parse("2020-02-01T00:00:00.000+00:00[UTC]");
        when(publicHolidayService.getPublicHolidaysOnWorkdays(start_date, end_date)).thenReturn(1);
        long expected_result = 23L;
        //when
        long result = course.getWorkingDays();
        //then
        assertEquals(expected_result,result);
    }

    @Test
    public void getWorkingDaysWrongOrderThrowsIllegalArgumentException() {
        //given
        end_date = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
        start_date = ZonedDateTime.parse("2020-02-01T00:00:00.000+00:00[UTC]");
        when(publicHolidayService.getPublicHolidaysOnWorkdays(start_date, end_date)).thenReturn(1);
        Course course = new Course(1,"Astronoomiline teleportatsioon",teatcher, start_date, end_date, 20);
        String expected_result = "nii ei saa";
        //when
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> course.getWorkingDays());
        //then
        assertEquals(expected_result,exception.getMessage());
    }

}
