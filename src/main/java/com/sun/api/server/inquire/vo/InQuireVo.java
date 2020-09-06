package com.sun.api.server.inquire.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class InQuireVo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String inquireType;
    public String inquireKey;
    public String userName;
    public String userPhone;
    public String userEmail;
    public String inquireText;
}
