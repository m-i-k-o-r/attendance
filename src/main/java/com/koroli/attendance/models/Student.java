package com.koroli.attendance.models;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id_number")
    private Long idNumberCard;
    private String fullName;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
