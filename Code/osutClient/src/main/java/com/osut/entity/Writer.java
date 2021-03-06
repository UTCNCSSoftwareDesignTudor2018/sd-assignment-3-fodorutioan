package com.osut.entity;

import java.util.Objects;

public class Writer {

    private Long id;
    private String name;
    private String address;
    private String email;
    private String username;
    private String password;
//
//    public Writer(Long id, String name, String address, String email, String username, String password) {
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.email = email;
//        this.username = username;
//        this.password = password;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Writer{" +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Writer writer = (Writer) o;
        return Objects.equals(name, writer.name) &&
                Objects.equals(address, writer.address) &&
                Objects.equals(email, writer.email) &&
                Objects.equals(username, writer.username) &&
                Objects.equals(password, writer.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, address, email, username, password);
    }
}
