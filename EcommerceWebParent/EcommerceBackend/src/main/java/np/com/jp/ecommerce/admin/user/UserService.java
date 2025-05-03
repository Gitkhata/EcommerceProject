package np.com.jp.ecommerce.admin.user;

import np.com.jp.ecommerce.common.entity.Role;
import np.com.jp.ecommerce.common.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    public List<User> listAll();

    public List<Role> listRoles();

    void save(User user);

    public void encodePassword(User user);

    public Boolean isUniqueEmail(Integer id, String email);

    User getUserById(Integer id) throws UserNotFoundException;
}
