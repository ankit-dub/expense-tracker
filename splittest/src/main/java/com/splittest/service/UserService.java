package splittest.src.main.java.com.splittest.service;

import splittest.src.main.java.com.splittest.model.Usr;

public interface UserService {
    public void saveUser(Usr user);
    public boolean isPresent(Usr user);
}
