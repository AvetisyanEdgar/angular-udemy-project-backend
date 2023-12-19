package am.itspace.testproject.service.impl;

import am.itspace.testproject.entity.User;
import am.itspace.testproject.repository.UserRepository;
import am.itspace.testproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
