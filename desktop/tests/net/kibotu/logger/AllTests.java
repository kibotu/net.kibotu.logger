package net.kibotu.logger;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Running all tests.
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ConsoleLoggerTest.class,
        LoggerTest.class,
})
public class AllTests {
}
