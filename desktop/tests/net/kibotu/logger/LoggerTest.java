package net.kibotu.logger;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardErrorStreamLog;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for Logger.
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class LoggerTest {

    private static final ConsoleLogger cLogger = new ConsoleLogger();
    @Rule
    public final StandardOutputStreamLog out = new StandardOutputStreamLog();
    @Rule
    public final StandardErrorStreamLog err = new StandardErrorStreamLog();

    @Before
    public void testInit () throws Exception {
        Logger.release();
        Logger.init( cLogger, "MyApp", Logger.Level.DEBUG );
        assertTrue( Logger.getTag().equals( "MyApp" ) );
        assertTrue( Logger.getLogLevel().equals( Logger.Level.DEBUG ) );
    }

    @Test
    public void testD () throws Exception {
        Logger.setLogLevel( Logger.Level.DEBUG );
        Logger.d( "message" );
        assertEquals( "MyApp" + Logger.Level.DEBUG.name() + ": message\n", out.getLog() );
    }

    @Test

    public void testE () throws Exception {
        Logger.setLogLevel( Logger.Level.ERROR );
        Logger.e( "message" );
        assertEquals( "MyApp" + Logger.Level.ERROR.name() + ": message\n", err.getLog() );
    }

    @Test
    public void testGetLogLevel () throws Exception {
        assertTrue( Logger.Level.DEBUG.equals( Logger.getLogLevel() ) );
    }

    @Test
    public void testSetLogLevel () throws Exception {
        Logger.setLogLevel( Logger.Level.NO_LOGGING );
        assertEquals( Logger.Level.NO_LOGGING, Logger.getLogLevel() );
        Logger.setLogLevel( Logger.Level.DEBUG );
        assertEquals( Logger.Level.DEBUG, Logger.getLogLevel() );
    }

    @Test

    public void testI () throws Exception {
        Logger.setLogLevel( Logger.Level.INFO );
        Logger.i( "message" );
        assertEquals( "MyApp" + Logger.Level.INFO.name() + ": message\n", out.getLog() );
    }

    @Test
    public void testV () throws Exception {
        Logger.setLogLevel( Logger.Level.VERBOSE );
        Logger.v( "message" );
        assertEquals( "MyApp" + Logger.Level.VERBOSE.name() + ": message\n", out.getLog() );
    }

    @Test
    public void testW () throws Exception {
        Logger.setLogLevel( Logger.Level.WARNING );
        Logger.w( "message" );
        assertEquals( "MyApp" + Logger.Level.WARNING.name() + ": message\n", out.getLog() );
    }

    @Test
    public void testGetTag () throws Exception {
        assertEquals( Logger.getTag(), "MyApp" );
    }

    @Test
    public void testSetTag () throws Exception {
        Logger.setTag( "YourApp" );
        assertEquals( Logger.getTag(), "YourApp" );
        Logger.setTag( "MyApp" );
        assertEquals( Logger.getTag(), "MyApp" );
    }

    @Test
    public void testDebugOrder () throws Exception {
        Logger.setLogLevel( Logger.Level.DEBUG );
        Logger.d( "message" );
        Logger.v( "message" );
        Logger.i( "message" );
        Logger.w( "message" );
        Logger.e( "message" );
        assertEquals( "MyApp" + Logger.Level.DEBUG.name() + ": message\n" +
                "MyApp" + Logger.Level.VERBOSE.name() + ": message\n" +
                "MyApp" + Logger.Level.INFO.name() + ": message\n" +
                "MyApp" + Logger.Level.WARNING.name() + ": message\n"
                , out.getLog() );
        assertEquals( "MyApp" + Logger.Level.ERROR.name() + ": message\n"
                , err.getLog() );
    }

    @Test
    public void testVerboseOrder () throws Exception {
        Logger.setLogLevel( Logger.Level.VERBOSE );
        Logger.d( "message" );
        Logger.v( "message" );
        Logger.i( "message" );
        Logger.w( "message" );
        Logger.e( "message" );
        assertEquals( "MyApp" + Logger.Level.VERBOSE.name() + ": message\n" +
                "MyApp" + Logger.Level.INFO.name() + ": message\n" +
                "MyApp" + Logger.Level.WARNING.name() + ": message\n"
                , out.getLog() );
        assertEquals( "MyApp" + Logger.Level.ERROR.name() + ": message\n"
                , err.getLog() );
    }

    @Test
    public void testInfoOrder () throws Exception {
        Logger.setLogLevel( Logger.Level.INFO );
        Logger.d( "message" );
        Logger.v( "message" );
        Logger.i( "message" );
        Logger.w( "message" );
        Logger.e( "message" );
        assertEquals( "MyApp" + Logger.Level.INFO.name() + ": message\n" +
                "MyApp" + Logger.Level.WARNING.name() + ": message\n"
                , out.getLog() );
        assertEquals( "MyApp" + Logger.Level.ERROR.name() + ": message\n"
                , err.getLog() );
    }

    @Test
    public void testWarningOrder () throws Exception {
        Logger.setLogLevel( Logger.Level.WARNING );
        Logger.d( "message" );
        Logger.v( "message" );
        Logger.i( "message" );
        Logger.w( "message" );
        Logger.e( "message" );
        assertEquals( "MyApp" + Logger.Level.WARNING.name() + ": message\n"
                , out.getLog() );
        assertEquals( "MyApp" + Logger.Level.ERROR.name() + ": message\n"
                , err.getLog() );
    }

    @Test
    public void testErrorOrder () throws Exception {
        Logger.setLogLevel( Logger.Level.ERROR );
        Logger.d( "message" );
        Logger.v( "message" );
        Logger.i( "message" );
        Logger.w( "message" );
        Logger.e( "message" );
        assertEquals( "MyApp" + Logger.Level.ERROR.name() + ": message\n"
                , err.getLog() );
    }

    @Test
    public void testNoLogginOrder () throws Exception {
        Logger.setLogLevel( Logger.Level.NO_LOGGING );
        Logger.d( "message" );
        Logger.v( "message" );
        Logger.i( "message" );
        Logger.w( "message" );
        Logger.e( "message" );
        assertEquals( "", out.getLog() );
    }
}
