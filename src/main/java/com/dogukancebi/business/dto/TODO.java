package com.dogukancebi.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDto implements Serializable {

    private static final Long serialVersionUID = 1L;

    @NotEmpty(message = "Başlık boş olamaz")
    @Size(min = 5, message = "Başlık en az 5 karakter olmalıdır")
    private String title;

    @NotEmpty(message = "İçerik boş olamaz")
    @Size(min = 10, message = "İçerik en az 10 karakter olmalıdır")
    private String content;



}



