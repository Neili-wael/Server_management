package com.example.Server.service;

import com.example.Server.model.Server;

import java.util.Collection;

public class ServerServiceImp implements ServerService{
    @Override
    public Server create(Server server) {
        return null;
    }

    @Override
    public Server ping(String ipAddress) {
        return null;
    }

    @Override
    public Collection<Server> list(int limit) {
        return null;
    }

    @Override
    public Server update(Server server) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Server find(Long id) {
        return null;
    }
}
