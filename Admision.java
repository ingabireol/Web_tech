@ManagedBean
public class AdmissionBean {
    private String name;
    private String email;
    private String major;

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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String submit() {
        // Save the admission request to a database or a file
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Major: " + major);

        // Redirect to a confirmation page
        return "success";
    }
}