/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyticket.util.log;

import org.apache.log4j.spi.LoggingEvent;

/**
 *
 * @author Administrator
 */
public class Layout extends org.apache.log4j.Layout {

    StringBuffer stringBuffer;

    public Layout() {
        stringBuffer = new StringBuffer(128);
    }

    @Override
    public void activateOptions() {
    }

    @Override
    public String format(LoggingEvent event) {
        stringBuffer.setLength(0);
        stringBuffer.append(event.getRenderedMessage());
        stringBuffer.append(Layout.LINE_SEP);
        return stringBuffer.toString();
    }

    @Override
    public boolean ignoresThrowable() {
        return true;
    }

}
