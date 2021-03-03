package movie.tickets.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

public class Customers {
    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "Must not contain special characters")
    @Pattern(regexp = "[^0-9]*", message = "Must not contain numbers")
    private String name;
    @NotNull
    @Size(min = 10, max = 12)
    @Digits(fraction = 0, integer = 12)
    private String mobile;
    @Email
    private String email;

    public Customers(){}

    public Customers(String name, String mobile, String email) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
