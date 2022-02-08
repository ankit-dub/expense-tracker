package splittest.src.main.java.com.splittest.Repository;

import splittest.src.main.java.com.splittest.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    public Role findByRole(String Role);
}
