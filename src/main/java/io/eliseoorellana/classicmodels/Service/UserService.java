package io.eliseoorellana.classicmodels.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.eliseoorellana.classicmodels.DTO.UserDTO;
import io.eliseoorellana.classicmodels.Repository.UserRepository;
import io.eliseoorellana.classicmodels.Request.UserRequest;
import io.eliseoorellana.classicmodels.Response.UserResponse;
import io.eliseoorellana.classicmodels.model.Role;
import io.eliseoorellana.classicmodels.model.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository; 

    @Transactional
    public UserResponse updateUser(UserRequest userRequest) {
       
        User user = User.builder()
        .id(userRequest.getId())
        .firstname(userRequest.getFirstname())
        .lastname(userRequest.getLastname())
        .country(userRequest.getCountry())
        .role(Role.USER)
        .build();
        
        userRepository.updateUser(user.getId(), user.getFirstname(), user.getLastname(), user.getCountry());

        return new UserResponse("El usuario se registró satisfactoriamente");
    }

    public UserDTO getUser(Integer id) {
        User user= userRepository.findById(id).orElse(null);
       
        if (user!=null)
        {
            return UserDTO.builder()
            .id(user.getId())
            .username(user.getUsername())
            .firstname(user.getFirstname())
            .lastname(user.getLastname())
            .country(user.getCountry())
            .build();
        }
        return null;
    }
}
