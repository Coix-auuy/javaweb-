package pers.auuy.test;

import org.junit.Test;
import pers.auuy.utils.JdbcUtils;

import java.sql.Connection;

public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils() {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);

    }
}
