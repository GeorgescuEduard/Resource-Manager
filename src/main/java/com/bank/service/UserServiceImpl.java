package com.bank.service;

import java.util.List;

import javax.transaction.Transactional;

import com.bank.exception.RecordNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.bank.exception.DuplicateRecordException;
import com.bank.models.User;
import com.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("userService")
public class UserServiceImpl implements UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired
  private UserRepository userRepository;

  @Override
  public User findUser(Long userId) {
    return userRepository.findById(userId).orElse(null);
  }

  @Override
  public User findUser(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  public List<User> findAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User searchLoginUser(String username, String password) {
    return userRepository.searchLoginUsername(username, password);
  }

  @Override
  @Transactional
  public User add(User user) {
    // Check if already exist a user with same email.
    User existingUsername = userRepository.findByUsername(user.getUsername());
    if (existingUsername != null) {
      String errorMessage = "Already exists a user with the username: " + user.getUsername();
      logger.error(errorMessage);
      throw new DuplicateRecordException(errorMessage);
    }
    User existingEmail = userRepository.findByEmail(user.getEmail());
    if (existingEmail != null) {
      String errorMessage = "Already exists a user with the email: " + user.getEmail();
      logger.error(errorMessage);
      throw new DuplicateRecordException(errorMessage);
    }
    userRepository.save(user);
    return user;
  }

  @Transactional
  public User loginUser(User user) {

    User loggerUser = userRepository.findByUsername(user.getUsername());


    return loggerUser;
  }

  @Override
  @Transactional
  public User update(User user) {
    User existingUser = userRepository.findById(user.getUserid()).orElse(null);
    if (existingUser == null){
      String errorMessage = "User with id" + user.getUserid() + "not found";
      logger.error(errorMessage);
      throw new RecordNotFoundException(errorMessage);
    }

    if(!existingUser.getEmail().equals(user.getEmail())){
      if(userRepository.findByEmail(user.getEmail()) != null){
        String errorMessage = "The email address in already used by another user: " + user.getEmail();
        logger.error(errorMessage);
        throw new DuplicateRecordException(errorMessage);
      }
    }
    if (user.getPassword() == null){
      user.setPassword(existingUser.getPassword());
    }

    return userRepository.save(user);
  }

  @Override
  @Transactional
  public void delete(Long userId) {
    User user = userRepository.findById(userId).orElse(null);
    logger.debug("Delete user with id: " + userId);
    if (user != null){
      userRepository.delete(user);
    } else {
      String errorMessage = "User with id " + userId + " not found";
      logger.error(errorMessage);
      throw  new RecordNotFoundException(errorMessage);
    }
  }

  

}
