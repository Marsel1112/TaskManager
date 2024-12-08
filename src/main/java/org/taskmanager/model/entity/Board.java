package org.taskmanager.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.taskmanager.model.enums.BoardType;
import org.taskmanager.model.enums.WorkSpaceType;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(schema = "workspace", name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head_of_department")
    private Account headOfDepartment;

    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    @Enumerated(EnumType.STRING)
    private BoardType type;

    @ManyToOne()
    @JoinColumn(name = "work_space_id",nullable = false)
    private WorkSpace workSpace;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Task> taskList;
}
