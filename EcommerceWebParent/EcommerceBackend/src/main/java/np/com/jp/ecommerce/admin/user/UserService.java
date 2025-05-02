package np.com.jp.ecommerce.admin.user;

import np.com.jp.ecommerce.common.entity.Role;
import np.com.jp.ecommerce.common.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
 public List<User> listAll();
 public List<Role> listRoles();
 void save(User user);
 public void encodePassword(User user);
 public Boolean isUniqueEmail(String email);
}
