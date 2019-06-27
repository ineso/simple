package com.packt.sample.security;

import com.packt.sample.entity.Role;
import com.packt.sample.entity.UserAPP;
import com.packt.sample.service.RoleService;
import com.packt.sample.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class UserEntityManagerCommandLineRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(UserEntityManagerCommandLineRunner.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @Override
    public void run(String... args) {


        if (roleService.findByName("ROLE_ADMIN")==null){
//            log.info("-------------------------------");
//            log.info("Adding role ROLE_ADMIN");
//            log.info("-------------------------------");
            Role roleAdmin = new Role("ROLE_ADMIN");//roleService.save();
//            log.info("Inserted role");

            if (userService.findByUsername("admin")== null) {
                log.info("-------------------------------");
                log.info("Adding admin as administrator user");
                log.info("-------------------------------");
                UserAPP admin = new UserAPP("admin", "admin");
                admin.getRoles().add(roleAdmin);
                userService.saveUser(admin);
                log.info("Inserted admin" + admin);
            }
        }





    }
}
