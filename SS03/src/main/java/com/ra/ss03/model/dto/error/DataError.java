package com.ra.ss03.model.dto.error;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class DataError <T>{
    private T message;
    private int code;
}
