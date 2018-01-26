package websocket.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class User implements Serializable {
    
    @Id
    @Column(name = "username")
    private String username;
    
    @Column(name = "passwd")
    private String passwd;
    
    @Column(name = "mail")
    private String mail;

    public User() {
        username="";
        passwd="";
        mail="";
    }

    public User(String username, String passwd, String mail) {
        this.username = username;
        this.passwd = passwd;
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "User{" + "username=" + username + ", passwd=" + passwd + ", mail=" + mail + '}';
    }
    
}
