package com.bandweaver.maxtunnelem.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
public class SecurityUser implements Serializable {

    private Integer userId;

    private String name;

    private String password;

    private Integer status;

    private Date createTime;
}
