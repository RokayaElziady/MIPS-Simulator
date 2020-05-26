public class InstructionDecode {
	static String gfunct;
	static String signExtended;
	static String controlSignal;
	static String grt;
	static String grd;
	static String grs;
	static String gop;

	static String tempRs;
	static String tempRt;
	static String tempRd;
	static String tempOp;
	public String [] InstDecode(String instruction,String PC,Register_File RF) {
		System.out.println();
		System.out.println(instruction+ " in instruction Decode Stage");
		System.out.println();
//		System.out.println("------------------------------Inputs------------------------------");
//		System.out.println("Instruction: "+instruction);
//		System.out.println("PC: "+PC);
//		System.out.println("------------------------------------------------------------------");
		String [] result=new String [11];
		String sop=instruction.substring(0, 4);
		String srd=instruction.substring(4, 8);
		String srs=instruction.substring(8, 12);
		String srt=instruction.substring(12, 16);
		String simmediate=instruction.substring(12,16);
		//String sfunct=instruction.substring(26);
	    String saddress=instruction.substring(4);
		int op=Integer.parseInt(instruction.substring(0, 4),2);
		int rd=Integer.parseInt(instruction.substring(4, 8),2);
		int rs=Integer.parseInt(instruction.substring(8, 12),2);
		int rt=Integer.parseInt(instruction.substring(12, 16),2);
		int immediate=Integer.parseInt(instruction.substring(12,16),2);
		//int funct=Integer.parseInt(instruction.substring(26),2);
	    //int address=Integer.parseInt(instruction.substring(4),2);
	    grd=srd;
	    //System.out.println("grd  "+grd);
	    grt=srt;
	    grs=srs;
	    gop=sop;


	    //gfunct=sfunct;
	    int [] temp=RF.decode(rs, rt, rd);
	    String ReadData1=Execute.toBinary(temp[0], 16);
	    String ReadData2=Execute.toBinary(temp[1], 16);
	    String ControlSignal=ContUnit(sop);
	    //System.out.println("debug control signal:  "+ControlSignal);
	    controlSignal=ControlSignal;
	    String SignExtend=SignExtend(simmediate);
	    signExtended=SignExtend;
	   // Execute.Execute(ControlSignal.substring(7), ControlSignal.charAt(5)+"", ReadData1, ReadData2, SignExtend, PC);
	    //System.out.println("------------------------------Outputs------------------------------");
		System.out.println("Read data 1 : "+ReadData1);
		System.out.println("Read data 2 : "+ReadData2);
		System.out.println("Sign Extend :"+ SignExtend);
		//System.out.println("9-bit control signal : "+controlSignal);
		System.out.println("Next PC : "+PC);
//		if(sop.equals("0000")||sop.equals("0001")||sop.equals("0011")||sop.equals("0010"))              //rd w rt meen don't care???
//		System.out.println("rd: "+srt);																				/////
//		else                   																							///
			System.out.println("rd: "+srd);																			///


		if(sop.equals("0000")||sop.equals("0001")||sop.equals("0011")||sop.equals("0010")||sop.equals("1010"))
		System.out.println("rt: "+srt);
		else
			System.out.println("rt: don't care");
//		System.out.println("register : "+srt);
		System.out.println("WB controls :  MemtoReg: "+controlSignal.charAt(2));
		System.out.println("MEM controls:"+ "MemRead: "+controlSignal.charAt(1)+" ,MemWrite: "+controlSignal.charAt(3)+" ,Branch: "+controlSignal.charAt(0)+" ,Jump: "+controlSignal.charAt(6) );
//		result=Branch+MemRead+MemtoReg+MemWrite+ALUSrc+RegWrite+Jump;
		System.out.println("EX controls: ALUSrc:"+controlSignal.charAt(4));
		//System.out.println("------------------------------------------------------------------");
	    
	    result[0]=ControlSignal;
	    result[1]=ReadData1;
	    result[2]=ReadData2;
	    result[3]=PC;
	    result[4]=instruction;

		tempRd=instruction.substring(4, 8);
		tempRs=instruction.substring(8, 12);
		tempRt=instruction.substring(12, 16);
		result[5]=tempRd;
		result[6]=tempRs;
		result[7]=tempRt;
       result[8]=gop;
       result[9]=""+controlSignal.charAt(4);
       result[10]=signExtended;
		tempOp=sop;
	     return result; 		
	}
	
	public static String SignExtend(String immediate) {
//		System.out.println("Sign Extend");
//		System.out.println("------------------------------Inputs------------------------------");
//		System.out.println("immediate: "+immediate);
//		System.out.println("------------------------------------------------------------------");
		String result=immediate;
		if(immediate.charAt(0)=='1') {
			for(int i=0;i<12;i++ ) {
				result="1"+result;
			}
		}
		if(immediate.charAt(0)=='0') {
			for(int i=0;i<12;i++ ) {
				result="0"+result;
			}
		}
//		System.out.println("------------------------------OUTPUTS------------------------------");
//		System.out.println("sign Extend: "+result);
//		System.out.println("------------------------------------------------------------------");
		
		return result;
		
	}
	
	public static String ContUnit(String OPCode) {  //Main Control
	
		String result=""; 
		
		//String RegDst="";
		String Branch="";
		String MemRead="";
		String MemtoReg="";
		String MemWrite="";
		String ALUSrc="";
		String RegWrite="";
		String Jump="";
	//	String ALUOp="";
		
	    if(OPCode.equals("0000")) { //Sub
	    	 ALUSrc="0";
	    	 MemtoReg="0";
	    	 RegWrite="1";
	    	 MemRead="0";
	    	 MemWrite="0";
			 Branch="0";
			 Jump="0";
	    }
	    if(OPCode.equals("0001")) { //Add
	    	 ALUSrc="0";
	    	 MemtoReg="0";
	    	 RegWrite="1";
	    	 MemRead="0";
	    	 MemWrite="0";
			 Branch="0";
			 Jump="0";
	    }
	   
	    if(OPCode.equals("0010")) { //or
	    	 ALUSrc="0";
	    	 MemtoReg="0";
	    	 RegWrite="1";
	    	 MemRead="0";
	    	 MemWrite="0";
			 Branch="0";
			 Jump="0";
	    }
	    if(OPCode.equals("0011")) { //Mul
	    	 ALUSrc="0";
	    	 MemtoReg="0";
	    	 RegWrite="1";
	    	 MemRead="0";
	    	 MemWrite="0";
			 Branch="0";
			 Jump="0";
	    }
	    if(OPCode.equals("0100")) {//BEQ
	    	 ALUSrc="0";
	    	 MemtoReg="0";//DC
	    	 RegWrite="0";
	    	 MemRead="0";
	    	 MemWrite="0";
			 Branch="1";
			 Jump="0";
	    }
	    if(OPCode.equals("0101")) {//Blt
		    	 ALUSrc="0";
		    	 MemtoReg="0";//DC
		    	 RegWrite="0";
		    	 MemRead="0";
		    	 MemWrite="0";
				 Branch="1";
				 Jump="0";
		    }
	    if(OPCode.equals("0110")) {//LW
	    //	RegDst="0";//DC
	    	 ALUSrc="1";
	    	 MemtoReg="1";//DC
	    	 RegWrite="1";
	    	 MemRead="1";
	    	 MemWrite="0";
			 Branch="0";
			 Jump="0";
			 //ALUOp="00";
	    }
	    if(OPCode.equals("0111")) {//SW
	    	// RegDst="0";//DC
	    	 ALUSrc="1";
	    	 MemtoReg="0";//DC
	    	 RegWrite="0";
	    	 MemRead="0";
	    	 MemWrite="1";
			 Branch="0";
			 Jump="0";
			 //ALUOp="00";
	    }
	    
	    
	    if(OPCode.equals("1000")) {//add immediate
	    	// RegDst="0";//DC
	    	 ALUSrc="1";
	    	 MemtoReg="0";//DC
	    	 RegWrite="1";
	    	 MemRead="0";
	    	 MemWrite="0";
			 Branch="0";
			 Jump="0";
			 //ALUOp="00";
	    }
	    if(OPCode.equals("1001")) {//and immediate
	    	// RegDst="0";//DC
	    	 ALUSrc="1";
	    	 MemtoReg="0";//DC
	    	 RegWrite="1";
	    	 MemRead="0";
	    	 MemWrite="0";
			 Branch="0";
			 Jump="0";
			 //ALUOp="00";
	    }
	    if(OPCode.equals("1010")) {//set less than  //rtype
	    	 ALUSrc="0";
	    	 MemtoReg="0";
	    	 RegWrite="1";
	    	 MemRead="0";
	    	 MemWrite="0";
			 Branch="0";
			 Jump="0";
	    }
	    if(OPCode.equals("1011")) {//shift right
	    	 ALUSrc="1";
	    	 MemtoReg="0";//DC
	    	 RegWrite="1";
	    	 MemRead="0";
	    	 MemWrite="0";
			 Branch="0";
			 Jump="0";
			 //ALUOp="00";
	    }
	    if(OPCode.equals("1100")) {//shift left
	    	ALUSrc="1";
	    	 MemtoReg="0";//DC
	    	 RegWrite="1";
	    	 MemRead="0";
	    	 MemWrite="0";
			 Branch="0";
			 Jump="0";
	    }
	    if(OPCode.equals("1101")) {//jump register
	    	// RegDst="0";//DC
	    	 ALUSrc="0";
	    	 MemtoReg="0";//DC
	    	 RegWrite="0";
	    	 MemRead="0";
	    	 MemWrite="0";
			 Branch="0";
			 Jump="1";
			 //ALUOp="00";
	    }
	    
	    result=Branch+MemRead+MemtoReg+MemWrite+ALUSrc+RegWrite+Jump;
	    return result;
	}
	
}
