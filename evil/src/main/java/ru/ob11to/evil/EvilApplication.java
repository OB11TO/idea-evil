package ru.ob11to.evil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//@SpringBootApplication
public class EvilApplication {

    public static void main(String[] args) {
//		SpringApplication.run(EvilApplication.class, args);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "FUCK");
        map.put(2, "GG");
        map.put(3, "FFFFUCK");
        map.put(4, "FUCK");

        map.forEach((integer, s) -> System.out.println(integer + " - " +  s));



    }
}


