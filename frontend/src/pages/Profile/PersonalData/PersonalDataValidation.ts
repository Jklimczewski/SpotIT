import * as Yup from 'yup';
import { REQUIRED_MESSAGE, PHONE_NUMBER_REGEX } from 'appConstants';

const personalDataValidationSchema = Yup.object({
  firstName: Yup.string().required(REQUIRED_MESSAGE),
  lastName: Yup.string().required(REQUIRED_MESSAGE),
  email: Yup.string().email('Podaj poprawny email').required(REQUIRED_MESSAGE),
  phoneNumber: Yup.string().matches(PHONE_NUMBER_REGEX, 'Niepoprawny numer telefonu'),
  profilePicture: Yup.string(),
  position: Yup.string().min(2, 'Podaj poprawną pozycję'),
  isOpen: Yup.bool()
});

export default personalDataValidationSchema;
