package net.programmingpointer.journalapp.entity;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class JournalUserDto {

    //validation
    // 1. add dependency 2.apply validation in DTO 3.enable into controller
    //unique not blank not null
    //@NotBlank(message = "username is mandatory")
    //@NotEmpty =@NotNUll + @NotBlank

    @NotEmpty
    @Size(min=4,message = "username must be min of 4 character")
    private String userName;

    @Email(message = "Email address in invalid !!")
    private String email;

    @NotEmpty
    @Size(min=3,max = 10,message ="Password must be min of 3 char and max of 10 char")
    //@Pattern(regexp = )
    private String password;

    @NotEmpty
    private String title;

    @NotNull
    private String content;

    @NotEmpty
    private String address;

}
