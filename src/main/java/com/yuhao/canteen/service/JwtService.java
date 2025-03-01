package com.yuhao.canteen.service;

public interface JwtService {
    String generateToken(String username);

    String validateTokenAndGetUsername(String token);

    String refreshToken(String token);
}
