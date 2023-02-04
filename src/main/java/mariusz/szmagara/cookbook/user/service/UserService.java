package mariusz.szmagara.cookbook.user.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import mariusz.szmagara.cookbook.mail.service.MailService;
import mariusz.szmagara.cookbook.user.address.model.Address;
import mariusz.szmagara.cookbook.user.address.repository.AddressRepository;
import mariusz.szmagara.cookbook.user.dto.AccountDetailsToModifyFormDto;
import mariusz.szmagara.cookbook.user.dto.SignUpFormDto;
import mariusz.szmagara.cookbook.user.model.Authority;
import mariusz.szmagara.cookbook.user.model.Role;
import mariusz.szmagara.cookbook.user.model.User;
import mariusz.szmagara.cookbook.user.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final MailService mailService;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, AddressRepository addressRepository, MailService mailService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.mailService = mailService;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }

    public void signUpUser(SignUpFormDto userDto) {
        User userToSignUp = fromSignUpFormDto(userDto);
        userToSignUp.setPassword(passwordEncoder.encode(userToSignUp.getPassword()));
        List<Role> roles = Collections.singletonList(new Role(Authority.ROLE_USER, userToSignUp));
        userToSignUp.setRoles(new HashSet<>(roles));
        User savedUser = userRepository.save(userToSignUp);
        addressRepository.updateUserId(savedUser.getAddress().getId(), savedUser.getId());
    }

    private User fromSignUpFormDto(SignUpFormDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setEmailAddress(userDto.getEmailAddress());
        user.setSignedUpForNewsletter(userDto.isSignedUpForNewsletter());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());
        user.setAgreedToTermsAndConditions(userDto.isAgreedToTermsAndConditions());
        Address address = new Address();
        address.setStreetFlatAndHouseNumber(userDto.getStreetFlatAndHouseNumber());
        address.setPostalCode(userDto.getPostalCode());
        address.setCity(userDto.getCity());
        user.setAddress(address);
        return user;
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAllWithoutAuthenticated() {
        Authentication authenticatedUser = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findAll()
                .stream()
                .filter((User user) -> !user.getUserName().equals(authenticatedUser.getName()))
                .collect(Collectors.toList());
    }

    public void sendPasswordResetLink(String emailAddress) {
        String randomPasswordResetKey = UUID.randomUUID().toString();
        userRepository.findByEmailAddress(emailAddress).ifPresent(user -> {
            user.setPasswordResetKey(randomPasswordResetKey);
            userRepository.save(user);
            mailService.sendPasswordResetLink(emailAddress, randomPasswordResetKey);
        });
    }

    public void resetUserPassword(String passwordResetKey, String newPassword) {
        userRepository.findByPasswordResetKey(passwordResetKey).ifPresent(user -> {
            user.setPassword(passwordEncoder.encode(newPassword));
            user.setPasswordResetKey(null);
            userRepository.save(user);
        });
    }

    public void updateUserAccount(User userToModify) {
        userToModify.setPassword(passwordEncoder.encode(userToModify.getPassword()));
        userRepository.save(userToModify);
    }


    public void updateUserAccountDetails(AccountDetailsToModifyFormDto userAccountDetailsToModify) {
        userAccountDetailsToModify.setPassword(passwordEncoder.encode(userAccountDetailsToModify.getPassword()));
        userRepository.updateUserAccountDetails(userAccountDetailsToModify);
    }
}
