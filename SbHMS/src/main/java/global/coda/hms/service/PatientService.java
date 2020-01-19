package global.coda.hms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import global.coda.hms.controller.PatientController;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.mapper.PatientMapper;
import global.coda.hms.model.Patient;

/**
 * class for Patient Service.
 *
 * @author Chandraleka
 *
 */
@ Transactional
@ Service
public class PatientService {
  private static final Logger LOGGER = LogManager.getLogger(PatientController.class);

  private PatientMapper mapper;

  /**
   * constructor to get mapper object.
   *
   * @param mapper to access
   */
  public PatientService(PatientMapper mapper) {
    this.mapper = mapper;
  }

  /**
   * method to get all patient details.
   *
   * @return list of patient details
   * @throws SystemException   when there is any exception
   * @throws BusinessException when there is any user mistake with input values
   */
  public List<Patient> getAllPatients() throws SystemException, BusinessException {
    LOGGER.traceEntry("Getting all patients under a doctor");
    List<Patient> listPatient = null;
    try {
      listPatient = mapper.getAllPatients();
      if (listPatient != null && !listPatient.isEmpty()) {
        LOGGER.traceExit(listPatient.toString());
        return listPatient;
      } else {
        throw new SystemException("Error while getting patients data");
      }
    } catch (Exception exception) {
      LOGGER.info(exception);
      throw new SystemException("Error while getting patients data", exception);
    }

  }

  /**
   * method to get patient details.
   *
   * @param userId to get patient details
   * @return patient bean
   * @throws SystemException   when there is any exception
   * @throws BusinessException when there is any user mistake with input values
   */
  public Patient getPatient(int userId) throws SystemException, BusinessException {
    LOGGER.traceEntry(String.valueOf(userId));
    Patient patientData = null;
    try {
      patientData = mapper.getPatient(userId);
      if (patientData != null && patientData.getUserId() != 0) {
        LOGGER.traceExit(patientData.toString());
        return patientData;

      } else {
        throw new SystemException("Error while getting patient data for given id");
      }
    } catch (Exception exception) {
      LOGGER.info(exception);
      throw new SystemException("Error while getting patient data for given id", exception);
    }
  }

  /**
   * method to delete a patient from db.
   *
   * @param userId to delete a patient
   * @return no of rows affected
   * @throws SystemException   when there is any exception.
   * @throws BusinessException when there is any user mistake with input values
   */
  public int deletePatient(int userId) throws SystemException, BusinessException {
    LOGGER.traceEntry(String.valueOf(userId));
    int noRowsAffected = 0;
    try {
      noRowsAffected = mapper.deletePatient(userId);
      if (noRowsAffected != 0) {
        LOGGER.traceExit(String.valueOf(noRowsAffected));
        return noRowsAffected;
      } else {
        throw new SystemException("Error while deleting patient data for given id");
      }
    } catch (Exception exception) {
      LOGGER.info(exception);
      throw new SystemException("Error while deleting patient data for given id", exception);
    }
  }

  /**
   * method to update patient.
   *
   * @param patient update a patient
   * @return no of rows affected
   * @throws SystemException   when there is any exception.
   * @throws BusinessException when there is any user mistake with input values
   */
  public int updatePatient(Patient patient) throws SystemException, BusinessException {
    LOGGER.traceEntry(patient.toString());
    int noRowsAffected = 0;
    try {
      noRowsAffected = mapper.updatePatient(patient);
      if (noRowsAffected != 0) {
        LOGGER.traceExit(String.valueOf(noRowsAffected));
        return noRowsAffected;
      } else {
        throw new SystemException("Error while updating patient data for given data");
      }
    } catch (Exception exception) {
      LOGGER.info(exception);
      throw new SystemException("Error while updating patient data for given data", exception);
    }
  }

  /**
   * method to create a patient in db.
   *
   * @param patient to create
   * @return no of rows affected
   * @throws SystemException   when there is any issue in system
   * @throws BusinessException when there is any user mistake with input values
   */
  @ Transactional(rollbackOn = SystemException.class)
  public int createPatient(Patient patient) throws SystemException, BusinessException {
    LOGGER.traceEntry(patient.toString());
    int noRowsAffectedInUser = 0;
    int noRowsAffectedInPatient = 0;
    try {
      noRowsAffectedInUser = mapper.createUser(patient);
      if (noRowsAffectedInUser != 0) {
        noRowsAffectedInPatient = mapper.createPatient(patient);
        if (noRowsAffectedInPatient != 0) {
          LOGGER.traceExit(String.valueOf(noRowsAffectedInPatient));
          return noRowsAffectedInPatient;
        } else {
          throw new SystemException("Error while creating patient data for given data");
        }
      } else {
        throw new SystemException("Error while creating patient data for given data");
      }
    } catch (Exception exception) {
      LOGGER.info(exception);
      throw new SystemException("Error while creating patient data for given data", exception);
    }
  }
}
