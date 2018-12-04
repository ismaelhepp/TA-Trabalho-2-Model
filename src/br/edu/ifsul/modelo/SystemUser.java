package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "system_user")
public class SystemUser implements Serializable {
    
    @Id
    @Column(name = "login", length = 20, nullable = false)
    @NotNull(message = "The login can't be null")
    @NotBlank(message = "The login can't be in white")
    @Length(max = 20, message = "The login can't has more that {max} characters")
    private String login;
    
    @Column(name = "name", length = 50, nullable = false)
    @NotNull(message = "The name can't be null ")
    @NotBlank(message = "The name can' be in white")
    @Length(max = 50, message = "The name of user can't contains more that {max} characters")
    private String name;
    
    @Column(name = "email", length = 50, nullable = false)
    @Email(message = "The email needs be valid")
    @NotNull(message = "The email can't be null")
    @NotBlank(message = "The email can't be in white")
    @Length(max = 50, message = "The email can't contains more that {max} characters")
    private String email;
    
    @Column(name = "password", length = 20, nullable = false)
    @NotNull(message = "The password can't be null")
    @NotBlank(message = "The password can't be in white")
    @Length(max = 20, message = "The password can't contains more that {max} characters")
    private String password;
    
    @ManyToMany
    @JoinTable(name = "permissions", 
            joinColumns = 
            @JoinColumn(
                    name="system_user", 
                    referencedColumnName = "login", 
                    nullable = false),
            inverseJoinColumns = 
            @JoinColumn(
                    name = "permission",
                    referencedColumnName = "name",
                    nullable = false)
            )
    private Set<Permission> permissions = new HashSet<>();

    public SystemUser() {
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.getLogin());
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
        final SystemUser other = (SystemUser) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return true;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
