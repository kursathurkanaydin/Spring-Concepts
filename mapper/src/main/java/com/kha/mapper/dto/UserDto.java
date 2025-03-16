package com.kha.mapper.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotEmpty(message = "name shouldn't be empty")
    @Size(min = 3, max = 50)
    private String name;

    @NotEmpty
    @Size(min = 3, max = 100)
    @Email(message = "email should be valid format")
    private String email;
    @Min(0)
    @Max(200)
    private int age;
}
