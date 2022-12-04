package com.topwears.topwears.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity(name = "DesignCategory")
@Table(name = "design_category")
public class DesignEntity extends BaseEntity{
    private String name;
    private String description;

    public DesignEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
