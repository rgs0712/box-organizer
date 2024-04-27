package br.com.rgs.boxorganizer.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}
