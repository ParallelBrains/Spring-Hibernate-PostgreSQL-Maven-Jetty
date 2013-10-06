package com.parallelbrains.baselayout.service;

import com.parallelbrains.baselayout.model.User;
import com.parallelbrains.baselayout.utils.TestUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class UserManagerTest extends BaseManagerTest {

    @Autowired
    private UserManager userManager;

    @Test
    public void saveAUser() {
        User user = TestUtils.getAUserObject();

        userManager.save(user);

        assertNotNull(user.getId());
    }

    @Test
    public void getAUser() {
        User user = TestUtils.getAUserObject();

        userManager.save(user);

        User savedUser = userManager.get(user.getId());

        assertNotNull(savedUser);
    }

    @Test
    public void listPeople() {
        User user = TestUtils.getAUserObject();

        userManager.save(user);

        List<User> people = userManager.getAll();

        assertEquals(1, people.size());
    }

    @Test
    public void deleteAUser() {
        User user = TestUtils.getAUserObject();

        userManager.save(user);

        Long userId = user.getId();

        assertNotNull(userId);

        userManager.delete(userId);

        User deletedUser = userManager.get(userId);

        assertNull(deletedUser);
    }

}
