package global.coda.hms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import global.coda.hms.controller.PatientController;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.mapper.DoctorMapper;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.Patient;

/**
 * class for Doctor Service.
 *
 * @author Chandraleka
 *
 */
@ Transactional
@ Service
public class DoctorService {
  private static final Logger LOGGER = LogManager.getLogger(PatientController.class);

  private DoctorMapper mapper;

  /**
   * constructor to get mapper object.
   *
   * @param mapper to access
   */
  public DoctorService(DoctorMapper mapper) {
    this.mapper = mapper;
  }

  /**
   * method to get all Doctor details.
   *
   * @return list of Doctor details
   * @throws SystemException   when there is any exception with system
   * @throws BusinessException when there is any user mistake with input values
   */
  public List<Doctor> getAllDoctors() throws SystemException, BusinessException {
    LOGGER.traceEntry("Getting All Doctor Details");
    List<Doctor> listDoctor = null;
    try {
      listDoctor = mapper.getAllDoctors();
      if (listDoctor != null && !listDoctor.isEmpty()) {
        LOGGER.traceExit(listDoctor.toString());
        return listDoctor;
      } else {
        throw new SystemException("Error while getting doctors data");
      }
    } catch (Exception exception) {
      LOGGER.info(exception);
      throw new SystemException("Error while getting doctors data",exception);
    }

  }

  /**
   * method to get Doctor details.
   *
   * @param userId to get Doctor details
   * @return doctor bean
   * @throws SystemException   when there is any exception with system
   * @throws BusinessException when there is any user mistake with input values
   */
  public Doctor getDoctor(int userId) throws SystemException, BusinessException {
    LOGGER.traceEntry(String.valueOf(userId));
    Doctor doctorData = null;
    try {
      doctorData = mapper.getDoctor(userId);
      if (doctorData != null && doctorData.getUserId() != 0) {
        LOGGER.traceExit(doctorData.toString());
        return doctorData;

      } else {
        throw new SystemException("Error while getting doctor details for given id");
      }
    } catch (Exception exception) {
      LOGGER.info(exception);
      throw new SystemException("Error while getting doctor details for given id",exception);
    }
  }

  /**
   * method to delete a Doctor from db.
   *
   * @param userId to delete a Doctor
   * @return no of rows affected
   * @throws SystemException   when there is any exception with system
   * @throws BusinessException when there is any user mistake with input values
   */
  public int deleteDoctor(int userId) throws SystemException, BusinessException {
    LOGGER.traceEntry(String.valueOf(userId));
    int noRowsAffected = 0;
    try {
      noRowsAffected = mapper.deleteDoctor(userId);
      if (noRowsAffected != 0) {
        LOGGER.traceExit(String.valueOf(noRowsAffected));
        return noRowsAffected;
      } else {
        throw new SystemException("Error while deleting doctor details for given id");
      }
    } catch (Exception exception) {
      LOGGER.info(exception);
      throw new SystemException("Error while deleting doctor details for given id",exception);
    }
  }

  /**
   * method to update Doctor.
   *
   * @param doctor update a Doctor
   * @return no of rows affected
   * @throws SystemException   when there is any exception with system
   * @throws BusinessException when there is any user mistake with input values
   */
  public int updateDoctor(Doctor doctor) throws SystemException, BusinessException {
    LOGGER.traceEntry(doctor.toString());
    int noRowsAffected = 0;
    try {
      noRowsAffected = mapper.updateDoctor(doctor);
      if (noRowsAffected != 0) {
        LOGGER.traceExit(String.valueOf(noRowsAffected));
        return noRowsAffected;
      } else {
        throw new SystemException("Error while updating doctor details for given data");
      }
    } catch (Exception exception) {
      LOGGER.info(exception);
      throw new SystemException("Error while updating doctor details for given data",exception);
    }
  }

  /**
   * method to create a Doctor in db.
   *
   * @param doctor to create
   * @return no of rows affected
   * @throws SystemException   when there is any exception with system
   * @throws BusinessException when there is any user mistake with input values
   */
  @ Transactional(rollbackOn = SystemException.class)
  public int createDoctor(Doctor doctor) throws SystemException, BusinessException {
    LOGGER.traceEntry(doctor.toString());
    int noRowsAffectedInUser = 0;
    int noRowsAffectedInDoctor = 0;
    try {
      noRowsAffectedInUser = mapper.createUser(doctor);
      if (noRowsAffectedInUser != 0) {
        noRowsAffectedInDoctor = mapper.createDoctor(doctor);
        if (noRowsAffectedInDoctor != 0) {
          LOGGER.traceExit(String.valueOf(noRowsAffectedInDoctor));
          return noRowsAffectedInDoctor;
        }
        else {
          throw new SystemException("Error while creating doctor details for given data");
        }
      } else {
        throw new SystemException("Error while creating doctor details for given data");
      }
    } catch (Exception exception) {
      LOGGER.info(exception);
      throw new SystemException("Error while creating doctor details for given data",exception);
    }


  }

  /**
   * method to get all patients under a doctor.
   *
   * @param userId to get all patients
   * @return list of patients under a doctor
   * @throws SystemException   when there is any exception with system
   * @throws BusinessException when there is any user mistake with input values
   */
  public List<Patient> getPatientsUnderDoctor(int userId)
      throws SystemException, BusinessException {
    LOGGER.traceEntry(String.valueOf(userId));
    List<Patient> patientList = null;
    try {
      patientList = mapper.getPatientsUnderDoctor(userId);
      if (patientList != null && !patientList.isEmpty()) {
        LOGGER.traceExit(patientList.toString());
        return patientList;
      } else {
        throw new SystemException("Error while getting all patient details for given doctor id");
      }
    } catch (Exception exception) {
      LOGGER.info(exception);
      throw new SystemException("Error while getting all patient details for given doctor id",exception);
    }
  }

  /**
   * method to get all patients under all doctors.
   *
   * @return list of patients under doctors
   * @throws SystemException   when there is any exception with system
   * @throws BusinessException when there is any user mistake with input values
   */
  public List<Doctor> getAllPatientsUnderAllDoctors() throws SystemException, BusinessException {
    LOGGER.traceEntry("Getting all patients under all doctors");
    List<Doctor> doctorList = null;
    try {
      doctorList = mapper.getAllPatientsUnderAllDoctors();
      if (doctorList != null && !doctorList.isEmpty()) {
        LOGGER.traceExit(doctorList.toString());
        return doctorList;
      } else {
        throw new SystemException("Error while getting all patient details for all doctors");
      }
    } catch (Exception exception) {
      LOGGER.info(exception);
      throw new SystemException("Error while getting all patient details for all doctors",exception);
    }
  }
}
