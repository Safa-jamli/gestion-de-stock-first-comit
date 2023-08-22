package com.jamli.gestiondestoks.handlers;

import com.jamli.gestiondestoks.exeption.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    private  Integer httpCode;
    private ErrorCodes code;
    private String message;
    private List<String> errors= new ArrayList<>();
}
