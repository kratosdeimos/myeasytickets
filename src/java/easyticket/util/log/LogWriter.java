package easyticket.util.log;

import java.io.File;
import org.apache.log4j.*;

public class LogWriter {

    public Logger logger = null;
    boolean bLogToFile = true;
    boolean bLogToConsole = true;
    boolean bLogToSysLog = false;
    // File log properties
    public String logPath = null;
    public String fileName = null;
    int changeLogFlag = LogDef.FILE.CHANGE_ON_DATE;
    protected int maxFileSize = LogDef.FILE.MAX_FILE_SIZE;
    protected int maxFileIndex = LogDef.FILE.MAX_FILE_BACKUP_INDEX;
    public Appender fileAppender = null;
    public Appender consoleAppender = null;
    protected static String csDateTime = null;
    // public Appender syslogAppender = null;
    private String loggerName = "";
    private String syslogHost = "";

    public void initialize(String loggerName, byte level) {
        if (logger == null) {
            logger = Logger.getLogger(loggerName);
            setLogLevel(level);
            this.loggerName = loggerName;
        }
    }

    public void setLogLevel(byte level) {
        if (logger == null) {
            return;
        }
        switch (level) {
            case LogDef.LOG_LEVEL.LOG_ALL:
                logger.setLevel(Level.ALL);
                break;
            case LogDef.LOG_LEVEL.LOG_DEBUG:
                logger.setLevel(Level.DEBUG);
                break;
            case LogDef.LOG_LEVEL.LOG_INFO:
                logger.setLevel(Level.INFO);
                break;
            case LogDef.LOG_LEVEL.LOG_WARNING:
                logger.setLevel(Level.WARN);
                break;
            case LogDef.LOG_LEVEL.LOG_ERROR:
                logger.setLevel(Level.ERROR);
                break;
            case LogDef.LOG_LEVEL.LOG_FATAL:
                logger.setLevel(Level.FATAL);
                break;
            case LogDef.LOG_LEVEL.LOG_OFF:
                logger.setLevel(Level.OFF);
                break;
            default:
                logger.setLevel(Level.ERROR);
                break;
        }
    }

    /**
     *
     * @param filename String : file name
     * @param nChangeFileRule byte : type of rolling.
     * @param nMaxSize int : count in bytes
     * @param nMaxIndex int : number of file to reache before reset index to 0.
     */
    protected void createFileAppender(String filename, byte nChangeFileRule, int nMaxSize, int nMaxIndex) {

        if (fileAppender != null) {
            logger.removeAppender(fileAppender);
        }

        // Valid date log path : must have / at the end
        if (!logPath.endsWith(GeneralDef.OS.fileSeperator)) {
            logPath = logPath + GeneralDef.OS.fileSeperator;
        }

        switch (nChangeFileRule) {
            case LogDef.FILE.CHANGE_ON_SZIE:
                try {
                    fileAppender = new RollingFileAppender(new Layout(), this.logPath + filename + ".log");
                } catch (java.io.IOException ex) {
                    ex.printStackTrace();
                }
                ((RollingFileAppender) fileAppender).setMaximumFileSize(nMaxSize);
                ((RollingFileAppender) fileAppender).setMaxBackupIndex(nMaxIndex);
                ((RollingFileAppender) fileAppender).setImmediateFlush(true);
                break;
            case LogDef.FILE.CHANGE_ON_INDEX:
                try {
                    fileAppender = new RollingFileAppender(new Layout(), logPath + filename + ".log");
                    ((RollingFileAppender) fileAppender).setMaximumFileSize(nMaxSize);
                    ((RollingFileAppender) fileAppender).setMaxBackupIndex(nMaxIndex);
                    ((RollingFileAppender) fileAppender).setImmediateFlush(true);
                } catch (java.io.IOException ex) {
                    ex.printStackTrace();
                }
                break;
            case LogDef.FILE.CHANGE_ON_DATE:
                try {
                    fileAppender = new DailyRollingFileAppender(new Layout(), logPath + filename + ".log", "'.'yyyyMMdd");
                    ((DailyRollingFileAppender) fileAppender).setImmediateFlush(true);
                } catch (java.io.IOException ex) {
                    ex.printStackTrace();
                }
                break;
        }
        logger.addAppender(fileAppender);
    }

    /**
     * create console appender to write to console
     */
    protected void createConsoleAppender() {
        this.logger.setAdditivity(true);
    }

    public void writeLog(String logMessage, byte nLevel) {
        switch (nLevel) {
            case GeneralDef.LOG_LEVEL.LOG_ALL:
                csDateTime = DateFormat.formatTime24();
                logMessage = csDateTime + ": " + logMessage;
                logger.info(logMessage);
                if (bLogToConsole) {
                    System.out.println(logMessage);
                }
                break;
            case GeneralDef.LOG_LEVEL.LOG_DEBUG:
                csDateTime = DateFormat.formatTime24();
                logMessage = csDateTime + ": " + logMessage;
                logger.debug(logMessage);
                if (bLogToConsole) {
                    System.out.println(logMessage);
                }

                break;
            case GeneralDef.LOG_LEVEL.LOG_INFO:
                csDateTime = DateFormat.formatTime24();
                logMessage = csDateTime + ": " + logMessage;
                logger.info(logMessage);
                if (bLogToConsole) {
                    System.out.println(logMessage);
                }
                break;
            case GeneralDef.LOG_LEVEL.LOG_WARNING:
                csDateTime = DateFormat.formatTime24();
                logMessage = csDateTime + ": " + logMessage;
                logger.warn(logMessage);
                if (bLogToConsole) {
                    System.out.println(logMessage);
                }
                break;
            case GeneralDef.LOG_LEVEL.LOG_ERROR:
                csDateTime = DateFormat.formatTime24();
                logMessage = csDateTime + ": " + logMessage;
                logger.error(logMessage);
                if (bLogToConsole) {
                    System.out.println(logMessage);
                }
                break;
            case GeneralDef.LOG_LEVEL.LOG_FATAL:
                csDateTime = DateFormat.formatTime24();
                logMessage = csDateTime + ": " + logMessage;
                logger.fatal(logMessage);
                if (bLogToConsole) {
                    System.out.println(logMessage);
                }
                break;
            case GeneralDef.LOG_LEVEL.LOG_OFF:
                break;
            default:
                logger.setLevel(Level.ERROR);
                break;
        }

    }

    public static void resetLogDefucation() {
        BasicConfigurator.resetConfiguration();
    }

    /**
     * Remove File appender internally
     */
    protected void removeFileAppender() {
        if (this.fileAppender != null) {
            logger.removeAppender(fileAppender);
        }
    }

    /**
     * Remove console appender.
     */
    public void removeConsoleAppender() {
        if (this.consoleAppender != null) {
            logger.removeAppender(consoleAppender);
        }
    }

    public void setFileLogInfo(String filename) {
        File logdir = new File(logPath);
        if (!logdir.exists()) {
            try {
                logdir.mkdirs();
                if (System.getProperty("os.name").equals("Linux")) {
                    Runtime.getRuntime().exec("chmod -R 755 " + logPath);
                }
            } catch (Exception ex) {
                java.util.logging.Logger.getLogger(LogWriter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }
        this.fileName = filename;
    }

    /**
     *
     * @param bActive boolean
     * @param syslogHost String
     * @param nPort int
     */
    public void setSysLogInfo(boolean bActive, String syslogHost, int nPort) {
        this.syslogHost = new String(syslogHost);
        this.bLogToSysLog = bActive;
    }

    /**
     *
     * @param bActive boolean
     */
    public void setConsoleInfo(boolean bActive) {
        this.bLogToConsole = bActive;
    }

    /**
     * Close before destroy this writer object
     */
    public void close() {
        if (this.fileAppender != null) {
            fileAppender.close();
            fileAppender = null;
        }

        if (this.consoleAppender != null) {
            consoleAppender.close();
            consoleAppender = null;
        }

        logger.removeAllAppenders();
    }

    /**
     * Open a logger object to write. Note : must call SetFileInfo...,
     * SetSyslogInfo before call this method.
     */
    public void open() {
        if (this.bLogToConsole) {
            this.createConsoleAppender();
        } else {
            this.logger.setAdditivity(false);
            removeConsoleAppender();
        }
        if (this.bLogToFile) {
            this.createFileAppender(this.loggerName, (byte) this.changeLogFlag, this.maxFileSize, this.maxFileIndex);
        } else {
            this.removeFileAppender();
        }
    }
}
