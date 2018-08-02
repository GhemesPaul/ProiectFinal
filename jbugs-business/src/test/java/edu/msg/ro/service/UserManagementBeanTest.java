package edu.msg.ro.service;

import org.junit.Test;

import javax.ejb.EJB;
import javax.inject.Inject;

import static org.junit.Assert.*;

public class UserManagementBeanTest {


    UserManagementBean bean = new UserManagementBean();

    @Test
    public void generateUsername_expectedMarini() {
        String username = bean.generateUsername("ion","marin");
        assertTrue("Expected marini found :" + username , username.equals("marini"));
    }

    @Test
    public void generateUsername_expectedIonIon() {
        String username = bean.generateUsername("ion","ion");
        assertTrue("Expected ionion found :" + username , username.equals("ionion"));
    }

    @Test
    public void generateUsername_expectedPetrindeanCalin() {
        String username = bean.generateUsername("calin","petrindean");
        assertTrue("Expected petric found :" + username , username.equals("petric"));
    }

    @Test
    public void generateUsername_expectedBA0000() {
        String username = bean.generateUsername("a","b");
        assertTrue("Expected ba0000 found :" + username , username.equals("ba0000"));
    }
}