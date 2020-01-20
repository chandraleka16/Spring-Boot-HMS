package global.coda.hms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import global.coda.hms.constant.ApplicationConstant;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.Patient;

/**
 * Interface for Doctor Mapper.
 *
 * @author Chandraleka
 *
 */
@ Mapper
public interface DoctorMapper {
  Patient patient = null;
  Doctor doctor = null;

  /**
   * method to get doctor details from db.
   *
   * @param userId to get doctor details
   * @return doctor details
   */
  @ Results({ @ Result(property = "userId", column = "pk_user_id"),
    @ Result(property = "userRoleId", column = "fk_role_id"),
    @ Result(property = "userId", column = "fk_user_id"),
    @ Result(property = "userName", column = "user_name"),
    @ Result(property = "userPassword", column = "user_password"),
    @ Result(property = "userAge", column = "user_age"),
    @ Result(property = "userGender", column = "user_gender"),
    @ Result(property = "userMobileNumber", column = "user_mobile_number"),
    @ Result(property = "userEmailId", column = "user_email_id"),
    @ Result(property = "userAddressLine1", column = "user_address_line1"),
    @ Result(property = "userAddressLine2", column = "user_address_line2"),
    @ Result(property = "userAddressLine3", column = "user_address_line3"),
    @ Result(property = "patientDisease", column = "patient_disease"),
    @ Result(property = "doctorSpecialization", column = "doctor_specialization"),
    @ Result(property = "doctorExperience", column = "doctor_experience") })

  @ Select({ ApplicationConstant.HMSDR001 })
  List<Doctor> getDoctor(int userId);

  /**
   * method to read all doctors in db.
   *
   * @return list of doctors
   */
  @ Results({ @ Result(property = "userId", column = "pk_user_id"),
    @ Result(property = "userRoleId", column = "fk_role_id"),
    @ Result(property = "userId", column = "fk_user_id"),
    @ Result(property = "userName", column = "user_name"),
    @ Result(property = "userPassword", column = "user_password"),
    @ Result(property = "userAge", column = "user_age"),
    @ Result(property = "userGender", column = "user_gender"),
    @ Result(property = "userMobileNumber", column = "user_mobile_number"),
    @ Result(property = "userEmailId", column = "user_email_id"),
    @ Result(property = "userAddressLine1", column = "user_address_line1"),
    @ Result(property = "userAddressLine2", column = "user_address_line2"),
    @ Result(property = "userAddressLine3", column = "user_address_line3"),
    @ Result(property = "patientDisease", column = "patient_disease"),
    @ Result(property = "doctorSpecialization", column = "doctor_specialization"),
    @ Result(property = "doctorExperience", column = "doctor_experience") })

  @ Select(ApplicationConstant.HMSDAR001)
  List<Doctor> getAllDoctors();

  /**
   * method to delete doctor in db.
   *
   * @param userId to delete
   * @return number of rows affected
   */
  @ Update(ApplicationConstant.HMSDD001)
  int deleteDoctor(int userId);

  /**
   * method to update doctor details.
   *
   * @param doctor to update
   * @return number of rows affected
   */
  @ Update({ApplicationConstant.HMSUU001})
  int updateDoctor(Doctor doctor);

  /**
   * method to create user in db.
   *
   * @param doctor to create
   * @return number of rows affected
   */
  @ Insert(ApplicationConstant.HMSUC001)
  @ Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "pk_user_id")
  int createUser(Doctor doctor);

  /**
   * method to create doctor.
   *
   * @param doctor to create
   * @return number of rows affected
   */
  @ Insert(ApplicationConstant.HMSDC001)
  int createDoctor(Doctor doctor);

  /**
   * method to get all patients under a doctor.
   *
   * @param userId to get all patients
   * @return list of patients
   */
  @ Results({ @ Result(property = "userId", column = "pk_user_id"),
    @ Result(property = "userRoleId", column = "fk_role_id"),
    @ Result(property = "userId", column = "fk_user_id"),
    @ Result(property = "userName", column = "user_name"),
    @ Result(property = "userPassword", column = "user_password"),
    @ Result(property = "userAge", column = "user_age"),
    @ Result(property = "userGender", column = "user_gender"),
    @ Result(property = "userMobileNumber", column = "user_mobile_number"),
    @ Result(property = "userEmailId", column = "user_email_id"),
    @ Result(property = "userAddressLine1", column = "user_address_line1"),
    @ Result(property = "userAddressLine2", column = "user_address_line2"),
    @ Result(property = "userAddressLine3", column = "user_address_line3"),
    @ Result(property = "patientDisease", column = "patient_disease") })
  @ Select(ApplicationConstant.HMSPUD001)
  List<Patient> getPatientsUnderDoctor(int userId);

  /**
   * method to get all patients under all doctors.
   *
   * @return list of doctors
   */
  @ Select(ApplicationConstant.HMSDAR001)
  @ Results({ @ Result(property = "userId", column = "pk_user_id"),
    @ Result(property = "userRoleId", column = "fk_role_id"),
    @ Result(property = "userId", column = "fk_user_id"),
    @ Result(property = "userName", column = "user_name"),
    @ Result(property = "userPassword", column = "user_password"),
    @ Result(property = "userAge", column = "user_age"),
    @ Result(property = "userGender", column = "user_gender"),
    @ Result(property = "userMobileNumber", column = "user_mobile_number"),
    @ Result(property = "userEmailId", column = "user_email_id"),
    @ Result(property = "userAddressLine1", column = "user_address_line1"),
    @ Result(property = "userAddressLine2", column = "user_address_line2"),
    @ Result(property = "userAddressLine3", column = "user_address_line3"),
    @ Result(property = "patientDisease", column = "patient_disease"),
    @ Result(property = "doctorSpecialization", column = "doctor_specialization"),
    @ Result(property = "doctorExperience", column = "doctor_experience"),
    @ Result(property = "patientList", column = "pk_user_id", javaType = List.class, many = @ Many(select = "getPatientsUnderDoctor")) })
  @ MapKey("userId")
  Map<Integer, Doctor> getAllPatientsUnderAllDoctors();


}
