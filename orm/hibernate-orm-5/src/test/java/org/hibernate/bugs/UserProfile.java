package org.hibernate.bugs;


import javax.persistence.*;
import java.util.List;

@Entity
public class UserProfile {

    @Id
    @SequenceGenerator(name = "user_profile_seq_gen", sequenceName = "user_profile_seq_id")
    @GeneratedValue(generator = "user_profile_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long userId;

    private String firstName;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = UserContact.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<UserContact> userContacts;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<UserContact> getUserContacts() {
        return userContacts;
    }

    public void setUserContacts(List<UserContact> userContacts) {
        this.userContacts = userContacts;
    }
}
