import java.lang.ProcessBuilder.Redirect;

public class Execute {
	static String gPC;
	public static String toBinary(int x, int len) {
		String  res="";
		if (len > 0) {
			 res= String.format("%" + len + "s",Integer.toBinaryString(x)).replaceAll(" ", "0");
		}
		if(res.length()>16) {
			return res.substring(res.length()-16);
		}
			
		return res;
		
		//return null;																	//	result=Branch+MemRead+MemtoReg+MemWrite+ALUSrc+RegWrite+Jump;
	}
	public static String[] Execute(String OPCode,String ALUSrc,String ReadData1 ,String ReadData2 ,String SignExtend,String  PC,String instruction,char Branch,char MemRead,char MemtoReg,char MemWrite,char RegWrite,char Jump,String rd,String rs,String rt   ) {
//		System.out.println("h?ere in execute"+)
		System.out.println();
		System.out.println(instruction+ " in Excute Stage");
		System.out.println();
		//System.out.println("------------------------------Inputs------------------------------");
		//System.out.println("Aluop: "+ALUOp);
//		System.out.println("Alusrc: "+ALUSrc);
//		System.out.println("Read data 1: "+ReadData1);
//		System.out.println("read data 2: "+ReadData2);
//		System.out.println("sign extend: "+SignExtend);
//		System.out.println("pc: "+PC);
		//System.out.println("------------------------------------------------------------------");
		//String funct=InstructionDecode.gfunct;
		String [] result=new String [17];
		String ZeroFlag="0";
		String oneFlag="0";
		String ALUresult="";
		String Secondoperand="";
		String BranchAddressResult="";
		//String ALUOperation=ALUControl(funct, ALUOp);
		
		if(ALUSrc.equals("0")) {
			Secondoperand=ReadData2;
		}
		if(ALUSrc.equals("1")) {
			Secondoperand=SignExtend;
		}
		
		if(OPCode.equals("0100")||OPCode.equals("0101")) {
			Secondoperand=ReadData1;
			ReadData1=InstructionDecode.grd;
		}
		if(OPCode.equals("1101")) {
			ReadData1=InstructionDecode.grd;
		}

		BranchAddressResult=Integer.toBinaryString(0x10000 |(Integer.parseInt(PC,2))+(Integer.parseInt(SignExtend,2))*4 ).substring(1);
		switch(OPCode) {
		case "0000":ALU.ALUEvaluator("0000", Integer.parseInt(ReadData1, 2),Integer.parseInt(Secondoperand,2));ALUresult=Integer.toBinaryString(0x10000 | ALU.ALUresult).substring(1);break;
		case "0001":ALU.ALUEvaluator("0001", Integer.parseInt(ReadData1, 2),Integer.parseInt(Secondoperand,2));ALUresult=Integer.toBinaryString(0x10000 | ALU.ALUresult).substring(1);break;
		case "0010":ALU.ALUEvaluator("0010", Integer.parseInt(ReadData1, 2),Integer.parseInt(Secondoperand,2));ALUresult=Integer.toBinaryString(0x10000 | ALU.ALUresult).substring(1);break;
		case "0011":ALU.ALUEvaluator("0011", Integer.parseInt(ReadData1, 2),Integer.parseInt(Secondoperand,2));ALUresult=Integer.toBinaryString(0x10000 | ALU.ALUresult).substring(1);break;
		case "0100":ALU.ALUEvaluator("0000", Integer.parseInt(ReadData1, 2),Integer.parseInt(Secondoperand,2));ALUresult=Integer.toBinaryString(0x10000 | ALU.ALUresult).substring(1);break;
		case "0101":ALU.ALUEvaluator("0111", Integer.parseInt(ReadData1, 2),Integer.parseInt(Secondoperand,2));ALUresult=Integer.toBinaryString(0x10000 | ALU.ALUresult).substring(1);break;
		case "0110":ALU.ALUEvaluator("0001", Integer.parseInt(ReadData1, 2),Integer.parseInt(Secondoperand,2));ALUresult=Integer.toBinaryString(0x10000 | ALU.ALUresult).substring(1);break;
		case "0111":ALU.ALUEvaluator("0001", Integer.parseInt(ReadData1, 2),Integer.parseInt(Secondoperand,2));ALUresult=Integer.toBinaryString(0x10000 | ALU.ALUresult).substring(1);break;
		case "1000":ALU.ALUEvaluator("0001", Integer.parseInt(ReadData1, 2),Integer.parseInt(Secondoperand,2));ALUresult=Integer.toBinaryString(0x10000 | ALU.ALUresult).substring(1);break;
		case "1001":ALU.ALUEvaluator("1001", Integer.parseInt(ReadData1, 2),Integer.parseInt(Secondoperand,2));ALUresult=Integer.toBinaryString(0x10000 | ALU.ALUresult).substring(1);break;
		case "1010":ALU.ALUEvaluator("0111", Integer.parseInt(ReadData1, 2),Integer.parseInt(Secondoperand,2));ALUresult=Integer.toBinaryString(0x10000 | ALU.ALUresult).substring(1);break;
		case "1011":ALU.ALUEvaluator("1011", Integer.parseInt(ReadData1, 2),Integer.parseInt(Secondoperand,2));ALUresult=Integer.toBinaryString(0x10000 | ALU.ALUresult).substring(1);break;
		case "1100":ALU.ALUEvaluator("1100", Integer.parseInt(ReadData1, 2),Integer.parseInt(Secondoperand,2));ALUresult=Integer.toBinaryString(0x10000 | ALU.ALUresult).substring(1);;break;
		case "1101":if(InstructionDecode.controlSignal.charAt(InstructionDecode.controlSignal.length()-1)=='1')InstructionFetch.ProgramCount=ReadData1;
			
		}
		ALUresult=toBinary(ALU.ALUresult, 16);
		ZeroFlag=Integer.toBinaryString(ALU.zeroFlag);
		oneFlag=Integer.toBinaryString(ALU.oneFlag);
		//System.out.println(ALUresult);
		if(OPCode.equals("0100")) {
			if(Integer.parseInt(ZeroFlag,2)==1
					) {
				InstructionFetch.ProgramCount=BranchAddressResult;
			}
		}
        if(OPCode.equals("0101")) {
        	if(Integer.parseInt(oneFlag,2)==1) {
				InstructionFetch.ProgramCount=BranchAddressResult;
			}
			
		}
		
        if(OPCode.equals("0110")) {
        	Secondoperand=InstructionDecode.grd;
        }
        if(OPCode.equals("0111")) {
		   Secondoperand=InstructionDecode.grd;
        }
		
//		System.out.println("------------------------------OUTPUTS------------------------------");
//
		System.out.println("zero flag: "+ZeroFlag);
		System.out.println("one flag: "+oneFlag);
		System.out.println("branch address: "+BranchAddressResult);
		System.out.println("ALU result/address: "+ALUresult);
		if(OPCode.equals("0111"))
		System.out.println("register value to write to memory: "+Test.RF.registers[ALU.ALUresult].value);
		else
			System.out.println("register value to write to memory: 0000000000000000");
//		if(OPCode.equals("0000")||OPCode.equals("0001")||OPCode.equals("0011")||OPCode.equals("0010"))
//		System.out.println("rt/rd: "+rt);
//		else
			System.out.println("rt/rd: "+rd);
		System.out.println("WB controls: MemtoReg: "+MemtoReg);
		System.out.println("MEM controls: MemRead: "+ MemRead + ",MemWrite: "+MemWrite+" ,Branch: "+Branch+" ,Jump: "+Jump );
//		result=Branch+MemRead+MemtoReg+MemWrite+ALUSrc+RegWrite+Jump;


//		System.out.println("PC: "+PC);
//		System.out.println("------------------------------------------------------------------");
		
        
		
		result[0]=ALUresult;
	    result[1]=ZeroFlag;
	    result[2]=BranchAddressResult;
	    result[3]=Secondoperand;
	    result[4]=PC;
	    result[5]=instruction;
	    result[6]=MemtoReg+"";
		result[7]=rd;
		result[8]=rs;
		result[9]=rt;
		result[10]=OPCode;
		result[11]=oneFlag;
        result[12]=SignExtend;
        result[13]=Branch+"";
        result[14]=MemRead+"";
        result[15]=MemWrite+"";
        result[16]=RegWrite+"";
	    return result;
		
	}
	
//	public static String ALUControl(String funct,String ALUOP) {
//	     String result="";
//	     if(ALUOP.equals("00")) {
//	    	 result="0010";
//	     }
//	     if(ALUOP.equals("01")) {
//	    	 result="0110";
//	     }
//	     if(ALUOP.equals("10")) {
//		if(funct.equals("100000")) {//ADD
//		    result="0010";
//		}
//       if(funct.equals("100010")) {//Sub
//       	result="0110";
//		}
//       if(funct.equals("100100")) {//And
//       	result="0000";
//		}
//       if(funct.equals("100101")) {//or 
//       	result="0001";
//		}
//       if(funct.equals("101010")) {//slt
//       	result="0111";
//		}
//	     }
//       
//       
//       return result;
//		
//	}
//	

}
