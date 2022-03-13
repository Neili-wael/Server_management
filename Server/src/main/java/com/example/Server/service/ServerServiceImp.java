package com.example.Server.service;

import com.example.Server.Repository.ServerRepo;
import com.example.Server.model.Server;
import com.example.Server.model.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImp implements ServerService{
    private final ServerRepo Sr;

    @Override
    public Server create(Server server) {
        log.info("Saving New Server :{}",server.getName());
        server.setImageUrl(setServerImageUrl());
        return  Sr.save(server);
    }


    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Ping Server Ip:{}",ipAddress);
        Server server =Sr.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? Status.Server_Up : Status.Server_Down);
        return Sr.save(server);
    }

    @Override
    public Collection<Server> list(int limit) {
        log.info("Fetch all Servers");
        return Sr.findAll(PageRequest.of(0,limit)).toList();
    }

    @Override
    public Server update(Server server) {
        log.info("Updating Server {}",server.getName());
        return  Sr.save(server);
    }

    @Override
    public boolean delete(Long id) {
        log.info ("Deleting Server By Id : {}",id);
        Optional<Server> S = Sr.findById(id);
        Server server = S.get();
        Sr.delete(server);
        return true;
    }

    @Override
    public Server find(Long id) {
        log.info("Fetching Server By Id {}",id);
        Optional<Server> s =Sr.findById(id);
        Server server =s.get();
        return server;
    }
    private String setServerImageUrl() {
        String[] imagesNames = {"Server1.png","Server2.png","Server3.png","Server4.png"};

        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/images/" + imagesNames[new Random().nextInt(4)]).toUriString();
    }
}
