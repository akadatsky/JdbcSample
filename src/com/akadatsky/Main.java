package com.akadatsky;

import com.akadatsky.dao.UserDao;
import com.akadatsky.model.Group;
import com.akadatsky.model.User;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Group javaGroup = createJavaGroup();
        Group jsGroup = createJsGroup();

        try {
            UserDao userDao = new UserDao();
            userDao.clean();
            userDao.insetGroup(javaGroup);
            userDao.insetGroup(jsGroup);

            Group testGroup = userDao.getGroupByName("Java");
            System.out.println("Founded group: " + testGroup);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Group createJavaGroup() {
        Group group = new Group(Helper.generateId(), "Java");
        group.addUser(new User(Helper.generateId(), "Alex", 25));
        group.addUser(new User(Helper.generateId(), "Oleg", 28));
        group.addUser(new User(Helper.generateId(), "Igor", 30));
        return group;
    }

    private static Group createJsGroup() {
        Group group = new Group(Helper.generateId(), "Js");
        group.addUser(new User(Helper.generateId(), "Sofia", 25));
        group.addUser(new User(Helper.generateId(), "Alex", 28));
        group.addUser(new User(Helper.generateId(), "Emilia", 30));
        return group;
    }

}
