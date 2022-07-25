/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.SortNatural;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

public class User implements Comparable<User> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	private Role role;


	@OneToMany(targetEntity = Vote.class)
	private List<Vote> userVotes = new ArrayList<>();

	//Option one
	boolean canVote(Long pollId,User user ){
		for (Vote v: user.getUserVotes()
			 ) {
			if(v.getIdPoll() == pollId)
				return false;

		}
		return true;
	}

//	boolean canSeeResults()


	public User(String name, Role role) {
		this.name = name;
		this.role = role;
	}

	protected User() {

	}


	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", role=" + role +
				'}';
	}
	public List<Vote> getUserVotes() {
		return userVotes;
	}

	@Override
	public int compareTo(User o) {
		int result = 0;
		if (o != null) {
			if (id != null) {
				result = id.compareTo(o.getId());
			} else if (o.getId() != null) {
				result = 1;
			} else {
				result = 0;
			}
		} else {
			result = -1;
		}
		return result;
	}

}
