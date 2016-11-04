package org.hibernate.bugs;


import javax.persistence.*;

@Entity
public class UserContact {

    @Id
    @SequenceGenerator(name = "user_contact_seq_gen", sequenceName = "user_contact_seq_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_contact_seq_gen")
    private Long contactId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = true)
    private UserProfile userProfile;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
