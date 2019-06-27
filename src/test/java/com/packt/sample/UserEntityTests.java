package com.packt.sample;


import com.packt.sample.entity.UserAPP;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class UserEntityTests {


    @Autowired
    private TestEntityManager entityManager;

    private String validPassword = "aValidPassword";
    private String validUsername = "aValidUsername";
    private String invalidPassword = "only5";

    @Test
    public void createWhenUsernameIsNullShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserAPP(null, validPassword ))
                .withMessage("Username must not be empty");
    }

    @Test
    public void createWhenUsernameIsEmptyShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserAPP("", validPassword ))
                .withMessage("Username must not be empty");
    }

    @Test
    public void createWhenPasswordIsNullShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserAPP(validUsername, null))
                .withMessage("Password must not be null");
    }

    @Test
    public void createWhenPasswordHasLessThan8CharactersShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> new UserAPP(validUsername, invalidPassword))
                .withMessage("Password must has at least 8 characters");
    }

    @Test
    public void saveShouldPersistData() {
        UserAPP user = this.entityManager.persistFlushFind(new UserAPP(validUsername, validPassword));
        assertThat(user.getUsername()).isEqualTo(validUsername);
        assertThat(user.getPassword()).isEqualTo(validPassword);
    }

}
