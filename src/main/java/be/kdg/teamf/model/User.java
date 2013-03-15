package be.kdg.teamf.model;


import be.kdg.teamf.model.component.JsonDateSerializer;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Jeroen
 * Date: 5/02/13
 * Time: 14:57
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "T_USER")
//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class User implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    @Column(name = "username", unique = true, length = 255)
    private String username;
    @Column(name = "password", length = 255)
    private String password;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "telephone", length = 255)
    private String telephone;
    @Column(name = "firstname", length = 255)
    private String firstName;
    @Column(name = "lastname", length = 255)
    private String lastName;
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "street", length = 255)
    private String street;
    @Column(name = "number", length = 255)
    private String number;
    @Column(name = "zipcode", length = 255)
    private String zipcode;
    @Column(name = "city", length = 255)
    private String city;
    @Column(name = "showposition", length = 255)
    private boolean showPosition;
    @Column(name = "notificationemail")
    private boolean notificationEmail;

    @Lob
    @JsonIgnore
    @Column(name = "profielFoto")
    private Blob profielFoto;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = ("user"))
    private Collection<Deelname> deelnames;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = ("organiser"))
    private Collection<Trip> trips;

    @JsonIgnore
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = ("user"))
    private Collection<Chat> chats;


    public User() {

    }

    public User(String city, String zipcode, String number, String street, Date dateOfBirth, String lastName, String firstName, String telephone, String email, String password, String username)  {
        this.password =  password;
        this.city = city;
        this.zipcode = zipcode;
        this.number = number;
        this.street = street;
        this.dateOfBirth = dateOfBirth;
        this.lastName = lastName;
        this.firstName = firstName;
        this.telephone = telephone;
        this.email = email;
        this.username = username;


    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> g =new ArrayList<>();
        g.add(new SimpleGrantedAuthority("ROLE_USER"));
        return g;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @JsonSerialize(using=JsonDateSerializer.class)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Collection<Deelname> getDeelnames() {
        return deelnames;
    }

    public void setDeelnames(Collection<Deelname> deelnames) {
        this.deelnames = deelnames;
    }

    public Collection<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Collection<Trip> trips) {
        this.trips = trips;
    }

    public void setShowPosition(boolean showPosition) {
        this.showPosition = showPosition;
    }

    public boolean isShowPosition() {

        return showPosition;
    }

    public void setNotificationEmail(boolean notificationEmail) {
        this.notificationEmail = notificationEmail;
    }

    public boolean isNotificationEmail() {

        return notificationEmail;
    }

    public Blob getProfielFoto() {
        return profielFoto;
    }

    public void setProfielFoto(Blob profielFoto) {
        this.profielFoto = profielFoto;
    }

    public Collection<Chat> getChats() {
        return chats;
    }

    public void setChats(Collection<Chat> chats) {
        this.chats = chats;
    }
}
