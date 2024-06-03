package com.digitechbb.smsv1.model.dtos;

import com.digitechbb.smsv1.enums.Statut;

public record AccountDto(
        String login,
        String password,
        Boolean activated,
        Statut statut
) {

}
