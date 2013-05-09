net.kibotu.logger
=================

Logging adapter for android projects. Access to same logger interface through out your cross plattform application.

1) init the logger with a concrete logger.

2) static access everywhere with 
	- Logger.d("debug message"); 
	- Logger.v("verbose message");
	- Logger.i("informational message");
	- Logger.w("warning message");
	- Logger.e("error message");
	
3) release: Logger.setLogLevel(Logger.Level.NoLogging);

1.1) init on desktop:
public class Main {

	public static void main(String [] args) {
		Logger.init(new ConsoleLogger(), "MyApp",  Logger.Level.DEBUG);
	}
}

1.2) init on android:
public class MainActivity extends Activity {

	...
	
	@Override
    public void onStart() {
        super.onStart();
		Logger.init( new LogcatLogger(), "MyApp", Logger.Level.DEBUG);
	}
	
	...
}

1.3) init on libgdx android project:

public class MainActivity extends AndroidApplication {

	...
	
	@Override
    public void onStart() {
        super.onStart();
		Logger.init( new GdxLogger(), "MyApp", Logger.Level.DEBUG);
	}
	
	...
}

Log Level order:

DEBUG < VERBOSE < INFO < WARNING < ERROR < NO_LOGGING

