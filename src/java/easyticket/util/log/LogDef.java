package easyticket.util.log;

public class LogDef {

    public static class FILE {

        public static final byte CHANGE_ON_SZIE = 1;
        public static final byte CHANGE_ON_INDEX = 2;
        public static final byte CHANGE_ON_DATE = 3;
        public static final int MAX_FILE_SIZE = 1024 * 1024 * 50; // 50 MB
        public static int MAX_FILE_BACKUP_INDEX = 1000;

    }

    public static class LOG_LEVEL {

        public static final byte LOG_ALL = 0;

        public static final byte LOG_DEBUG = 1;

        public static final byte LOG_INFO = 2;

        public static final byte LOG_WARNING = 3;

        public static final byte LOG_ERROR = 4;

        public static final byte LOG_FATAL = 5;

        public static final byte LOG_OFF = 6;

    }

    public static class SYSLOG {

        public static final int DFLT_PORT = 513;
    }

}
