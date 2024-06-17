package com.example.soft_hatch.Dto;

import com.example.soft_hatch.entity.Courses;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ComputerPackageDto {
    private Integer id;
    private Courses courses;
}
