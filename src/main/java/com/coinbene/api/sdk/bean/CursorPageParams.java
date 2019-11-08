package com.coinbene.api.sdk.bean;

/**
 * Cursor pagination   <br/>
 */
public class CursorPageParams {
    /**
     * Request page before (newer) this pagination id.
     * eg: from=2, page number = 1.
     */
    protected int from;
    /**
     * Request page after (older) this pagination id.
     * eg: to=2, page number = 3.
     */
    protected int to;
    /**
     * Number of results per request. Maximum 100. (default 100)
     */
    protected int limit;

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
