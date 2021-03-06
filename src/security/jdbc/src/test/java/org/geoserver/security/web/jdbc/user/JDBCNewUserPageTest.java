package org.geoserver.security.web.jdbc.user;

import org.geoserver.security.jdbc.H2RoleServiceTest;
import org.geoserver.security.jdbc.H2UserGroupServiceTest;
import org.geoserver.security.web.user.NewUserPageTest;
import org.junit.Test;

public class JDBCNewUserPageTest extends NewUserPageTest {

    @Override
    protected void doInitialize() throws Exception {
        initializeForJDBC();
    }

    @Test
    public void testFill() throws Exception{
        doTestFill();
    }
    
    @Test
    public void testFill3() throws Exception{
        doTestFill3();
    }

    @Test
    public void testFill2() throws Exception{
        doTestFill2();
    }

    void initializeForJDBC() throws Exception {
        initialize(new H2UserGroupServiceTest(), new H2RoleServiceTest());
    }
    
    @Override
    public String getRoleServiceName() {
        return "h2";
    }

    @Override
    public String getUserGroupServiceName() {
        return "h2";
    }

}
