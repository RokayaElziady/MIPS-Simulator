//String bin = Integer.toBinaryString(0x10000 | val).substring(1);

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class ALU {
	static int zeroFlag;
	static int oneFlag;
	static int ALUresult;
	
	public static  void ALUEvaluator(String Op ,int Operand1,int Operand2) { 
	String operation=getOperation(Op);
	 switch(operation) {
	 case "AND":ANDOp(Operand1, Operand2);break;
	 case "OR":OROp(Operand1, Operand2);break;
	 case "add":addOp(Operand1, Operand2);break;
	 case "sub":subOp(Operand1, Operand2);break;
	 case "slt":sltOp(Operand1, Operand2);break;
	 case "MUL":MulOP(Operand1, Operand2);break;
	 case "shiftRight":shiftRightOP(Operand1, Operand2);break;
	 case "shiftLeft":shiftLeftOP(Operand1, Operand2);break;
     		 
	 }
	}
	 

	
	 public static String getOperation(String Operation) {
	    	switch(Operation) {
	    	case "1001":return "AND" ;
	    	case "0010":return "OR" ;
	    	case "0001":return "add" ;
	    	case "0000":return "sub" ;
	    	case "0111":return "slt" ;
	    	case "0011":return "MUL";
	    	case "1011":return "shiftRight";
	    	case "1100":return "shiftLeft";		
	    	default:return "INVALID" ;
	    	}
	 }
	
	public static void MulOP(int Operand1,int Operand2) {
		int result=Operand1 * Operand2;
	    if(result==0) { 
	     zeroFlag=1;
	    }
	    else {
	    	zeroFlag=0;
	    }
		if(result==1) {
			oneFlag=1;
		}
		else {
			oneFlag=0;
		}
	    ALUresult=result;
		
	}
	
	
    public static void shiftRightOP(int Operand1,int Operand2) {
    	int result=0;
    	int op1=Operand1;
    	for(int i=0;i<Operand2;i++) {
    		op1=op1/2;
    	}
    	 result=op1;
	    if(result==0) { 
	     zeroFlag=1;
	    }
	    else {
	    	zeroFlag=0;
	    }
		if(result==1) {
			oneFlag=1;
		}
		else {
			oneFlag=0;
		}
	   
	    ALUresult=result;
	}
    public static void shiftLeftOP(int Operand1,int Operand2) {
    	int result=0;
    	int op1=Operand1;
    	for(int i=0;i<Operand2;i++) {
    		op1=op1*2;
    	}
    	 result=op1;
	    if(result==0) { 
	     zeroFlag=1;
	    }
	    else {
	    	zeroFlag=0;
	    }
		if(result==1) {
			oneFlag=1;
		}
		else {
			oneFlag=0;
		}
	   
	    ALUresult=result;
	}
	
	
	public static void ANDOp(int Operand1,int Operand2) {
	    int result=Operand1 & Operand2;
	    if(result==0) { 
	     zeroFlag=1;
	    }
	    else {
	    	zeroFlag=0;
	    }
		if(result==1) {
			oneFlag=1;
		}
		else {
			oneFlag=0;
		}
	    ALUresult=result;
	}
	
    public static void OROp(int Operand1,int Operand2) {
    	int result=Operand1 | Operand2;
	    if(result==0) { 
	     zeroFlag=1;
	    }
	    else {
	    	zeroFlag=0;
	    }
		if(result==1) {
			oneFlag=1;
		}
		else {
			oneFlag=0;
		}
	    ALUresult=result;
	}
    
    public static void addOp(int Operand1,int Operand2) {
    	int result=Operand1 + Operand2;
	    if(result==0) { 
	     zeroFlag=1;
	    }
	    else {
	    	zeroFlag=0;
	    }
		if(result==1) {
			oneFlag=1;
		}
		else {
			oneFlag=0;
		}
	    ALUresult=result;
		
	}
    public static void subOp(int Operand1,int Operand2) {
    	int result=Operand1 - Operand2;
	    if(result==0) { 
	     zeroFlag=1;
	    }
	    else {
	    	zeroFlag=0;
	    }
		if(result==1) {
			oneFlag=1;
		}
		else {
			oneFlag=0;
		}
	    ALUresult=result;
    }
    public static void sltOp(int Operand1,int Operand2) {
    	int result=0;
    	if(Operand1 < Operand2)result=1;
    	if(Operand1 >= Operand2)result=0;
	    if(result==0) { 
	     zeroFlag=1;
	    }
	    else {
	    	zeroFlag=0;
	    }
		if(result==1) {
			oneFlag=1;
		}
		else {
			oneFlag=0;
		}
	    ALUresult=result;
    }
   
   
    


	
	

}
