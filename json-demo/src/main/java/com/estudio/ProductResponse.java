package com.estudio;

public record ProductResponse (
    int id,
    String name,
    double price,
    boolean active
) {}