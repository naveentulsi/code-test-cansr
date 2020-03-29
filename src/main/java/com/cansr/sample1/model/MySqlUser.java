package com.cansr.sample1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "mysql_user", schema = "db")
@NoArgsConstructor
public class MySqlUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user", updatable = false, nullable = false)
    private String userName;

    @Column(name = "gender", updatable = false, nullable = false)
    private String gender;

    @Column(name = "age", updatable = false, nullable = false)
    private Integer age;

    @Column(name = "is_active", updatable = true, nullable = false)
    private Boolean isActive;
}
