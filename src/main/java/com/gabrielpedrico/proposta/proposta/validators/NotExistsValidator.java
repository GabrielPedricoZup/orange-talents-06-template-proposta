package com.gabrielpedrico.proposta.proposta.validators;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotExistsValidator implements ConstraintValidator<NotExists, Object> {

    private String name;
    private Class<?> domainClass;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void initialize(NotExists params) {

        name = params.fieldName();
        domainClass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Boolean isValid = em.createQuery("select 1 from " + domainClass.getName() + " where " + name + " = :pValue ")
                .setParameter("pValue", value)
                .getResultList()
                .isEmpty();
        if(!isValid) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Já existe proposta para esse usuario");
        }
        return isValid;
    }


}
