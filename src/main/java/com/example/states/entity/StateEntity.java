package com.example.states.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "state")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class StateEntity {

    @Id
    @Column(nullable = false, name = "codigo")
    private String codigo;

    @Column(nullable = false, name = "state")
    private String state;

    @Column(nullable = false, name = "capital")
    private String capital;

    @Column(nullable = false, name = "region")
    private String region;

    @Lob
    @Column(name = "flag", columnDefinition = "MEDIUMBLOB")
    private byte[] flag;
}
