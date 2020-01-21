package global.coda.hms.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.mapper.PatientMapper;
import global.coda.hms.model.Patient;
import global.coda.hms.service.PatientService;

/**
 * class for patient controller.
 *
 * @author Chandraleka
 *
 */
@ RestController
@RequestMapping("/patient")
public class PatientController {
  private static final Logger LOGGER = LogManager.getLogger(PatientController.class);

  private PatientMapper mapper;

  private PatientService service;

  /**
   * Constructor foe getting the service object.
   *
   * @param service to access the Service methods
   */
  public PatientController(PatientService service) {
    this.service = service;
  }

  /**
   * method for getting all patients details.
   *
   * @return response to the client
   * @throws SystemException   when there is any exception
   * @throws BusinessException when there is any user mistake with input values
   */
  @ GetMapping("/allPatients")
  public ResponseEntity<List<Patient>> getAll() throws SystemException, BusinessException {
    LOGGER.traceEntry("Getting All Patient Details");
    List<Patient> listPatient = service.getAllPatients();
    LOGGER.traceExit(listPatient);
    return ResponseEntity.status(HttpStatus.OK).body(listPatient);

  }

  /**
   * method for getting patient details.
   *
   * @param userId to get the details
   * @return response to the client
   * @throws SystemException   when there is any exception
   * @throws BusinessException when there is any user mistake with input values
   */
  @ GetMapping("/readPatient/{userId}")
  public ResponseEntity<Patient> getById(@ PathVariable int userId)
      throws SystemException, BusinessException {
    LOGGER.traceEntry(String.valueOf(userId));
    Patient patient = service.getPatient(userId);
    LOGGER.traceExit(patient);
    return ResponseEntity.status(HttpStatus.OK).body(patient);
  }

  /**
   * method for creating patient details.
   *
   * @param patient to create a patient
   * @return response to the client
   * @throws SystemException   when there is any exception
   * @throws BusinessException when there is any user mistake with input values
   */
  @ PostMapping("/createPatient")
  public ResponseEntity<Integer> createPatient(@ RequestBody Patient patient)
      throws SystemException, BusinessException {
    LOGGER.traceEntry(patient.toString());
    int noRowsAffected = service.createPatient(patient);
    LOGGER.traceExit(String.valueOf(noRowsAffected));
    return ResponseEntity.status(HttpStatus.OK).body(noRowsAffected);

  }

  /**
   * method for deleting patient details.
   *
   * @param userId to delete
   * @return response to the client
   * @throws SystemException   when there is any exception
   * @throws BusinessException when there is any user mistake with input values
   */
  @ PutMapping("/deletePatient/{userId}")
  public ResponseEntity<Integer> deletePatient(@ PathVariable int userId)
      throws SystemException, BusinessException {
    LOGGER.traceEntry(String.valueOf(userId));
    int noRowsAffected = service.deletePatient(userId);
    LOGGER.traceExit(String.valueOf(noRowsAffected));
    return ResponseEntity.status(HttpStatus.OK).body(noRowsAffected);

  }

  /**
   * method for updating patient details.
   *
   * @param patient to update
   * @return response to the client
   * @throws SystemException   when there is any exception
   * @throws BusinessException when there is any user mistake with input values
   */
  @ PutMapping("/updatePatient")
  public ResponseEntity<Integer> updatePatient(@ RequestBody Patient patient)
      throws SystemException, BusinessException {
    LOGGER.traceEntry(patient.toString());
    int noRowsAffected = service.updatePatient(patient);
    LOGGER.traceExit(String.valueOf(noRowsAffected));
    return ResponseEntity.status(HttpStatus.OK).body(noRowsAffected);

  }

}
