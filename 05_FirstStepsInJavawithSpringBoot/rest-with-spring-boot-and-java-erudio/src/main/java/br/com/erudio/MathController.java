package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exeptions.UnsupportedMathOperationException;

@RestController

public class MathController {

	private final AtomicLong counter = new AtomicLong();
	public Double valorCalculado;

	@RequestMapping(value = "/calcular/{numberOne}/{numberTwo}/{op}", method = RequestMethod.GET)

	public Double calcular(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo, @PathVariable(value = "op") String op

	) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo))
			throw new UnsupportedMathOperationException("Please set a numeric value!");

		switch (op) {
		case "sub":
			valorCalculado = convertToDouble(numberOne) - convertToDouble(numberTwo);
			break;
		case "mul":
			valorCalculado = convertToDouble(numberOne) * convertToDouble(numberTwo);
			break;
		case "div":
			valorCalculado =convertToDouble(numberOne) / convertToDouble(numberTwo);
			break;
		case "rq":
			valorCalculado = Math.sqrt(convertToDouble(numberOne));			
			break;
		case "som":
			valorCalculado = convertToDouble(numberOne) + convertToDouble(numberTwo);
			break;
		default:
			System.out.println("Nenhuma operação valida foi encontrada");
		}

		return valorCalculado;
		
	}

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
