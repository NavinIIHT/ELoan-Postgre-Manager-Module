package com.iiht.training.eloan.boundary;

import static com.iiht.training.eloan.testutils.TestUtils.boundaryTestFile;
import static com.iiht.training.eloan.testutils.TestUtils.currentTest;
import static com.iiht.training.eloan.testutils.TestUtils.testReport;
import static com.iiht.training.eloan.testutils.TestUtils.yakshaAssert;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.iiht.training.eloan.model.SanctionDto;
import com.iiht.training.eloan.testutils.MasterData;

@ExtendWith(SpringExtension.class)
// @WebMvcTest
public class BoundaryTest {
	private static Validator validator;

    //----------------------------------------------------------------------------------------------
    @BeforeAll
    public static void setUp() {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @AfterAll
	public static void afterAll() {
		testReport();
	}
   
    @Test
	public void testLoanAmountSanctionedNotNull() throws Exception 
	{
		SanctionDto sanctionDto = MasterData.getSanctionDto();
		sanctionDto.setLoanAmountSanctioned(null);
		Set<ConstraintViolation<SanctionDto>> violations = validator.validate(sanctionDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testLoanAmountSanctionedNotZero() throws Exception 
	{
    	SanctionDto sanctionDto = MasterData.getSanctionDto();
		sanctionDto.setLoanAmountSanctioned(0.0);
		Set<ConstraintViolation<SanctionDto>> violations = validator.validate(sanctionDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testTermOfLoanNotNull() throws Exception 
	{
		SanctionDto sanctionDto = MasterData.getSanctionDto();
		sanctionDto.setTermOfLoan(null);
		Set<ConstraintViolation<SanctionDto>> violations = validator.validate(sanctionDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
    
    @Test
	public void testTermOfLoanNNotZero() throws Exception 
	{
    	SanctionDto sanctionDto = MasterData.getSanctionDto();
		sanctionDto.setTermOfLoan(0.0);
		Set<ConstraintViolation<SanctionDto>> violations = validator.validate(sanctionDto);
		yakshaAssert(currentTest(), !violations.isEmpty()? true : false, boundaryTestFile);
	}
}
