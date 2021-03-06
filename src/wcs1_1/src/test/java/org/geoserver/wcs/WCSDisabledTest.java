package org.geoserver.wcs;

import static org.junit.Assert.assertEquals;

import org.geoserver.wcs.test.WCSTestSupport;
import org.junit.Test;
import org.w3c.dom.Document;

public class WCSDisabledTest extends WCSTestSupport {

    @Test
    public void testDisabledServiceResponse() throws Exception {
        WCSInfo wcs = getGeoServer().getService(WCSInfo.class);
        wcs.setEnabled(false);
        getGeoServer().save(wcs);

        Document doc = getAsDOM("wcs?service=WCS&request=getCapabilities");
        assertEquals("ows:ExceptionReport", doc.getDocumentElement().getNodeName());
    }

    @Test
    public void testEnabledServiceResponse() throws Exception {
        WCSInfo wcs = getGeoServer().getService(WCSInfo.class);
        wcs.setEnabled(true);
        getGeoServer().save(wcs);

        Document doc = getAsDOM("wcs?service=WCS&request=getCapabilities");
        assertEquals("wcs:Capabilities", doc.getDocumentElement().getNodeName());
    }
}
