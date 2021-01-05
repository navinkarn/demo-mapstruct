package com.example.demo.mapper;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.Employee;
import com.example.demo.util.EmpValidator;
import org.mapstruct.*;

import javax.xml.bind.ValidationException;
import java.util.UUID;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, uses = {EmpValidator.class}, imports = {UUID.class},componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EmployeeMapper { //When we compile the project, the implementation class is auto generated. In our case EmployeeMapperImpl.java

    @Mappings({
            //qualifiedByName includes the function that we need to invoke, for e.g. FullNameMapper will be invoked in this case
            @Mapping(target = "fullName", source = ".", qualifiedByName = "FullNameMapper"),
            //below mapping is mapping with Type different, from Date to String
            @Mapping(target = "startDate", source = "startDate", dateFormat = "dd-MM-yyyy HH:mm:ss"),
            //below mapping is an example of using java expression
            @Mapping(target="externalId", expression = "java(UUID.randomUUID().toString())")
    })

    EmployeeDto empToDto(Employee employee) throws ValidationException; //throws validationException, we're handling this exception in main class

    /*@InheritInverseConfiguration(name= "empToDto")
    Employee empFromDto(EmployeeDto employeeDto);*/


    @Named("FullNameMapper")
    public static String fullNameByFirstAndLastName(Employee employee){
        return employee.getFirstName()+" "+employee.getLastName();

    }


}
