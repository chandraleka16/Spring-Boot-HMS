package global.coda.hms.model;

import java.util.List;

/**
 * Doctor Bean class.
 *
 * @author CHANDRALEKA
 *
 */
public class Doctor extends User {
  private String doctorSpecialization;
  private int doctorExperience;
  private List<Patient> patientList;

  /**
   * method to get list of patients under doctor.
   *
   * @return list of patients under doctor
   */
  public List<Patient> getPatientList() {
    return patientList;
  }

  /**
   * method to set list of patients under doctor.
   *
   * @param patientList to set list of patients under doctor
   */
  public void setPatientList(List<Patient> patientList) {
    this.patientList = patientList;
  }

  /**
   * method to get doctor specialization.
   *
   * @return doctor specialization
   */
  public String getDoctorSpecialization() {
    return doctorSpecialization;
  }

  /**
   * method to set doctor specialization.
   *
   * @param doctorSpecialization to set
   */
  public void setDoctorSpecialization(String doctorSpecialization) {
    this.doctorSpecialization = doctorSpecialization;
  }

  /**
   * method to get doctor experience.
   *
   * @return doctor experience
   */
  public int getDoctorExperience() {
    return doctorExperience;
  }

  /**
   * method to set doctor experience.
   *
   * @param doctorExperience to set
   */
  public void setDoctorExperience(int doctorExperience) {
    this.doctorExperience = doctorExperience;
  }
}
