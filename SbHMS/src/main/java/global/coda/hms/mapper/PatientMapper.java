package global.coda.hms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import global.coda.hms.model.Patient;

@Mapper
public interface PatientMapper {

  @Select("SELECT pk_user_id as user_id,user_name,user_password, user_age, user_gender, user_mobile_number, user_email_id, user_address_line1, user_address_line2, user_address_line3,fk_role_id as user_role_id, patient_disease FROM t_user JOIN t_patient ON t_user.pk_user_id=t_patient.fk_user_id WHERE t_user.is_delete=0 and t_user.pk_user_id=#{userId}")
  Patient getPatient(int userId);

  @Select("SELECT pk_user_id as user_id,user_name,user_password, user_age, user_gender, user_mobile_number, user_email_id, user_address_line1, user_address_line2, user_address_line3,fk_role_id as user_role_id, patient_disease FROM t_user JOIN t_patient ON t_user.pk_user_id=t_patient.fk_user_id WHERE t_user.is_delete=0")
  List<Patient> getAllPatients();


  @Update("UPDATE t_user SET is_delete = 1 WHERE pk_user_id = #{userId} AND is_delete= 0")
  int deletePatient(int userId);

  @Update("UPDATE t_user SET user_name = #{userName}, user_password=#{userPassword}, user_age=#{userAge}, user_gender=#{userGender}, user_mobile_number=#{userMobileNumber}, user_email_id=#{userEmailId}, user_address_line1=#{userAddressLine1}, user_address_line2=#{userAddressLine2}, user_address_line3 = #{userAddressLine3} WHERE pk_user_id = #{userId}")
  int updatePatient(Patient patient);

  @Insert("INSERT INTO t_user (user_name, user_password, user_age, user_gender, user_mobile_number, user_email_id, user_address_line1, user_address_line2, user_address_line3, fk_role_id) VALUES (#{userName}, #{userPassword}, #{userAge}, #{userGender}, #{userMobileNumber}, #{userEmailId}, #{userAddressLine1}, #{userAddressLine2}, #{userAddressLine3}, 4)")
  @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "pk_user_id")
  int createUser(Patient patient);
  @Insert("INSERT INTO t_patient (fk_user_id,patient_disease) VALUES (#{userId},#{patientDisease})")
  int createPatient(Patient patient);
}
