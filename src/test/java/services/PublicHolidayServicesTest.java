package services;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.json.JSONException;
import org.junit.Rule;
import org.junit.Test;
import java.time.ZonedDateTime;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.Assert.assertEquals;


public class PublicHolidayServicesTest {

    ZonedDateTime start_date = ZonedDateTime.parse("2020-01-01T00:00:00.000+00:00[UTC]");
    ZonedDateTime end_date = ZonedDateTime.parse("2020-02-01T00:00:00.000+00:00[UTC]");

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(); // No-args constructor defaults to port 8080
    PublicHolidayService publicHolidayService = new PublicHolidayService("http://localhost");

    @Test(expected = JSONException.class)
    public void invalidJsonTest() throws Exception{

        //given
        stubFor(any(anyUrl())
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("<response>Some content</response>")));
        //when
        List<ZonedDateTime> result = publicHolidayService.getPublicHolidays("2020");
        //then
        verify(getRequestedFor(urlEqualTo("/2020/EE")));
    }
    @Test
    public void processApiResponse() throws Exception{

        //given
        stubFor(any(anyUrl())
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("[{\"date\":\"2020-12-26\",\"localName\":\"teine jõulupüha\",\"name\":\"St. Stephen's Day\",\"countryCode\":\"EE\",\"fixed\":true,\"global\":true,\"counties\":null,\"launchYear\":null,\"type\":\"Public\"}]")));
        //when
        List<ZonedDateTime> result = publicHolidayService.getPublicHolidays("2020");
        //then
        assertEquals(1,result.size());
        assertEquals(ZonedDateTime.parse("2020-12-26T00:00:00.000+00:00[UTC]"), result.get(0));
        verify(getRequestedFor(urlEqualTo("/2020/EE")));
    }



}
