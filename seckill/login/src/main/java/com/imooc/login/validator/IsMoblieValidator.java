package com.imooc.login.validator;

import com.imooc.login.utils.ValidateUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsMoblieValidator implements ConstraintValidator<isMobile,String> {
    private boolean required = false;
    @Override
    public void initialize(isMobile constraintAnnotation) {
        required = constraintAnnotation.require();
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(required){
            return ValidateUtil.iMobile(value);
        } else {
            if (StringUtils.isEmpty(value)){return true;}
            else {return ValidateUtil.iMobile(value);}
        }
    }
}
