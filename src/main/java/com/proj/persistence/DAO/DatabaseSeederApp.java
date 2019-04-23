package com.proj.persistence.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeederApp implements CommandLineRunner {
    private ApplicationRepository appRepository;

    @Autowired
    public DatabaseSeederApp(ApplicationRepository appRepository){
        this.appRepository = appRepository;
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
