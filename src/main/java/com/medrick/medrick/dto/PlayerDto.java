package com.medrick.medrick.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class PlayerDto implements Serializable {

    private Long id;

    @Size(min = 5, message = "min character = 5")
    @NotNull(message = "no null field")
    private String name;

    @Min(0)
    @Max(value = 100, message = "max = 100")
    private Integer score;

    public PlayerDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
