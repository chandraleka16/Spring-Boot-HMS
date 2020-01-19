package global.coda.hms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import global.coda.hms.constant.ApplicationConstant;
import global.coda.hms.model.Patient;

/**
 * Interface for Patient Mapper.
 *
 * @author Chandraleka
 *
 */
@ Mapper
public interface PatientMapper {

  /**
   * method to read patient in db.
   *
   * @param userId to read patient
   * @return patient details
   */
  @ Select(ApplicationConstant.HMSPR001)
  Patient getPatient(int userId);

  /**
   * method to get all patients in db.
   *
   * @return all patients details
   */
  @ Select(ApplicationConstant.HMSPAR001)
  List<Patient> getAllPatients();

  /**
   * method to delete patient in db.
   *
   * @param userId to delete
   * @return number of rows affected
   */
  @ Update(ApplicationConstant.HMSPD001)
  int deletePatient(int userId);

  /**
   * method to update patient details in db.
   *
   * @param patient to update
   * @return number of rows affected
   */
  @ Update(ApplicationConstant.HMSUU001)
  int updatePatient(Patient patient);

  /**
   * method to create user in db.
   *
   * @param patient to create user
   * @return number of rows affected
   */
  @ Insert(ApplicationConstant.HMSUC001)
  @ Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "pk_user_id")
  int createUser(Patient patient);

  /**
   * method to create patient in db.
   *
   * @param patient to create
   * @return number of rows affected
   */
  @ Insert(ApplicationConstant.HMSPC001)
  int createPatient(Patient patient);
}
