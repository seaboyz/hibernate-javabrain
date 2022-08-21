package com.webdev.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "joined_date")
    private Date joinedDate;

    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "user_address", joinColumns = @JoinColumn(name = "user_id"))
    private Collection<Address> listOfAddresses = new ArrayList<Address>();

    public Collection<Address> getListOfAddresses() {
        return this.listOfAddresses;
    }

    public void setListOfAddresses(Collection<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }

    public Date getJoinedDate() {
        return this.joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
