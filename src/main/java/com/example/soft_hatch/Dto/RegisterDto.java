package com.example.soft_hatch.Dto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private Integer id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private String password;
    private ZonedDateTime created_at;
    private ZonedDateTime updated_at;
}
