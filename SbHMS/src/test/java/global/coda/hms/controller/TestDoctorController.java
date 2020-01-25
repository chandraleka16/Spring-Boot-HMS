package global.coda.hms.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import global.coda.hms.model.Doctor;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@ SpringBootTest
@ AutoConfigureMockMvc
public class TestDoctorController {
  @ Autowired
  private MockMvc mockMvc;
  @ Autowired
  public DoctorController doctorController;
  public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
      MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(),
      Charset.forName("utf8"));

  @ Test
  public void readAllDoctorsTest() throws Exception {
    this.mockMvc.perform(get("/doctors/readAllDoctors")).andExpect(status().isOk());
  }

  @ Test
  public void deleteDoctorTest() throws Exception {
    this.mockMvc.perform(put("/doctors/deleteDoctor/5")).andExpect(status().isOk());
  }

  @ Test
  public void createDoctorTest() throws Exception {
    Doctor doctor = new Doctor();
    doctor.setUserName("manojkumar");
    doctor.setUserPassword("manoj123");
    doctor.setUserAge(30);
    doctor.setUserGender("M");
    doctor.setUserMobileNumber("8903452167");
    doctor.setUserEmailId("manoj123@gmail.com");
    doctor.setUserAddressLine1("no.5");
    doctor.setUserAddressLine2("4th street,rk nagar");
    doctor.setUserAddressLine3("kovai");
    doctor.setDoctorExperience(4);
    doctor.setDoctorSpecialization("cardiologist");
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
    String requestJson = ow.writeValueAsString(doctor);
    mockMvc
        .perform(
            post("/doctors/createDoctor").contentType(APPLICATION_JSON_UTF8).content(requestJson))
        .andExpect(status().isOk());
  }

  @ Test
  public void updateDoctorTest() throws Exception {
    Doctor doctor = new Doctor();
    doctor.setUserId(5);
    doctor.setUserName("manojkumar");
    doctor.setUserPassword("manoj123");
    doctor.setUserAge(30);
    doctor.setUserGender("M");
    doctor.setUserMobileNumber("8903452167");
    doctor.setUserEmailId("manoj123@gmail.com");
    doctor.setUserAddressLine1("no.5");
    doctor.setUserAddressLine2("4th street,rk nagar");
    doctor.setUserAddressLine3("kovai");
    doctor.setDoctorExperience(4);
    doctor.setDoctorSpecialization("cardiologist");
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
    String requestJson = ow.writeValueAsString(doctor);
    mockMvc
        .perform(
            put("/doctors/updateDoctor").contentType(APPLICATION_JSON_UTF8).content(requestJson))
        .andExpect(status().isOk());
  }
}