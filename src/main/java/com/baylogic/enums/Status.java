package com.baylogic.enums;

public enum Status {
	INVALID(1), VALID(2);

    private long status;

    private Status(long status) {
        this.status = status;
    }

    public long getStatus() {
        return status;
    }
}
