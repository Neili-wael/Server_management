package com.example.Server.service;

import com.example.Server.model.Server;

import java.io.IOException;
import java.util.Collection;

public interface ServerService {

    Server create(Server server);
    Server ping(String ipAddress) throws IOException;
    Collection<Server> list(int limit);
    Server update(Server server);
    boolean delete(Long id);
    Server find(Long id);

    }

