package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Website implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //Identity for H2
    private long id;
    private String http;
    private String status;
    private String message;
    private String local;

    public Website() {
    }

    public Website(String http, long id, String status, String message, String local) {
        this.http = http;
        this.id = id;
        this.status = status;
        this.message = message;
        this.local = local;
    }

    public String getHttp() {
        return http;
    }

    public void setHttp(String http) {
        this.http = http;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Website website = (Website) o;
        return id == website.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
