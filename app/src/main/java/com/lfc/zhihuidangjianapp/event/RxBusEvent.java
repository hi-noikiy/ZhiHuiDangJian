package com.lfc.zhihuidangjianapp.event;

/**
 * @author snkso <snkso@foxmail.com>
 */
public class RxBusEvent {
    private int event;
    private Object eventObj;

    public RxBusEvent(int event) {
        this.event = event;
    }

    public RxBusEvent(int event, Object eventObj) {
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
