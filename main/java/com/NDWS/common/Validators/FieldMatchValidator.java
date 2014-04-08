package com.NDWS.common.Validators;

import com.NDWS.common.Constraints.FieldMatch;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>
{
    private String firstFieldName;
    private String secondFieldName;
    //get the error message name
    private String errorMessageName;

    @Override
    public void initialize(final FieldMatch constraintAnnotation)
    {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        errorMessageName = constraintAnnotation.errorMessage();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext cvc){
        boolean toReturn = false;

        try{
            final Object firstObj = BeanUtils.getProperty(value, firstFieldName );
            final Object secondObj = BeanUtils.getProperty(value, secondFieldName );

            //System.out.println("firstObj = "+firstObj+"   secondObj = "+secondObj);

            toReturn = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch (final Exception e){
            System.out.println(e.toString());
        }
        //If the validation failed
        if(!toReturn) {
            cvc.disableDefaultConstraintViolation();
            //In the initialiaze method you get the errorMessage: constraintAnnotation.message();
            cvc.buildConstraintViolationWithTemplate(errorMessageName).addNode(firstFieldName).addConstraintViolation();
        }
        return toReturn;
    }
}
