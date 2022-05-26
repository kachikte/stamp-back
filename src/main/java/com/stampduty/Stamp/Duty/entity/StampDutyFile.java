package com.stampduty.Stamp.Duty.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Author: Onochie-okeke Onyekachi S.
 * Email: kachitheegineer@gmail.com
 * Date: 26-05-2022 1:28AM
 */

@Entity
@Table(name = "stampDutyCertificates")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StampDutyFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private long fileSize;

    private String fileType;

    @Lob
    private byte[] data;

    public StampDutyFile(String fileName, long fileSize, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileType = fileType;
        this.data = data;
    }
}
