package bssm.devcoop.occount.domain.user.presentation.dto;

public record LoginRequestDto (
        String email,
        String password
) { }