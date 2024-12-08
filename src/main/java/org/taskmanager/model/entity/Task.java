package org.taskmanager.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(schema = "workspace", name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String content;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @ManyToOne()
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @ManyToMany
    @JoinTable(
            name = "task_employee",
            schema = "workspace",
            joinColumns =  @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id")
    )
    private Set<Account> accountList = new HashSet<>();
}
