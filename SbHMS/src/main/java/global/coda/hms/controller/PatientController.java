package global.coda.hms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import global.coda.hms.mapper.PatientMapper;
import global.coda.hms.model.Patient;
import global.coda.hms.service.PatientService;

/**
 * class for patient controller.
 *
 * @author Chandraleka
 *
 */
@RestController
public class PatientController {

  PatientMapper mapper;

  PatientService service;

  /**
   * @param service
   */
  public PatientController(PatientService service) {
    this.service = service;
  }

  /**
   * @return
   */
  @GetMapping("/allPatients")
  public ResponseEntity<List<Patient>> getAll() {
    List<Patient> listPatient = service.getAllPatients();
    return ResponseEntity.status(HttpStatus.OK).body(listPatient);

  }

  /**
   * @param userId
   * @return
   */
  @GetMapping("/{userId}")
  public ResponseEntity<Patient> getById(@PathVariable int userId) {
    Patient patient = service.getPatient(userId);
    return ResponseEntity.status(HttpStatus.OK).body(patient);
  }

  /**
   * @param patient
   * @return
   */
  @PostMapping("/createPatient")
  public ResponseEntity<Integer> createPatient(@RequestBody Patient patient) {
    int noRowsAffected = service.createPatient(patient);
    return ResponseEntity.status(HttpStatus.OK).body(noRowsAffected);

  }

  /**
   * @param userId
   * @return
   */
  @PutMapping("/deletePatient/{userId}")
  public ResponseEntity<Integer> deletePatient(@PathVariable int userId) {
    int noRowsAffected = service.deletePatient(userId);
    return ResponseEntity.status(HttpStatus.OK).body(noRowsAffected);

  }

  /**
   * method for updating patient details.
   *
   * @param patient
   * @return
   */
  @PutMapping("/updatePatient")
  public ResponseEntity<Integer> updatePatient(@RequestBody Patient patient) {
    int noRowsAffected = service.updatePatient(patient);
    return ResponseEntity.status(HttpStatus.OK).body(noRowsAffected);

  }

}
