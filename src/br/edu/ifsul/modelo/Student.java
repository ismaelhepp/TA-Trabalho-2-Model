package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author camila
 */
@Entity
@Table(name ="Student")
public class Student implements Serializable {
    
    @Id
    @SequenceGenerator(name = "seq_student", sequenceName = "seq_student_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_student", strategy = GenerationType.SEQUENCE)    
    private Integer id; 
    
    @NotNull(message = "The name can't be null")
    @NotBlank(message = "The name can't be in white")
    @Length(max = 20, message = "The name of user can't contains more that {max} characters")
    @Column(name = "name", length = 20, nullable = false)
    private String name; 
    
    @NotNull(message = "The gender can't be null")
    @NotBlank(message = "The gender can't be in white")
    @Length(max = 20, message = "The gender of user can't contains more that {max} characters")
    private String gender; 
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "The date of birth needs be informed")
    @Column(name = "date_of_birth", nullable = false)
    private Calendar date_of_birth; 
    
    
    public Student(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Calendar getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Calendar date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        final Student other = (Student) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
