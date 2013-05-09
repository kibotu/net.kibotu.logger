package net.kibotu.logger;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardErrorStreamLog;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for console logger.
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class ConsoleLoggerTest {

    @Rule
    public final StandardOutputStreamLog out = new StandardOutputStreamLog();
    @Rule
    public final StandardErrorStreamLog err = new StandardErrorStreamLog();

    @Test
    public void testDebug () throws Exception {
        new ConsoleLogger().debug( "MyApp", "message" );
        assertEquals( "MyApp" + Logger.Level.DEBUG.TAG + ": message\n", out.getLog() );
    }

    @Test
    public void testVerbose () throws Exception {
        new ConsoleLogger().verbose( "MyApp", "message" );
        assertEquals( "MyApp" + Logger.Level.VERBOSE.TAG + ": message\n", out.getLog() );
    }

    @Test
    public void testInformation () throws Exception {
        new ConsoleLogger().information( "MyApp", "message" );
        assertEquals( "MyApp" + Logger.Level.INFO.TAG + ": message\n", out.getLog() );
    }

    @Test
    public void testWarning () throws Exception {
        new ConsoleLogger().warning( "MyApp", "message" );
        assertEquals( "MyApp" + Logger.Level.WARNING.TAG + ": message\n", out.getLog() );
    }

    @Test
    public void testError () throws Exception {
        new ConsoleLogger().error( "MyApp", "message" );
        assertEquals( "MyApp" + Logger.Level.ERROR.TAG + ": message\n", err.getLog() );
    }
}
