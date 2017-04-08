package com.microsoft.hsg.android.simplexml;

import org.apache.log4j.Level;

import de.mindpipe.android.logging.log4j.LogConfigurator;

public class ConfigureLog4J {
    public static void configure() {
        final LogConfigurator logConfigurator = new LogConfigurator();
        logConfigurator.setUseFileAppender(false);
        logConfigurator.setRootLevel(Level.DEBUG);
        logConfigurator.setLevel("org.apache", Level.ERROR);
        logConfigurator.configure();
    }
}
