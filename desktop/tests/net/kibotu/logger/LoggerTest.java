package net.kibotu.logger;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardErrorStreamLog;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import static net.kibotu.logger.Logger.Level.*;
import static net.kibotu.logger.Logger.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for Logger.
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class LoggerTest {

    private static final ConsoleLogger cLogger = new ConsoleLogger();
    private static final String APP_NAME = "MyApp";
    private static final String MESSAGE = "message";
    private static final String LOGGING_TAG = "RandomClass";
    @Rule
    public final StandardOutputStreamLog out = new StandardOutputStreamLog();
    @Rule
    public final StandardErrorStreamLog err = new StandardErrorStreamLog();

    @Before
    public void testInit() throws Exception {
        release();
        init(cLogger, APP_NAME, DEBUG);
        assertTrue(getTag().equals(APP_NAME));
        assertTrue(getLogLevel().equals(DEBUG));
    }

    @Test
    public void testD() throws Exception {
        setLogLevel(DEBUG);
        d(LOGGING_TAG, MESSAGE);
        assertEquals(APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + DEBUG.TAG + ": " + MESSAGE + "\n", out.getLog());
    }

    @Test

    public void testE() throws Exception {
        setLogLevel(ERROR);
        e(LOGGING_TAG, MESSAGE);
        assertEquals(APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + ERROR.TAG + ": " + MESSAGE + "\n", err.getLog());
    }

    @Test
    public void testGetLogLevel() throws Exception {
        assertTrue(DEBUG.equals(getLogLevel()));
    }

    @Test
    public void testSetLogLevel() throws Exception {
        setLogLevel(NO_LOGGING);
        assertEquals(NO_LOGGING, getLogLevel());
        setLogLevel(DEBUG);
        assertEquals(DEBUG, getLogLevel());
    }

    @Test

    public void testI() throws Exception {
        setLogLevel(INFO);
        i(LOGGING_TAG, MESSAGE);
        assertEquals(APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + INFO.TAG + ": " + MESSAGE + "\n", out.getLog());
    }

    @Test
    public void testV() throws Exception {
        setLogLevel(VERBOSE);
        v(LOGGING_TAG, MESSAGE);
        assertEquals(APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + VERBOSE.TAG + ": " + MESSAGE + "\n", out.getLog());
    }

    @Test
    public void testW() throws Exception {
        setLogLevel(WARNING);
        w(LOGGING_TAG, MESSAGE);
        assertEquals(APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + WARNING.TAG + ": " + MESSAGE + "\n", out.getLog());
    }

    @Test
    public void testGetTag() throws Exception {
        assertEquals(getTag(), APP_NAME);
    }

    @Test
    public void testSetTag() throws Exception {
        setTag("YourApp");
        assertEquals(getTag(), "YourApp");
        setTag(APP_NAME);
        assertEquals(getTag(), APP_NAME);
    }

    @Test
    public void testDebugOrder() throws Exception {
        setLogLevel(DEBUG);
        d(LOGGING_TAG, MESSAGE);
        v(LOGGING_TAG, MESSAGE);
        i(LOGGING_TAG, MESSAGE);
        w(LOGGING_TAG, MESSAGE);
        e(LOGGING_TAG, MESSAGE);
        assertEquals(APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + DEBUG.TAG + ": " + MESSAGE + "\n" +
                APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + VERBOSE.TAG + ": " + MESSAGE + "\n" +
                APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + INFO.TAG + ": " + MESSAGE + "\n" +
                APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + WARNING.TAG + ": " + MESSAGE + "\n"
                , out.getLog());
        assertEquals(APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + ERROR.TAG + ": " + MESSAGE + "\n"
                , err.getLog());
    }

    @Test
    public void testVerboseOrder() throws Exception {
        setLogLevel(VERBOSE);
        d(LOGGING_TAG, MESSAGE);
        v(LOGGING_TAG, MESSAGE);
        i(LOGGING_TAG, MESSAGE);
        w(LOGGING_TAG, MESSAGE);
        e(LOGGING_TAG, MESSAGE);
        assertEquals(APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + VERBOSE.TAG + ": " + MESSAGE + "\n" +
                APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + INFO.TAG + ": " + MESSAGE + "\n" +
                APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + WARNING.TAG + ": " + MESSAGE + "\n"
                , out.getLog());
        assertEquals(APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + ERROR.TAG + ": " + MESSAGE + "\n"
                , err.getLog());
    }

    @Test
    public void testInfoOrder() throws Exception {
        setLogLevel(INFO);
        d(LOGGING_TAG, MESSAGE);
        v(LOGGING_TAG, MESSAGE);
        i(LOGGING_TAG, MESSAGE);
        w(LOGGING_TAG, MESSAGE);
        e(LOGGING_TAG, MESSAGE);
        assertEquals(APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + INFO.TAG + ": " + MESSAGE + "\n" +
                APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + WARNING.TAG + ": " + MESSAGE + "\n"
                , out.getLog());
        assertEquals(APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + ERROR.TAG + ": " + MESSAGE + "\n"
                , err.getLog());
    }

    @Test
    public void testWarningOrder() throws Exception {
        setLogLevel(WARNING);
        d(LOGGING_TAG, MESSAGE);
        v(LOGGING_TAG, MESSAGE);
        i(LOGGING_TAG, MESSAGE);
        w(LOGGING_TAG, MESSAGE);
        e(LOGGING_TAG, MESSAGE);
        assertEquals(APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + WARNING.TAG + ": " + MESSAGE + "\n"
                , out.getLog());
        assertEquals(APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + ERROR.TAG + ": " + MESSAGE + "\n"
                , err.getLog());
    }

    @Test
    public void testErrorOrder() throws Exception {
        setLogLevel(ERROR);
        d(LOGGING_TAG, MESSAGE);
        v(LOGGING_TAG, MESSAGE);
        i(LOGGING_TAG, MESSAGE);
        w(LOGGING_TAG, MESSAGE);
        e(LOGGING_TAG, MESSAGE);
        assertEquals(APP_NAME + SEPARATOR + LOGGING_TAG + SEPARATOR + ERROR.TAG + ": " + MESSAGE + "\n"
                , err.getLog());
    }

    @Test
    public void testNoLogginOrder() throws Exception {
        setLogLevel(NO_LOGGING);
        d(LOGGING_TAG, MESSAGE);
        v(LOGGING_TAG, MESSAGE);
        i(LOGGING_TAG, MESSAGE);
        w(LOGGING_TAG, MESSAGE);
        e(LOGGING_TAG, MESSAGE);
        assertEquals("", out.getLog());
        assertEquals("", err.getLog());
    }
}
