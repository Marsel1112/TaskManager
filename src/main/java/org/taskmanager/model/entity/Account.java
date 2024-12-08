package org.taskmanager.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(schema = "account", name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String patronymic;

    private String phone;

    @Column(name = "tag_name")
    private String tagName;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToMany(mappedBy = "accountList")
    private List<Task> taskList = new ArrayList<>();
}
