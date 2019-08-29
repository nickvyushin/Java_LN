package ru.stqa.ln.soap;

import com.lavasoft.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoIpServiceTests {

    @Test
    public void testMyIp() {
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("78.106.40.191");
        Assert.assertEquals(ipLocation, "<GeoIP><Country>RU</Country><State>67</State></GeoIP>");
    }

    @Test
    public void testInvalidIp() {
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("78.106.40.xxx");
        Assert.assertEquals(ipLocation, "<GeoIP><Country>RU</Country><State>67</State></GeoIP>");
    }
}
