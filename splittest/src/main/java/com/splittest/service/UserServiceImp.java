package splittest.src.main.java.com.splittest.service;

import java.util.Arrays;
import java.util.HashSet;


import splittest.src.main.java.com.splittest.Repository.Repo;
import splittest.src.main.java.com.splittest.Repository.RoleRepo;
import splittest.src.main.java.com.splittest.model.Usr;
import splittest.src.main.java.com.splittest.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	RoleRepo roleRepository;
	@Autowired
	Repo userRepository;

	@Override
	public void saveUser(Usr user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setStatus("VERIFIED");
		Role userRole = roleRepository.findByRole("SITE_USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	@Override
public boolean isPresent(Usr user) {
     boolean isUserAlreadyExists = false;
     Usr existingUser = userRepository.findByEmail(user.getEmail());
     // If user is found in database, then then user already exists.
     if(existingUser != null){
         isUserAlreadyExists = true; 
     }
     return isUserAlreadyExists;
}

}