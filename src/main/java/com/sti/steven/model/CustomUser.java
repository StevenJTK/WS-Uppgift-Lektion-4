package com.sti.steven.model;

public record CustomUser(
        int id,
        String username,
        String password,
        boolean isEnabled
) {


}
