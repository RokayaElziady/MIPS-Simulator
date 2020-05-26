
public class WriteBack {
	
	public String  WriteBack(String ALUresult,String ReadData,String MemToReg,String RegWrite,Register_File RF,String instruction) {
		System.out.println();
		System.out.println(instruction+ " in Write Back Stage");
		System.out.println();
//		System.out.println("------------------------------Inputs------------------------------");
//		System.out.println("alu result: "+ALUresult);
//		System.out.println("read data: "+ReadData);
//		System.out.println("memtoreg: "+MemToReg);
		//System.out.println("regdst: "+RegDst);
//		System.out.println("------------------------------------------------------------------");
	  String result="";
	  if(RegWrite.equals("1")) {
		 // System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
	  if(MemToReg.equals("0") ) {
		  //InstructionDecode.grt=ALUresult;
		  RF.registers[Integer.parseInt(InstructionDecode.grd,2)].value=ALUresult;
		  result=ALUresult;
	  }
	  if(MemToReg.equals("1") ) {
		  //InstructionDecode.grd=ALUresult;
		  RF.registers[Integer.parseInt(InstructionDecode.grd,2)].value=ReadData;
		  //System.out.println(InstructionDecode.grd);
		  //System.out.println(Integer.parseInt(InstructionDecode.grd,2));
		  //System.out.println(RF.registers[Integer.parseInt(InstructionDecode.grd,2)].value);
		  result=ALUresult;
	  }
	  
	  }
	  
	  
	  
//	  System.out.println("------------------------------OUtputs------------------------------");
//	  System.out.println("write back: "+result);
//		System.out.println("------------------------------------------------------------------");
	  
	  return result;
	}

}
