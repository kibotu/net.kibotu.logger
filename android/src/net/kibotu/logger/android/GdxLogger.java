package net.kibotu.logger.android;

import com.badlogic.gdx.Gdx;
import net.kibotu.logger.ILogger;

import static net.kibotu.logger.Logger.Level.*;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class GdxLogger implements ILogger {

    @Override
    public void debug(final String tag, final String message) {
        Gdx.app.log( tag + DEBUG.name(), message );
    }

    @Override
    public void verbose(final String tag, final String message) {
        Gdx.app.log( tag + VERBOSE.name(), message );
    }

    @Override
    public void information(final String tag, final String message) {
        Gdx.app.log( tag + INFO.name(), message );
    }

    @Override
    public void warning(final String tag, final String message) {
        Gdx.app.log( tag + WARNING.name(), message );
    }

    @Override
    public void error(final String tag, final String message) {
        Gdx.app.error( tag + ERROR.name(), message );
    }
}
