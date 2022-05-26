package com.stampduty.Stamp.Duty.utils;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: Onochie-okeke Onyekachi S.
 * Email: kachitheegineer@gmail.com
 * Date: 26-05-2022 1:13PM
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StampDutyResponseEntity {

    private int code;

    private String message;

    private Object body;
}
