package com.stampduty.Stamp.Duty.utils;


import lombok.Getter;
import lombok.Setter;

/**
 * Author: Onochie-okeke Onyekachi S.
 * Email: kachitheegineer@gmail.com
 * Date: 26-05-2022 1:13PM
 */

@Getter
@Setter
public class StampDutyResponseCodes {

    public static Integer SUCCESS_CODE = 200,
            FAILURE_CODE = 404;

    public static String SUCCESS_MESSAGE = "The call was successful",
            FAILURE_MESSAGE = "The call failed";
}

