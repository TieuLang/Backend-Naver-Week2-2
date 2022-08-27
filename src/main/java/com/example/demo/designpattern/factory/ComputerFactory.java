package com.example.demo.designpattern.factory;

import com.example.demo.designpattern.subclass.PC;
import com.example.demo.designpattern.subclass.Server;
import com.example.demo.designpattern.superclass.Computer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.beans.ConstructorProperties;

@Component
public class ComputerFactory {
    private PC pc;
    private Server server;

    @PostConstruct
    public void postConstruct(){
        pc=new PC();
        server=new Server();
    }

    public Computer getComputer(String computerType){
        switch (computerType){
            case "PC":
                return pc;
            case "Server":
                return server;
        }
        return null;
    }

}
