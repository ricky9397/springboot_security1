package com.ricky.security1.auth;

import com.ricky.security1.model.User;
import com.ricky.security1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 시큐리티 설정에서 loginProcessiongUrl("/login");
// login 요청이 오면 자동으로 UserDetailsService 타입으로 Ioc되어 있는 loadUserByUsername 함수가 실행
@Service
@RequiredArgsConstructor
public class PrintcipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // 시큐리티 session ( = Authentication( = UserDetails ) )
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username);
        if(userEntity != null){
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}
