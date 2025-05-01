package np.com.jp.ecommerce.admin.user;

import np.com.jp.ecommerce.common.entity.Role;
import np.com.jp.ecommerce.common.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

}
