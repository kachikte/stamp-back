package com.stampduty.Stamp.Duty.exceptions;

public class StampDutyFileException extends RuntimeException {
    public StampDutyFileException(String message) {
        super(message);
    }

    public StampDutyFileException(String message, Throwable cause) {
        super(message, cause);
    }
}
