package com.example.HRMS.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

import com.example.HRMS.entities.concretes.Candidate;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Component
public class MernisServiceAdapter implements UserCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		return true;
//		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
//
//		boolean result = false;		
//		
//		try {
//			result = client.TCKimlikNoDogrula(
//					Long.parseLong(candidate.getNationalIdNumber()), 
//					candidate.getFirstName(), 
//					candidate.getLastName(), 
//					candidate.getBirthYear());
//			return result;
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		return result;
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		return result;
//		}
	}
}
