package com.cansr.sample1.service.impl;

import com.cansr.sample1.UserDto;
import com.cansr.sample1.model.MySqlUser;
import com.cansr.sample1.repository.IUserRepository;
import com.cansr.sample1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserService implements IUserService<MySqlUser> {


    IUserRepository userRepository;

    @Autowired
    public void setMysqlUserRepo(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<List<MySqlUser>> fetchAllUsers() {
        return Optional.ofNullable(this.userRepository.findAll());
    }

    @Override
    public Optional<MySqlUser> fetchUser(Long Id) {
        return this.userRepository.findById(Id);
    }

    @Override
    public Boolean saveUser(UserDto userDto) {

        final Optional<MySqlUser> userOpt = this.userRepository.findById(userDto.getId());

        if (userOpt.isPresent()) {
            final MySqlUser mySqlUser = userOpt.get();
            mySqlUser.setAge(userDto.getAge());
            mySqlUser.setGender(userDto.getGender());
            mySqlUser.setUserName(userDto.getName());
            this.userRepository.save(mySqlUser);
            return true;
        }
        return false;
    }
}
