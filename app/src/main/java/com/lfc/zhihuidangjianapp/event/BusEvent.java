package com.lfc.zhihuidangjianapp.event;

/**
 * @author snkso <snkso@foxmail.com>
 */
public class BusEvent {
    private int event;
    private Object eventObj;

    public BusEvent(int event) {
        this.event = event;
    }

    public BusEvent(int event, Object eventObj) {
        this.event = event;
        this.eventObj = eventObj;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public Object getEventObj() {
        return eventObj;
    }

    public void setEventObj(Object eventObj) {
        this.eventObj = eventObj;
    }
}
