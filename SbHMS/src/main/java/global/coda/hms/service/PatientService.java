package global.coda.hms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import global.coda.hms.mapper.PatientMapper;
import global.coda.hms.model.Patient;

@Service
public class PatientService {

  PatientMapper mapper;

  public PatientService(PatientMapper mapper) {
    this.mapper = mapper;
  }

  public List<Patient> getAllPatients() {

    return mapper.getAllPatients();

  }

  public Patient getPatient(int userId) {

    return mapper.getPatient(userId);
  }

  public int deletePatient(int userId) {
    if (mapper.deletePatient(userId) == 1) {
      return 1;
    } else {
      return 0;
    }

    // return mapper.deletePatient(userId);
  }

  public int updatePatient(Patient patient) {
    if (mapper.updatePatient(patient) == 1) {
      return 1;
    } else {
      return 0;
    }
  }

  public int createPatient(Patient patient) {

    mapper.createUser(patient);
    int result = mapper.createPatient(patient);
    return result;
  }
}
