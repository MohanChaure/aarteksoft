package com.aartek.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.Registration;

@Component
public class RegistrationValidator implements Validator {
	public boolean supports(Class<?> clazz) {
		return Registration.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Registration registration = (Registration) target;

		ValidationUtils.rejectIfEmpty(errors, "firstName", "error.firstName.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.lastName.empty");
		ValidationUtils.rejectIfEmpty(errors, "emailId", "error.emailId.empty");
		ValidationUtils.rejectIfEmpty(errors, "primaryMobileNo", "error.primaryMobileNo.empty");
		ValidationUtils.rejectIfEmpty(errors, "secondaryMobileNo", "error.secondaryMobileNo.empty");
		ValidationUtils.rejectIfEmpty(errors, "city", "error.city.empty");
		ValidationUtils.rejectIfEmpty(errors, "presentAddress", "error.presentAddress.empty");
		ValidationUtils.rejectIfEmpty(errors, "permanentAddress", "error.permanentAddress.empty");
		ValidationUtils.rejectIfEmpty(errors, "gender", "error.gender.empty");
		ValidationUtils.rejectIfEmpty(errors, "experience", "error.experience.empty");
		ValidationUtils.rejectIfEmpty(errors, "consultancyName", "error.consultancyName.empty");
//		ValidationUtils.rejectIfEmpty(errors, "resumeName", "error.resumeName.empty");
		if (registration.getEmailId() != null && registration.getEmailId().trim().length() > 0) {
			boolean b = ValidationUtil.validateEmail(registration.getEmailId());
			if (registration.getEmailId().contains("@") != true && !b) {
				errors.rejectValue("emailId", "error.emailId.first.rule");
			} else if (registration.getEmailId().contains(".com") != true
							&& registration.getEmailId().contains(".net") != true
							&& registration.getEmailId().contains(".co.in") != true && !b) {
				errors.rejectValue("emailId", "error.emailId.second.rule");
			} else if (!b) {
				errors.rejectValue("emailId", "error.emailId.required");
			}
		}

		if (registration.getSkills().getSkillsId() == 0) {
			errors.rejectValue("skills.skillsId", "error.skills.skillsId.empty");
		}

		if (registration.getPrimaryMobileNo() != null && registration.getPrimaryMobileNo().trim().length() > 0) {
			boolean b = ValidationUtil.validatingNumberFiled(registration.getPrimaryMobileNo());
			if (registration.getPrimaryMobileNo().contains("$") != true && !b) {
				errors.rejectValue("primaryMobileNo", "error.primaryMobileNo.rul");
			} else if (registration.getPrimaryMobileNo().length() < 10
							&& registration.getPrimaryMobileNo().length() > 0) {
				errors.rejectValue("primaryMobileNo", "error.primaryMobileNo.length");
			}
		}

		if (registration.getSecondaryMobileNo() != null && registration.getSecondaryMobileNo() != "") {
			boolean b = ValidationUtil.validatingNumberFiled(registration.getSecondaryMobileNo());
			if (registration.getSecondaryMobileNo().contains("$") != true && !b) {
				errors.rejectValue("secondaryMobileNo", "error.secondaryMobileNo.rul");
			} else if (registration.getSecondaryMobileNo().length() < 10
							&& registration.getSecondaryMobileNo().length() > 0) {
				errors.rejectValue("secondaryMobileNo", "error.secondaryMobileNo.length");
			}
		}

		if (registration.getFirstName() != null && registration.getFirstName().trim().length() > 0) {
			boolean b = ValidationUtil.validateingAlphabetsFiled(registration.getFirstName());
			if (registration.getFirstName().contains("$") != true && !b) {
				errors.rejectValue("firstName", "error.firstName.length");

			}

		}
		if (registration.getLastName() != null && registration.getLastName().trim().length() > 0) {
			boolean b = ValidationUtil.validateingAlphabetsFiled(registration.getLastName());
			if (registration.getLastName().contains("$") != true && !b) {
				errors.rejectValue("lastName", "error.lastName.length");

			}

		}
		
		if (registration.getCity() != null && registration.getCity().trim().length() > 0) {
			boolean b = ValidationUtil.validateingAlphabetsFiled(registration.getCity());
			if (registration.getCity().contains("$") != true && !b) {
				errors.rejectValue("city", "error.city.length");

			}

		}
		/*if (registration.getResumeName() != null && registration.getResumeName().trim().length() > 0) {
			boolean b = ValidationUtil.validatingFileUpload(registration.getResumeName());
			if (registration.getResumeName().contains("$") != true && !b) {
				errors.rejectValue("resumeName", "error.resumeName.extansion");

			}
		}
*/
	}
}
