package com.ibm.ro.tm.apprenticeship.poll.metter.be;

import java.util.logging.Logger;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Role;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Vote;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.VoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;

@Configuration
class DataLoader {

	private static final Logger logger = Logger.getLogger(DataLoader.class.getName());

	@Bean
	CommandLineRunner databaseInitializer(UserRepository userRepository, VoteRepository voteRepository, PollRepository pollRepository) {
		return args -> {
			
			User yoda = new User("Yoda", Role.Admin);
			User luke = new User("Luke", Role.User);
			User leia = new User("Leia", Role.Guest);


			logger.info("loading user:" + userRepository.save(yoda));
			logger.info("loading user:" + userRepository.save(luke));
			logger.info("loading user:" + userRepository.save(leia));

			Poll poll1 = new Poll("Burnout","Did you had a burnout in the last month?");
			logger.info("loading poll:" + pollRepository.save(poll1));

			Long num= 1L;
			Vote vote1= new Vote(num,6,"Primul raspuns",num);
			logger.info("loading vote:" + voteRepository.save(vote1));
		};
	}

}
