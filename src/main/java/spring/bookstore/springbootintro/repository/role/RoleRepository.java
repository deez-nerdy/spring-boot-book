package spring.bookstore.springbootintro.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.bookstore.springbootintro.model.Role;
import spring.bookstore.springbootintro.model.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role getRoleByRoleName(RoleName roleName);
}
