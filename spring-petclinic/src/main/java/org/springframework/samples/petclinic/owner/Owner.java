/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.owner;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import org.springframework.core.style.ToStringCreator;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.pet.Pet;

/**
 * Simple JavaBean domain object representing an owner.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 */
public class Owner extends Person {

	@NotEmpty
	private String address;

	@NotEmpty
	private String city;

	@NotEmpty
	@Digits(fraction = 0, integer = 10)
	private String telephone;

	private Set<Integer> pets;

	public Set<Integer> getPets() {
		return pets;
	}

	public void setPets(Set<Integer> pets) {
		this.pets = pets;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	protected Set<Integer> getPetsInternal() {
		if (this.pets == null) {
			this.pets = new HashSet<>();
		}
		return this.pets;
	}


	@Override
	public String toString() {
		return new ToStringCreator(this)

				.append("id", this.getId()).append("new", this.isNew()).append("lastName", this.getLastName())
				.append("firstName", this.getFirstName()).append("address", this.address).append("city", this.city)
				.append("telephone", this.telephone).toString();
	}

	public void addPet(@Valid Pet pet) {
		this.pets.add(pet.getId());
		
	}

}
