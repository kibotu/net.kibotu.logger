package net.kibotu.logger.android;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import net.kibotu.logger.ILogger;
import org.jetbrains.annotations.NotNull;

import static net.kibotu.logger.Logger.Level.*;

/**
 * TODO insert description
 *
 * @author <a href="mailto:jan.rabe@wooga.net">Jan Rabe</a>
 */
public class LogcatLogger implements ILogger {

    private Context context;

    public LogcatLogger(@NotNull final Context context) {
        this.context = context;
    }

    @Override
    public void debug(final String tag, final String message) {
        Log.d(tag + DEBUG.TAG, message);
    }

    @Override
    public void verbose(final String tag, final String message) {
        Log.d(tag + VERBOSE.TAG, message);
    }

    @Override
    public void information(final String tag, final String message) {
        Log.d(tag + INFO.TAG, message);
    }

    @Override
    public void warning(final String tag, final String message) {
        Log.d(tag + WARNING.TAG, message);
    }

    @Override
    public void error(final String tag, final String message) {
        Log.d(tag + ERROR.TAG, message);
    }

    @Override
    public void toast(final String message) {
        if (context == null) {
            Log.e(ERROR.TAG, "No context defined!");
            return;
        }
        ((Activity) context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
