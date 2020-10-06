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
package com.ynov.microservices.petclinic.vet;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juergen Hoeller
 * @author Mark Fisher
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@RestController
class VetController {

	private final VetRepository vets;
	private final SpecialtyRepository specialties;

	public VetController(VetRepository clinicService, SpecialtyRepository specialties) {
		this.vets = clinicService;
		this.specialties = specialties;
	}

	@GetMapping(path = { "/vets" }, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Collection<Vet> showResourcesVetList() {
		return vets.findAll();
	}

	@PostMapping(path = "/vets")
	public Vet addVet(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
			@RequestParam("firstSpecialty") String firstSpecialty) {
		Vet vet = new Vet();
		vet.setFirstName(firstName);
		vet.setLastName(lastName);

		Specialty specialty = new Specialty();
		specialty.setName(firstSpecialty);
		specialties.save(specialty);
		vet.addSpecialty(specialty);
		return vets.save(vet);
	}

}
