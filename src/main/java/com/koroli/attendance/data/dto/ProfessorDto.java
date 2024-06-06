package com.koroli.attendance.data.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDto {
    private UUID id;
    private String email;
    // TODO: 28.04.2024 убрать пароль из dto
    private String password;
    private String fullName;
}
