package com.gp1.gstock.example.dto;

import lombok.Data;

@Data
public class MemberDto {
    public String id;
    public String password;
    public String name;
    public String email;
    public String organization;
}
