package br.com.rgs.boxorganizer.configuration;

import br.com.rgs.boxorganizer.entities.Role;
import br.com.rgs.boxorganizer.entities.User;
import br.com.rgs.boxorganizer.repositories.RoleRepository;
import br.com.rgs.boxorganizer.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Configuration
@Slf4j
public class AdminUserConfig implements CommandLineRunner {

    @Value("${user.admin.name:admin}")
    private String userAdmin;

    @Value("${user.admin.password:123}")
    private String userAdminPassword;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Optional<Role> roleAdmin = roleRepository.findByName(Role.Values.ADMIN.name());
        Optional<User> byUserName = userRepository.findByUserName(userAdmin);

        byUserName.ifPresentOrElse(
                user -> log.warn("User: {} already exists", userAdmin),
                () -> {
                    User user = new User();
                    user.setUserName(userAdmin);
                    user.setPassword(passwordEncoder.encode(userAdminPassword));
                    user.setRoles(Set.of(roleAdmin.get()));
                    userRepository.save(user);
                }
        );
    }
}
