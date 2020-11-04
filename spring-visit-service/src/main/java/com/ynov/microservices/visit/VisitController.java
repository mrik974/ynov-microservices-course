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
package com.ynov.microservices.visit;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Michael Isvy
 * @author Dave Syer
 */
@RestController
class VisitController {

	private final VisitRepository visits;

	public VisitController(VisitRepository visits) {
		this.visits = visits;
	}

	@GetMapping("/visits")
	public Iterable<Visit> getVisits() {
		return visits.findAll();
	}

	@GetMapping("/visits/{id}")
	public Optional<Visit> getVisitById(@PathVariable("id") Integer id) {
		return visits.findById(id);
	}

	@PostMapping("/visits")
	public Visit addVisit(@RequestParam("date") LocalDate date, @RequestParam("description") String description,
			@RequestParam("petId") Integer petId) {
		Visit visit = new Visit();
		visit.setDate(date);
		visit.setDescription(description);
		visit.setPetId(petId);
		return visits.save(visit);
	}

	@DeleteMapping("/visits/{id}")
	public void deleteVisit(@PathVariable("id") Integer id) {
		visits.deleteById(id);
	}
	
	@GetMapping("/visits/findByPetId/{petId}")
	public Iterable<Visit> findByPetId(@PathVariable("petId") Integer petId) {
		return visits.findByPetId(petId);
	}

}
