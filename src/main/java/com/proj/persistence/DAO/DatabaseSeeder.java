package com.proj.persistence.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private UserRepository userRepository;

    @Autowired
    public DatabaseSeeder(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
    	/*List<User> users = new ArrayList<>();
    	
    	User user1 = new User("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
        User user2 = new User("John", "Cena", "john@javaguides.com");
        
        users.add(user1);
        users.add(user2);
        userRepository.saveAll(users);*/
    }
}
