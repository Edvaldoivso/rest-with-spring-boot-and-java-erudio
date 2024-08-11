package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController

public class mathController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor insira os parametros corretamente para soma");
		}

		return convertToDouble(numberOne) + convertToDouble(numberTwo);

	};
	
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor insira os parametros corretamente subtração");
		}

		return convertToDouble(numberOne) - convertToDouble(numberTwo);

	};
	
	
	
	@RequestMapping(value = "/mul/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mul(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor insira os parametros corretamente para a mutiplicação");
		}

		return convertToDouble(numberOne) * convertToDouble(numberTwo);

	};
	
	
	
	
	@RequestMapping(value = "/raiz/{numberOne}", method = RequestMethod.GET)
	public Double raiz(
			@PathVariable(value = "numberOne") String numberOne)
			 throws Exception {
		if (!isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Insira um numero para a raiz quadrada");
		}

		return (double) Math.round(Math.sqrt(convertToDouble(numberOne)));

	};
	
	
	
	
	
	

	private Double convertToDouble(String strNumber) {
		if (strNumber == null)
			return 0D;
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number))
			return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {

		if (strNumber == null)
			return false;
		String number = strNumber.replaceAll(",", ".");

		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
