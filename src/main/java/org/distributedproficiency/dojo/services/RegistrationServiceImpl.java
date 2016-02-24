package org.distributedproficiency.dojo.services;

import java.util.Collection;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.distributedproficiency.dojo.domain.Registration;
import org.distributedproficiency.dojo.domain.RegistrationStatus;
import org.distributedproficiency.dojo.domain.Student;
import org.distributedproficiency.dojo.domain.User;
import org.distributedproficiency.dojo.dto.InitiatedRegistrationResponse;
import org.distributedproficiency.dojo.dto.RegistrationRequest;
import org.distributedproficiency.dojo.repository.RegistrationRepository;
import org.distributedproficiency.dojo.repository.StudentRepository;
import org.distributedproficiency.dojo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentRepository patientRepository;
	
	
	@Autowired
	private UserService userService;
	
	@Override
	public void registerPatient(String key, RegistrationRequest r) throws StudentAlreadyExistsException {
		// first check whether there is already a user for the 
		Registration registration = registrationRepository.findByRegistrationKey(key);
		if (registration != null) {
			if (registration.getStatus() == RegistrationStatus.INITIATED) {
				
				Student p = new Student();
				p.setFirstName(r.getFirstName());
				p.setLastName(r.getLastName());
				p.setEmail(r.getEmail());
				p.setPhone(r.getPrimaryPhone());
				
				try {
					// create the user
					User user = userService.createUserWithUsernameAndType(r.getUsername(), null, null);
					userRepository.save(user);
					
					// create the patient
					patientRepository.save(p);
					
				} catch (Exception e) {
					throw new StudentAlreadyExistsException("Unable to register patient", e);
				}
			} else {
				;// TODO decide on the response when the token has been invalidated!
			}
		}
	}

	@Override
	public Collection<Registration> getAllRegistrations() {
		return registrationRepository.findAll();
	}

	@Override
	public Registration getRegistrationById(Long id) {
		return registrationRepository.findOne(id);
	}

	@Override
	public void approveRegistration(Long id) {
		Registration r = registrationRepository.findOne(id);
		if (r != null) {
			if (r.getStatus() == RegistrationStatus.COMPLETED) {
				r.setStatus(RegistrationStatus.APPROVED);
			}
			
			registrationRepository.save(r);
		}
	}
	
	

	@Override
	public InitiatedRegistrationResponse initiateRegistration() {
		Registration r = new Registration();
		
		r.setInitiatedDateTime(new Date());
		r.setStatus(RegistrationStatus.INITIATED);
		
		String registrationKey = generateRandomAlphaCode();
		r.setRegistrationKey(registrationKey);
		
		Registration saved = registrationRepository.save(r);
		
		InitiatedRegistrationResponse response = new
				InitiatedRegistrationResponse();
		response.setRegistrationId(saved.getId());
		response.setRegistrationKey(registrationKey);
		return response;
	}

	private String generateRandomAlphaCode() {
		char[] pool = new char[] {
			'A', 'B', 'C', 'D', 'E', 'F',
			'G', 'H', 'I', 'J', 'K', 'L',
			'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z'
		};
		
		Random r = new Random();
		r.setSeed(System.currentTimeMillis());
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			double g = r.nextDouble();
			double l = new Integer(pool.length).doubleValue();
			int idx = new Double(g * l).intValue();
			buf.append(pool[idx]);
		}
		return buf.toString();
	}

	@Override
	public void invalidateMissedRegistrations() {
		Collection<Registration> registrations = registrationRepository.findAll();
		
		for (Registration a : registrations) {
			Date currentDate = new Date();
			// if the appointment date is in the past - the patient has missed
			// their appointment. Mark the appointment as Missed.
			// active window is 10 minutes from initiation time
			long delayMillis = TimeUnit.MINUTES.toMillis(10);
			long activeTime = a.getInitiatedDateTime().getTime() + delayMillis;
			if (a.getStatus() == RegistrationStatus.INITIATED && currentDate.getTime() > activeTime) {
				a.setStatus(RegistrationStatus.MISSED);
				registrationRepository.save(a);
			}
		}
	}
	

}
