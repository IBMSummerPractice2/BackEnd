/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

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

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "user-polls", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "poll_id"))
	@SortNatural
	private SortedSet<Poll> polls = new TreeSet<>();



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
