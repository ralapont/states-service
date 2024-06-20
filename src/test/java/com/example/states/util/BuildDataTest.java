package com.example.states.util;

import com.example.states.entity.StateEntity;
import com.example.states.model.output.StateResponseDto;

import java.util.ArrayList;
import java.util.List;

public class BuildDataTest {

    public static StateResponseDto buildState1() {
        return StateResponseDto.builder()
                .codigo("AK")
                .state("Alaska")
                .capital("Juneau")
                .region("West")
                .build();
    }

    public static StateResponseDto buildState2() {
        return StateResponseDto.builder()
                .codigo("AL")
                .state("Alabama")
                .capital("Montgomery")
                .region("South")
                .build();
    }

    public static StateEntity buildEntaty1() {
        return StateEntity.builder()
                .codigo("AL")
                .state("Alabama")
                .capital("Montgomery")
                .region("South")
                .build();
    }

    public static StateEntity buildEntaty2() {
        return StateEntity.builder()
                .codigo("AK")
                .state("Alaska")
                .capital("Juneau")
                .region("West")
                .build();
    }

    public static List<StateResponseDto> buildListState() {
        List<StateResponseDto> states = new ArrayList<>();
        states.add(buildState1());
        states.add(buildState2());
        return states;
    }

    public static List<StateEntity> buildListStateEntity() {
        List<StateEntity> states = new ArrayList<>();
        states.add(buildEntaty2());
        states.add(buildEntaty1());
        return states;
    }

}
