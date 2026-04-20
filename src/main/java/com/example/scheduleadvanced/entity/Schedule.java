package com.example.scheduleadvanced.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "schedules")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //private String name;
    private String title;
    private String content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime creativeAt;

    @LastModifiedDate
    private LocalDateTime updateAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Schedule(String name, String title, String content){
        this.name = name;
        this.title = title;
        this.content = content;
    }

    public void update(String name, String title, String content){
        this.name = name;
        this.title = title;
        this.content = content;
    }
}
