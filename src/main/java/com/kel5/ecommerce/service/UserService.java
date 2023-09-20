/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kel5.ecommerce.service;

import com.kel5.ecommerce.dto.UserDto;
import com.kel5.ecommerce.entity.User;

import java.util.List;


public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
    UserDto findUserDtoByEmail(String email);

    User findUserByName(String name);
    public List<UserDto> getUsers();
    public List<UserDto> getUsersUser();

    int getJmlUser();

    void confirmEmail(String confirmationToken);
}
