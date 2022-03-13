package com.example.Server;

import com.example.Server.Repository.ServerRepo;
import com.example.Server.model.Server;
import com.example.Server.model.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

		@Bean
	CommandLineRunner run (ServerRepo Sr){

		return  args -> {
			Sr.save(new Server(null,"192.168.0.201","Server 1","70Gb","Node1","http://localhost:8080/server/image/server1.png", Status.Server_Up));

			Sr.save(new Server(null,"192.168.0.202","Server 2","70Gb","Node2","http://localhost:8080/server/image/server2.png", Status.Server_Up));

			Sr.save(new Server(null,"192.168.0.203","Server 3","70Gb","Node3","http://localhost:8080/server/image/server3.png", Status.Server_Down));

		};
	}

}
