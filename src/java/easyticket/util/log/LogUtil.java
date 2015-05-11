/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyticket.util.log;

/**
 *
 * @author Administrator
 */
public class LogUtil extends LogWriter {

    public static String logPath = "";
    public String fileName = "";
    private static LogUtil instance;

    public static LogUtil getInstance(String fileName) {
        if (fileName == null || fileName.equals("")) {
            getInstance();
        }
        if (instance == null) {
            synchronized (LogUtil.class) {
                instance = new LogUtil();
            }
        }
        instance.fileName = fileName;
        return instance;
    }

    public static LogUtil getInstance() {
        return getInstance("console");
    }

    public void log(String message) {
        log(message, LogDef.LOG_LEVEL.LOG_INFO);
    }

    public void error(String message) {
        log(message, LogDef.LOG_LEVEL.LOG_ERROR);
    }

    private void log(String message, byte level) {
        synchronized (LogUtil.class) {
            try {
                super.logPath = this.logPath;
                initialize("console", level);
                setFileLogInfo("console");
                open();
                writeLog(message, level);
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                close();
            }
        }
    }

    public void error(Exception ex) {
        synchronized (LogUtil.class) {
            try {
                super.logPath = this.logPath;
                initialize("console", LogDef.LOG_LEVEL.LOG_ERROR);
                setFileLogInfo("console");
                open();
                String sysdate = DateFormat.formatTime24() + ": ";
                logger.error(sysdate, ex);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }
    }
}
