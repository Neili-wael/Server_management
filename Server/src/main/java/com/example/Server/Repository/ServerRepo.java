package com.example.Server.Repository;

import com.example.Server.model.Server;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepo extends JpaRepository<Server ,Long> {

    Server findByIpAddress(String ipAddress);
}
