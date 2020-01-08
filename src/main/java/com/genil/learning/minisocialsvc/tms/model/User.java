package com.genil.learning.minisocialsvc.tms.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by Antony Genil Gregory on 1/7/2020 3:44 PM
 * For project : mini-social-svc
 **/
@Data
public class User {

        @NotNull (message = "userId can't be null")
        @Min(value = 300, message = "userId has to be minimum of 300")
        private Integer userId;
        @NotBlank(message = "Name cannot be blank")
        private String userName;
        public User(Integer userId, String userName){
            this.userId = userId;
            this.userName = userName;
        }
        // getter and setter methods

}
