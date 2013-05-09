package net.kibotu.logger.android;

import android.util.Log;
import net.kibotu.logger.ILogger;
import org.jetbrains.annotations.NotNull;

import static net.kibotu.logger.Logger.Level.*;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class LogcatLogger implements ILogger {

    public LogcatLogger () {
    }

    @Override
    public void debug ( @NotNull final String tag, @NotNull final String message ) {
        Log.d( tag + DEBUG.name(), message );
    }

    @Override
    public void verbose ( final String tag, final String message ) {
        Log.d( tag + VERBOSE.name(), message );
    }

    @Override
    public void information ( final String tag, final String message ) {
        Log.d( tag + INFO.name(), message );
    }

    @Override
    public void warning ( final String tag, final String message ) {
        Log.d( tag + WARNING.name(), message );
    }

    @Override
    public void error ( final String tag, final String message ) {
        Log.d( tag + ERROR.name(), message );
    }
}
