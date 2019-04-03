package Interface;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

public class FormatedTextMask {
	
	private MaskFormatter Mask;
	
	public FormatedTextMask(){
		
	}
	
	public MaskFormatter getMaskCnpj() throws ParseException {
			Mask = new MaskFormatter("##.###.###/####-##");
		return Mask;
	}
	
	public MaskFormatter getMaskData() throws ParseException {
		Mask = new MaskFormatter("##/##/####");
	return Mask;
	}
	
	public MaskFormatter getMaskCpf() throws ParseException {
		Mask = new MaskFormatter("###.###.###-##");
	return Mask;
	}
	
	public MaskFormatter getMaskChassi() throws ParseException {
		Mask = new MaskFormatter("AAAAAAAAAAAAAAAAA");
	return Mask;
	}
	
	public MaskFormatter getMaskInt() throws ParseException {
		Mask = new MaskFormatter("########");
	return Mask;
	}
	
	public MaskFormatter getMaskPlaca() throws ParseException {
		Mask = new MaskFormatter("AAA-####");
	return Mask;
	}
	
	public MaskFormatter getMaskChar() throws ParseException {
		Mask = new MaskFormatter("A");
	return Mask;
	}
	
	public MaskFormatter getMaskCNH() throws ParseException {
		Mask = new MaskFormatter("######### AAAAA");
	return Mask;
	}
	
	public MaskFormatter getMaskRG() throws ParseException {
		Mask = new MaskFormatter("##.###.###-#");
	return Mask;
	}
}
