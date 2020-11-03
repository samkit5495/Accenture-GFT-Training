package com.accenture.unittesting.service;

import com.accenture.unittesting.dao.CalculatorDAO;

public class CalculatorServiceImpl implements CalculatorServiceFacade {

	CalculatorDAO dao = new CalculatorDAO();
	/* (non-Javadoc)
	 * @see com.accenture.unittesting.service.CalculatorServiceFacade#addition(int, int)
	 */
	@Override
	public int addition(int num1, int num2){
		return dao.addition(num1, num2);
	}
}
