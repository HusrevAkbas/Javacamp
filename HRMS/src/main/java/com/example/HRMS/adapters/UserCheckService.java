package com.example.HRMS.adapters;

import com.example.HRMS.entities.concretes.Candidate;

public interface UserCheckService {
	boolean checkIfRealPerson(Candidate candidate);
}
