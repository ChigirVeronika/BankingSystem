package by.bsuir.banking.entity;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Bill> bills;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "firstname")
    @NotEmpty(message = "Please fill the field.")
    @Size(min = 2, max = 25, message = "Value must be between 2 and 25 characters")
    private String firstName;

    @Column(name = "lastname")
    @NotEmpty(message = "Please fill the field.")
    @Size(min = 2, max = 25, message = "Value must be between 2 and 25 characters")
    private String lastName;

    @Column(name = "middlename")
    @NotEmpty(message = "Please fill the field.")
    @Size(min = 2, max = 25, message = "Value must be between 2 and 25 characters")
    private String middleName;

    @Column(name = "birthday")
    @NotEmpty(message = "Please fill the field.")
    private Date birthday;

    @Column(name = "gender")
    @NotEmpty(message = "Please fill the field.")
    private String gender;

    //private String passportSeriesAndNumber;

    @Column(name = "whomgranted")
    @NotEmpty(message = "Please fill the field.")
    private String whomGranted;

    @Column(name = "granteddate")
    @NotEmpty(message = "Please fill the field.")
    private Date grantedDate;

    @Column(name = "idnumber")
    @NotEmpty(message = "Please fill the field.")
    @Size(min = 2, max = 25, message = "Value must be between 2 and 25 characters")
    private String idNumber;

    @Column(name = "birthplace")
    @NotEmpty(message = "Please fill the field.")
    private String birthPlace;

    @NotEmpty
    @OneToOne
    @PrimaryKeyJoinColumn
    private AccommodationCity accommodationCity;

    @Column(name = "accommodationaddres")
    @NotEmpty(message = "Please fill the field.")
    private String accommodationAddress;

    @Column(name = "homephone")
    private String homePhone;
    @Column(name = "cellphone")
    private String cellPhone;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name="workplace")
    private String workPlace;
    @Column(name="position")
    private String position;

    @NotEmpty(message = "Please fill the field.")
    @OneToOne
    @PrimaryKeyJoinColumn
    private RegistrationCity registrationCity;

    @NotEmpty(message = "Please fill the field.")
    @OneToOne
    @PrimaryKeyJoinColumn
    private MaritalStatus maritalStatus;

    @NotEmpty(message = "Please fill the field.")
    @OneToOne
    @PrimaryKeyJoinColumn
    private Citizenship citizenship;

    @NotEmpty(message = "Please fill the field.")
    @OneToOne
    @PrimaryKeyJoinColumn
    private Disability disability;

    @Column(name="pensioner")
    private Boolean pensioner;
    @Column(name="monthincome")
    private Double monthIncome;

    @Column(name = "passportseries")
    private String passportSeries;

    @Column(name = "passportnumber")
    private String passportNumber;

    public User() {
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGrantedDate() {
        return grantedDate;
    }

    public void setGrantedDate(Date grantedDate) {
        this.grantedDate = grantedDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String secondName) {
        this.lastName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    public String getPassportSeriesAndNumber() {
//        return passportSeriesAndNumber;
//    }
//
//    public void setPassportSeriesAndNumber(String passportSeriesAndNumber) {
//        this.passportSeriesAndNumber = passportSeriesAndNumber;
//    }

    public String getWhomGranted() {
        return whomGranted;
    }

    public void setWhomGranted(String whomGranted) {
        this.whomGranted = whomGranted;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public AccommodationCity getAccommodationCity() {
        return accommodationCity;
    }

    public void setAccommodationCity(AccommodationCity accommodationCity) {
        this.accommodationCity = accommodationCity;
    }

    public String getAccommodationAddress() {
        return accommodationAddress;
    }

    public void setAccommodationAddress(String accommodationAddress) {
        this.accommodationAddress = accommodationAddress;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public RegistrationCity getRegistrationCity() {
        return registrationCity;
    }

    public void setRegistrationCity(RegistrationCity registrationCity) {
        this.registrationCity = registrationCity;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }

    public Disability getDisability() {
        return disability;
    }

    public void setDisability(Disability disability) {
        this.disability = disability;
    }

    public Boolean getPensioner() {
        return pensioner;
    }

    public void setPensioner(Boolean pensioner) {
        this.pensioner = pensioner;
    }

    public Double getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(Double monthIncome) {
        this.monthIncome = monthIncome;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", whomGranted='" + whomGranted + '\'' +
                ", grantedDate=" + grantedDate +
                ", idNumber='" + idNumber + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", accommodationCity=" + accommodationCity +
                ", accommodationAddress='" + accommodationAddress + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", email='" + email + '\'' +
                ", workPlace='" + workPlace + '\'' +
                ", position='" + position + '\'' +
                ", registrationCity=" + registrationCity +
                ", maritalStatus=" + maritalStatus +
                ", citizenship=" + citizenship +
                ", disability=" + disability +
                ", pensioner=" + pensioner +
                ", monthIncome=" + monthIncome +
                '}';
    }
}
