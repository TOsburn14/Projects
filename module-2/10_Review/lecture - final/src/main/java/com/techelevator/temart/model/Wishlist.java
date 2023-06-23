package com.techelevator.temart.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Wishlist {

    private int id;
    private String name;
    private LocalDateTime dateCreated;

    public Wishlist() {

    }

    public Wishlist(int id, String name, LocalDateTime dateCreated) {
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wishlist wishlist = (Wishlist) o;
        return id == wishlist.id && Objects.equals(name, wishlist.name) && Objects.equals(dateCreated, wishlist.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateCreated);
    }
}
