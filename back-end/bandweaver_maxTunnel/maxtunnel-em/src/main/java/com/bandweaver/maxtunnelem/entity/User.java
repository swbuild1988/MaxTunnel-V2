package com.bandweaver.maxtunnelem.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
public class User implements Serializable {

    private static final long serialVersionUID = -543758473614180158L;

    private Integer id;

    private String name;

    private String password;

    private Date crtTime;

}
