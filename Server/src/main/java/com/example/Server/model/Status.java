package com.example.Server.model;

public enum Status {
    Server_Up("Server Up"),
    Server_Down("Server Down");

    private final String status;


    Status(String s) {
        this.status= s;
    }

    public String getStatus(){
        return this.status;
    }

}
