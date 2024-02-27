package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.DataAmount;

@Entity
@DataAmount
public class Post {
    @Id
    Long id;
    String title;

}
