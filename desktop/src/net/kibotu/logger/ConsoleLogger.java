package net.kibotu.logger;

import org.jetbrains.annotations.NotNull;

/**
 * Concrete console logger.
 */
public class ConsoleLogger implements ILogger {

    /**
     * Formatting output string.
     */
    private static final String FORMATTER = "%s%s: %s\n";

    public ConsoleLogger () {
    }

    @Override
    public void debug ( @NotNull final String tag, @NotNull final String message ) {
        System.out.printf( FORMATTER, tag, Logger.Level.DEBUG.name(), message );
    }

    @Override
    public void verbose ( final String tag, final String message ) {
        System.out.printf( FORMATTER, tag, Logger.Level.VERBOSE.name(), message );
    }

    @Override
    public void information ( final String tag, final String message ) {
        System.out.printf( FORMATTER, tag, Logger.Level.INFO.name(), message );
    }

    @Override
    public void warning ( final String tag, final String message ) {
        System.out.printf( FORMATTER, tag, Logger.Level.WARNING.name(), message );
    }

    @Override
    public void error ( final String tag, final String message ) {
        System.err.printf( FORMATTER, tag, Logger.Level.ERROR.name(), message );
    }
}
