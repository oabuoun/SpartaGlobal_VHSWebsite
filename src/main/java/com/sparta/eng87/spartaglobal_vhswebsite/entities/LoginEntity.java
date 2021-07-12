package com.sparta.eng87.spartaglobal_vhswebsite.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity
@SequenceGenerator(name="sequence1", initialValue=600, allocationSize = 1)
public class LoginEntity {

    @Id
    @GeneratedValue
    private Integer userId;

    private String userName;
    private String userPassword;
    private String userRole;
    private Integer userActivated;


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    //@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq")
    //@OneToOne
    private Short customer_id;
    private Integer staff_id;








    public LoginEntity(String userName, String userPassword, String userRole, Integer userActivated, Short customer_id, Integer staff_id) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.userActivated = userActivated;
        this.customer_id = customer_id;
        this.staff_id = staff_id;

    }


    public LoginEntity() {
    }


    public Integer getStaff_id() {
        return staff_id;
    }
    public Short getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Short customer_id) {
        this.customer_id = customer_id;
    }

    public void setStaff_id(Integer staff_id) {
        this.staff_id = staff_id;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Integer getUserActivated() {
        return userActivated;
    }

    public void setUserActivated(Integer userActivated) {
        this.userActivated = userActivated;
    }
}
