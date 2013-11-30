package net.kibotu.logger.android;

import net.kibotu.logger.Logger;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardErrorStreamLog;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import static junit.framework.Assert.assertEquals;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class LogcatLoggerTest {

    private static final LogcatLogger logger = new LogcatLogger(null);
    @Rule
    public final StandardOutputStreamLog out = new StandardOutputStreamLog();
    @Rule
    public final StandardErrorStreamLog err = new StandardErrorStreamLog();

    @Test
    public void testDebug () throws Exception {
        logger.debug( "MyApp", "message" );
        assertEquals( "MyApp" + Logger.Level.DEBUG.name() + ": message\n", out.getLog() );
    }

    @Test
    public void testVerbose () throws Exception {
        logger.verbose( "MyApp", "message" );
        assertEquals( "MyApp" + Logger.Level.VERBOSE.name() + ": message\n", out.getLog() );
    }

    @Test
    public void testInformation () throws Exception {
        logger.information( "MyApp", "message" );
        assertEquals( "MyApp" + Logger.Level.INFO.name() + ": message\n", out.getLog() );
    }

    @Test
    public void testWarning () throws Exception {
        logger.warning( "MyApp", "message" );
        assertEquals( "MyApp" + Logger.Level.WARNING.name() + ": message\n", out.getLog() );
    }

    @Test
    public void testError () throws Exception {
        logger.error( "MyApp", "message" );
        assertEquals( "MyApp" + Logger.Level.ERROR.name() + ": message\n", err.getLog() );
    }
}
