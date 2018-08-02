package edu.msg.ro.boundary;

import edu.msg.ro.exceptions.BusinessExeption;
import edu.msg.ro.persistence.user.entity.User;
import edu.msg.ro.transfer.UserDTO;

public interface UserManagement {

    /**
     * Method is used for persisting userDTO from an userDTO
     * generates the username and does the validations
     * @param userDTO
     * @return the newly created entity
     */
    UserDTO createUser(UserDTO userDTO) throws BusinessExeption;


}
