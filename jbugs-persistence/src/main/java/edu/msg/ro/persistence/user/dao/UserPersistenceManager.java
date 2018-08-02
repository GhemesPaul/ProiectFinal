package edu.msg.ro.persistence.user.dao;

import edu.msg.ro.persistence.user.entity.Role;
import edu.msg.ro.persistence.user.entity.User;

import javax.ejb.Remote;
import java.io.Serializable;
import java.util.List;

@Remote
public interface UserPersistenceManager extends Serializable {

    void addUser(User user);
    User updateUser(User user);
    List<User> getAllUsers();
    User getUserForUsername(String username);
    void deactivateUser(long id);
    void addRole(Role role);
    void removeRole(Role role);
    Role updateRole(Role role);
    Role getRoleForId(long id);
    List<Role> getAllRoles();
    User getUserWithEmail(String email);
    List<User> findUserNameStartingWith(String username);
}
