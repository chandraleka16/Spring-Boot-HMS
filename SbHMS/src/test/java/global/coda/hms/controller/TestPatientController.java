package global.coda.hms.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import global.coda.hms.model.Patient;

public class TestPatientController {
  @ Autowired
  private MockMvc mockMvc;
  @ Autowired
  public PatientController patientController;
  public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
      MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(),
      Charset.forName("utf8"));

  /**
   * test method to read all patients.
   * 
   * @throws Exception when there is any system error
   */
  @ Test
  public void readAllPatientsTest() throws Exception {
    this.mockMvc.perform(get("/patients/allPatients")).andExpect(status().isOk());
  }

  /**
   * test method to read patient using id.
   * 
   * @throws Exception when there is any system error
   */
  @ Test
  public void readPatientTest() throws Exception {
    this.mockMvc.perform(get("/doctors/readPatient/9")).andExpect(status().isOk());
  }

  /**
   * test method to delete patient.
   * 
   * @throws Exception when there is any system error
   */
  @ Test
  public void deletePatientRecordTest() throws Exception {
    this.mockMvc.perform(put("/patients/deletePatient/9")).andExpect(status().isOk());
  }

  /**
   * test method to create a new patient in db.
   * 
   * @throws Exception when there is any system error
   */
  @ Test
  public void createPatientTest() throws Exception {
    Patient patient = new Patient();
    patient.setUserName("manojkumar");
    patient.setUserPassword("manoj123");
    patient.setUserAge(26);
    patient.setUserGender("M");
    patient.setUserMobileNumber("8903452167");
    patient.setUserEmailId("manoj123@gmail.com");
    patient.setUserAddressLine1("no.5");
    patient.setUserAddressLine2("4th street,rk nagar");
    patient.setUserAddressLine3("kovai");
    patient.setPatientDisease("cancer");
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
    String requestJson = ow.writeValueAsString(patient);
    mockMvc.perform(
        post("/patients/createPatient").contentType(APPLICATION_JSON_UTF8).content(requestJson))
        .andExpect(status().isOk());
  }

  /**
   * test method to update patient details.
   * 
   * @throws Exception when there is any system error
   */
  @ Test
  public void updatePatientTest() throws Exception {
    Patient patient = new Patient();
    patient.setUserId(10);
    patient.setUserName("divya");
    patient.setUserPassword("divyaj123");
    patient.setUserAge(28);
    patient.setUserGender("F");
    patient.setUserMobileNumber("8903456167");
    patient.setUserEmailId("divyaj123@gmail.com");
    patient.setUserAddressLine1("no.5");
    patient.setUserAddressLine2("4th street,rk nagar");
    patient.setUserAddressLine3("erode");
    patient.setPatientDisease("cancer");
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
    String requestJson = ow.writeValueAsString(patient);
    mockMvc.perform(
        put("/patients/updatePatient").contentType(APPLICATION_JSON_UTF8).content(requestJson))
        .andExpect(status().isOk());
  }

}
