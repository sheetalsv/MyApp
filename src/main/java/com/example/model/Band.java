package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    //List of Musicians
    @OneToMany(mappedBy = "band", fetch = FetchType.EAGER) // For small data EAGER (preloads data), big then take LAZY (loads data only when query is triggered)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
    private List<Musician> musicians = new ArrayList<>();
}
