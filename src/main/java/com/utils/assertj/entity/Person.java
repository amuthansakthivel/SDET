package com.utils.assertj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String firstname;
    private List<String> jobs;
    private FavFoods favFoods;
}
