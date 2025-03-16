package com.kha.studentdemo.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ShowStudentResponse {
    private String firstName;
    private String lastName;
    private String email;
}
