package edu.msg.ro.service;

import edu.msg.ro.boundary.UserManagement;
import edu.msg.ro.exceptions.BusinessExeption;
import edu.msg.ro.exceptions.ExeptionCode;
import edu.msg.ro.persistence.user.dao.UserPersistenceManager;
import edu.msg.ro.persistence.user.entity.User;
import edu.msg.ro.transfer.UserDTO;
import edu.msg.ro.transfer.UserDTOHelper;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Stateless
public class UserManagementBean implements UserManagement {
    private static final int MAX_LASTNAME_LENGTH = 5;
    private static final int MIN_USERNAME_LENGTH = 6;
    private static final Logger logger = LogManager.getLogger(UserManagementBean.class);

    @EJB
    UserPersistenceManager userPersistenceManager;

    @Override
    public UserDTO createUser(UserDTO userDTO) throws BusinessExeption {
        logger.log(Level.INFO,"In createUser method");
        //TODO TRIM FIRSTNAME AND LAST NAME
        if(!isUserValidForCreation(userDTO) || !isValidEmail(userDTO.getEmail())) {
            throw new BusinessExeption(ExeptionCode.USER_VALIDATION_EXEPTION);
        }
        if(true) {
            throw new BusinessExeption(ExeptionCode.EMAIL_EXISTS_EXEPTION);
        }
        User user = UserDTOHelper.toentity(userDTO);
        userPersistenceManager.addUser(user);
        return UserDTOHelper.fromentity(user);
    }

    protected String createSuffix(){
        List<User> users = (List<User>) userPersistenceManager.findUserNameStartingWith("ionion");
        return null;
    }

    protected String generateUsername(@NotNull final String firstName, @NotNull final String lastName){

        StringBuilder username = new StringBuilder();

        if(lastName.length()>=MAX_LASTNAME_LENGTH)
            username.append(lastName.substring(0,MAX_LASTNAME_LENGTH)+firstName.charAt(0));
        else if(lastName.length()+firstName.length() >= MIN_USERNAME_LENGTH){
            username.append(lastName + firstName.substring(0,MIN_USERNAME_LENGTH - lastName.length()));

        }else{
            username.append(lastName + firstName);
            int usernameLength = username.length();
            for(int i = 0 ; i < MIN_USERNAME_LENGTH - usernameLength;i++){
                username .append("0");
            }
        }

        return username.toString().toLowerCase();
    }

    private boolean isUserValidForCreation(UserDTO userDTO){
        return userDTO.getFirstName() != null && userDTO.getLastName() != null && userDTO.getEmail() != null
                && userDTO.getPassword() != null && userDTO.getPhoneNumber() != null;
    }

    private  boolean isValidEmail(String email){
        final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@msggroup.com$", Pattern.CASE_INSENSITIVE);

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
    }

}
