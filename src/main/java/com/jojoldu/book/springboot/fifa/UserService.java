package com.jojoldu.book.springboot.fifa;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {
    @Autowired
    private final UserApiClient userApiClient;

    @Transactional(readOnly = true)
    public UserResponseDto searchUserInfo(String nickname) {
        return userApiClient.requestUserInfo(nickname);
    }
}