package com.ra.ss03.model.dto.customer.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerRequestDTO {
    @Pattern(regexp = "^[a-zA-Z0-9_%+=]+@[a-z]+\\.[a-z]{2,6}$",message = "Email khong dung dinh dang")
    @NotBlank
    private String email;
    @NotBlank
    private String fullName;
    @Length(min = 6)

    private String password;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate birthday;

    private Boolean status;
}
