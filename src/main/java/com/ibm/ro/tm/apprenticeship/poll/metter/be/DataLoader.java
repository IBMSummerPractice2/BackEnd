package com.ibm.ro.tm.apprenticeship.poll.metter.be;

import java.util.ArrayList;
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

			//Users
			ArrayList <User> arrayUsers = new ArrayList<>();
			arrayUsers.add(new User("Yoda", Role.Admin));
			arrayUsers.add(new User("Luke", Role.User));
			arrayUsers.add(new User("Leia", Role.Guest));
			arrayUsers.add(new User("Ana", Role.Guest));
			arrayUsers.add(new User("Bogdan", Role.Admin));
			arrayUsers.add(new User("Andrei", Role.Guest));
			arrayUsers.add(new User("Sorina", Role.Guest));
			arrayUsers.add(new User("Anakin", Role.User));
			arrayUsers.add(new User("Horatiu", Role.User));
			arrayUsers.add(new User("Stefan", Role.Guest));
			arrayUsers.add(new User("Flavia", Role.Admin));
			arrayUsers.add(new User("Lorena", Role.Guest));
			arrayUsers.add(new User("Mihai", Role.User));
			for(User i:arrayUsers){
				logger.info("loading user:" + userRepository.save(i));
			}

			// Polls
			ArrayList <Poll> arrayPolls = new ArrayList<>();
			arrayPolls.add(new Poll("Burnout","How likely do you think you are to experience a burnout?"));
			arrayPolls.add(new Poll("Customer service","How would you rate your recent customer service experience?"));
			arrayPolls.add(new Poll("Brand","How likely are you to recommend our brand to a friend or colleague? "));
			arrayPolls.add(new Poll("Halloween","Do you like the Halloween?"));
			arrayPolls.add(new Poll("Productivity","How productive are you on a monday"));
			arrayPolls.add(new Poll("Mood","What is you mood today?"));
			for(Poll i: arrayPolls) {
				logger.info("loading poll:" + pollRepository.save(i));
			}

			//Votes
			ArrayList <Vote> arrayVotes = new ArrayList<>();
			String comments[];
			comments = new String[]{"good question", "i have been waiting for someone to ask this","great","","i like this question"};
			int nrVotes = 30;
			for(int i=0;i<nrVotes;i++) {
				Long num = 1L;
				Vote vote = new Vote((long)i/(nrVotes/arrayPolls.size())+1,(long)i%arrayUsers.size()+1,(i*27 + i%13)%10+1,comments[i%(comments.length)]);
				arrayVotes.add(vote);
			}
			for(Vote i: arrayVotes) {
				logger.info("loading vote:" + voteRepository.save(i));
			}
//			pollRepository.getById(num).addVoteToPoll(vote1);


		};

	}

}
