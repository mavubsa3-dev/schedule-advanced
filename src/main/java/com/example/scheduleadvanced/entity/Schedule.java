package com.example.scheduleadvanced.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String title;
    private String content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime creativeAt;

    @LastModifiedDate
    private LocalDateTime updateAt;

    public Schedule(String name, String title, String content){
        this.name = name;
        this.title = title;
        this.content = content;
    }
}
