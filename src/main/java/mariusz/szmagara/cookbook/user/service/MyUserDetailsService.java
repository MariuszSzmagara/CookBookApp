package mariusz.szmagara.cookbook.user.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import mariusz.szmagara.cookbook.user.model.MyUserDetails;
import mariusz.szmagara.cookbook.user.model.User;
import mariusz.szmagara.cookbook.user.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userName) {
//        Optional<User> optionalByUserName = userRepository.findByUserName(userName);
//        if (optionalByUserName.isPresent()) {
//            User user = optionalByUserName.get();
//            Set<SimpleGrantedAuthority> collect = user.getRoles()
//                    .stream()
//                    .map(userRole -> new SimpleGrantedAuthority(userRole.getAuthority().name()))
//                    .collect(Collectors.toSet());
//            Collection<SimpleGrantedAuthority> roles;
//            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), collect);
//        } else {
//            throw new UsernameNotFoundException("There is no record wirth given userName: " + userName);
//        }

        Optional<User> optionalByUserName = userRepository.findByUserName(userName);
        if (optionalByUserName.isPresent()) {
            User user = optionalByUserName.get();
            return new MyUserDetails(user);
        } else {
            throw new UsernameNotFoundException("There is no record wirth given userName: " + userName);
        }
    }


}
