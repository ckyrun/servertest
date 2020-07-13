package org.exite.servertest;

import org.apache.log4j.Logger;

public class Config {
    private static final Logger log = Logger.getLogger(Config.class);

    public static String DB_URL;
    public static String DB_USER;
    public static String DB_PASS;

    public static void loadConfig() {
        try{
            DB_URL = getEnvVar("DB_URL");
            DB_USER = getEnvVar("DB_USER");
            DB_PASS = getEnvVar("DB_PASS");
        } catch (Exception e) {
            log.fatal(e);
            System.exit(1);
        }
    }

    private static String getEnvVar(final String varName) {
        final String val = System.getenv(varName);
        if(val == null){
            log.fatal("Не заполнена переменная окружения для базы данных " + varName);
        }
        return val;
    }

}
