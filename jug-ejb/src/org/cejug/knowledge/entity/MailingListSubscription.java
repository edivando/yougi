/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.cejug.knowledge.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.cejug.entity.UserAccount;

/**
 *
 * @author Hildeberto Mendonca
 */
@Entity
@Table(name = "mailing_list_subscription")
public class MailingListSubscription implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name="mailing_list", nullable=false)
    private MailingList mailingList;

    @ManyToOne
    @JoinColumn(name="user_account")
    private UserAccount userAccount;

    @Column(name = "email_address", nullable=false)
    private String emailAddress;

    @Column(name = "subscription_date")
    @Temporal(TemporalType.DATE)
    private Date subscriptionDate;

    @Column(name = "unsubscription_date")
    @Temporal(TemporalType.DATE)
    private Date unsubscriptionDate;

    public MailingListSubscription() {
    }

    public MailingListSubscription(String id) {
        this.id = id;
    }

    public MailingListSubscription(String id, String emailAddress) {
        this.id = id;
        this.emailAddress = emailAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MailingList getMailingList() {
        return mailingList;
    }

    public void setMailingList(MailingList mailingList) {
        this.mailingList = mailingList;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public Date getUnsubscriptionDate() {
        return unsubscriptionDate;
    }

    public void setUnsubscriptionDate(Date unsubscriptionDate) {
        this.unsubscriptionDate = unsubscriptionDate;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MailingListSubscription)) {
            return false;
        }
        MailingListSubscription other = (MailingListSubscription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.emailAddress;
    }
}