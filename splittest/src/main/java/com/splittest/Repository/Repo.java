package splittest.src.main.java.com.splittest.Repository;

import splittest.src.main.java.com.splittest.model.Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Usr,Integer> {

        public Usr findByEmail(String email);
}
