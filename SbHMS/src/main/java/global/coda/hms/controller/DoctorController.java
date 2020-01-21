package global.coda.hms.controller;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.Patient;
import global.coda.hms.service.DoctorService;

/**
 * class for Doctor controller.
 *
 * @author Chandraleka
 *
 */
@ RestController
@ RequestMapping("/doctor")
public class DoctorController {
  private static final Logger LOGGER = LogManager.getLogger(PatientController.class);
  private DoctorService service;

  /**
   * Constructor foe getting the service object.
   *
   * @param service to access the Service methods
   */
  public DoctorController(DoctorService service) {
    this.service = service;
  }

  // public DoctorController(DoctorMapper mapper) {
  // this.mapper = mapper;
  // }

  /**
   * method for getting all Doctor details.
   *
   * @return response to the client
   * @throws SystemException   when there is any exception with system
   * @throws BusinessException when there is any user mistake with input values
   */
  @ GetMapping("/readAllDoctors")
  public ResponseEntity<JSONObject> getAll(HttpServletRequest request)
      throws SystemException, BusinessException {
    LOGGER.info("Getting All Doctor Details");
    List<Doctor> listDoctor = service.getAllDoctors();
    UUID id = (UUID) request.getAttribute("RequestId");
    JSONObject object = new JSONObject();
    object.put("RequestId", id);
    object.put("StatusCode", "200");
    object.put("Message", listDoctor);
    LOGGER.info(listDoctor + id.toString());
    return ResponseEntity.status(HttpStatus.OK).body(object);

  }

  /**
   * method for getting patient details.
   *
   * @param userId to get the details
   * @return response to the client
   * @throws SystemException   when there is any exception with system
   * @throws BusinessException when there is any user mistake with input values
   */
  @ GetMapping("/readDoctors/{userId}")
  public ResponseEntity<List<Doctor>> getById(@ PathVariable int userId)
      throws SystemException, BusinessException {
    LOGGER.traceEntry(String.valueOf(userId));
    List<Doctor> doctor = service.getDoctor(userId);
    LOGGER.traceExit(doctor.toString());
    return ResponseEntity.status(HttpStatus.OK).body(doctor);
  }

  /**
   * method for creating Doctor details.
   *
   * @param doctor to create a doctor
   * @return response to the client
   * @throws SystemException   when there is any exception with system
   * @throws BusinessException when there is any user mistake with input values
   */
  @ PostMapping("/createDoctor")
  public ResponseEntity<Integer> createDoctor(@ RequestBody Doctor doctor)
      throws SystemException, BusinessException {
    LOGGER.traceEntry(doctor.toString());
    int noRowsAffected = service.createDoctor(doctor);
    LOGGER.traceExit(String.valueOf(noRowsAffected));
    return ResponseEntity.status(HttpStatus.OK).body(noRowsAffected);

  }

  /**
   * method for deleting Doctor details.
   *
   * @param userId to delete
   * @return response to the client
   * @throws SystemException   when there is any exception with system
   * @throws BusinessException when there is any user mistake with input values
   */
  @ PutMapping("/deleteDoctor/{userId}")
  public ResponseEntity<Integer> deleteDoctor(@ PathVariable int userId)
      throws SystemException, BusinessException {
    LOGGER.traceEntry(String.valueOf(userId));
    int noRowsAffected = service.deleteDoctor(userId);
    LOGGER.traceExit(String.valueOf(noRowsAffected));
    return ResponseEntity.status(HttpStatus.OK).body(noRowsAffected);

  }

  /**
   * method for updating Doctor details.
   *
   * @param doctor to update
   * @return response to the client
   * @throws SystemException   when there is any exception with system
   * @throws BusinessException when there is any user mistake with input values
   */
  @ PutMapping("/updateDoctor")
  public ResponseEntity<Integer> updateDoctor(@ RequestBody Doctor doctor)
      throws SystemException, BusinessException {
    LOGGER.traceEntry(doctor.toString());
    int noRowsAffected = service.updateDoctor(doctor);
    LOGGER.traceExit(String.valueOf(noRowsAffected));
    return ResponseEntity.status(HttpStatus.OK).body(noRowsAffected);

  }

  /**
   * method to get all patients under a doctor.
   *
   * @param userId to get patients list
   * @return response to the client
   * @throws SystemException   when there is any exception with system
   * @throws BusinessException when there is any user mistake with input values
   */
  @ GetMapping("/patientsUnderDoctor/{userId}")
  public ResponseEntity<List<Patient>> getPatientsUnderDoctor(@ PathVariable int userId)
      throws SystemException, BusinessException {
    LOGGER.traceEntry(String.valueOf(userId));
    List<Patient> patientList = service.getPatientsUnderDoctor(userId);
    LOGGER.traceExit(patientList.toString());
    return ResponseEntity.status(HttpStatus.OK).body(patientList);

  }

  /**
   * method to get all patients under a doctor.
   *
   * @return response to the client
   * @throws SystemException   when there is any exception with system
   * @throws BusinessException when there is any user mistake with input values
   */
  @ GetMapping("/patientsUnderAllDoctors")
  public ResponseEntity<Map<Integer, Doctor>> getAllPatientsUnderAllDoctor(
      @ RequestAttribute("RequestId") String requestId)
      throws SystemException, BusinessException {
    LOGGER.traceEntry("Getting all Patients under all Doctors");

    Map<Integer, Doctor> doctorList = service.getAllPatientsUnderAllDoctors();

    LOGGER.info(doctorList.toString(), requestId);
    return ResponseEntity.status(HttpStatus.OK).body(doctorList);

  }
}
