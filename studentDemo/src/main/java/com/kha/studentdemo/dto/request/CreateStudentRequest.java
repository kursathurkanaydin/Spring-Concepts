package com.kha.studentdemo.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateStudentRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String fatherName;
    private String motherName;
    private String telNo;
}
