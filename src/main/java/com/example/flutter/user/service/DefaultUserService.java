package com.example.flutter.user.service;



import com.example.flutter.user.Dto.UserDto;
import com.example.flutter.user.domain.User;
import com.example.flutter.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultUserService implements UserService{
    private UserRepository userRepository;
    private  ModelMapper modelMapper;

    public DefaultUserService(UserRepository userRepository, ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapToEntity(userDto);
        User newUser = this.userRepository.save(user);
        return mapToDto(newUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users.stream().map(user -> mapToDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(long id) {
        User user = this.userRepository.getById(id);
        return mapToDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, long id) {
        User user = this.userRepository.getById(id);

        user.setFirstname(user.getFirstname());
        user.setLastname(user.getLastname());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());

        User updatedUser = this.userRepository.save(user);

        return mapToDto(updatedUser);
    }

    @Override
    public void deleteUserById(long id) {
        User user = this.userRepository.findById(id).orElseThrow();
        this.userRepository.delete(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = this.userRepository.getUserByEmail(email);
        return mapToDto(user);
    }

    private UserDto mapToDto(User user){
        return modelMapper.map(user, UserDto.class);
    }

    private User mapToEntity(UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }
}
