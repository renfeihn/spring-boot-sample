package cn.kiiwii.framework.mybatis.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class Account implements Serializable {

    private int id;
    private String name;
    private double money;
    private String flag;

    public Account() {
        super();
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", name=" + name + ", money=" + money + ", flag=" + flag
                + "]";
    }
}
