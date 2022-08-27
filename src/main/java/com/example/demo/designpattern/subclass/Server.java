package com.example.demo.designpattern.subclass;

import com.example.demo.designpattern.superclass.Computer;
import org.springframework.stereotype.Component;

@Component
public class Server implements Computer {

    @Override
    public String getType() {
        return "Server";
    }
}
