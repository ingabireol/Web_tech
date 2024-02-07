@FacesValidator("emailValidator")
public class EmailValidator implements Validator {
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String email = (String) value;
        if (!email.contains("@")) {
            throw new ValidatorException(new FacesMessage("Invalid email address"));
        }
    }
}