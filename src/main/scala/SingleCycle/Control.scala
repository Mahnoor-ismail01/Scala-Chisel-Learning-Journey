package SingleCycle
import chisel3._
import chisel3.util._

// Load=0000011
//jalr=1100111
//b=1100011
// Store=0100011
// R=0110011
// jal=1101111
// I=0010011
//lui=0110111
class  ControlAndType_Decode extends Module{
    val io=IO(new Bundle{
        val opcode = Input(UInt(7.W))
        val MemWrite =Output(Bool())
        val Branch =Output(Bool())
        val memRead=Output(Bool())
        val RegWrite=Output(Bool())
        val MemtoReg=Output(Bool())
        val AluOp=Output(UInt(3.W))
        val Operand_A_sel=Output(UInt(2.W))
        val  Operand_B_sel=Output(Bool())
        val  Extend_sel=Output(UInt(2.W))
        val  Next_PC_sel=Output(UInt(2.W))
        
    

    })
    io.MemWrite:=0.B
    io.Branch:=0.B
    io.memRead:=0.B
    io.RegWrite:=0.B
    io.MemtoReg:=0.B
    io.AluOp:=0.U
    io.Operand_A_sel:=0.U
    io.Operand_B_sel:=0.B
    io.Extend_sel:=0.U
    io.Next_PC_sel:=0.U
   
    when (io.opcode==="b0000011".U){
        //io.load:=1.B
         io.memRead:=1.B
         io.RegWrite:=1.B
         io.MemtoReg:=1.B
         io.AluOp:="b000".U
         io.Operand_A_sel:="b00".U
         io.Operand_B_sel:=1.B
        
    }
    when(io.opcode==="b0100011".U){
        //io.store:=1.B
        io.MemWrite:=1.B
         io.AluOp:="b101".U
         io.Operand_A_sel:="b00".U
         io.Operand_B_sel:=1.B
         io.Extend_sel:=1.U
    }
    when(io.opcode==="b0110011".U){
        //io.R_format:=1.B
        io.RegWrite:=1.B
        io.AluOp:="b000".U
         io.Operand_A_sel:="b00".U
         io.Operand_B_sel:=0.B


    }
    when(io.opcode==="b1101111".U){
        //io.jal:=1.B
        io.RegWrite:=1.B
        io.AluOp:="b011".U
         io.Operand_A_sel:="b10".U
         io.Operand_B_sel:=0.B
    }
    when(io.opcode==="b0010011".U){
        //io.I_Type:=1.B
        io.RegWrite:=1.B
        io.AluOp:="b001".U
         io.Operand_A_sel:="b00".U
         io.Operand_B_sel:=1.B
         io.Extend_sel:=0.U
    }
    when(io.opcode==="b1100111".U){
        //io.jalr:=1.B
        io.RegWrite:=1.B
        io.AluOp:="b011".U
         io.Operand_A_sel:="b10".U
         io.Operand_B_sel:=0.B
    }
    when(io.opcode==="b1100011".U){
        //io.opcode_Branch:=1.B//sb
        io.Branch:=1.B
        io.AluOp:="b010".U
         io.Operand_A_sel:="b00".U
         io.Operand_B_sel:=0.B
    }
    when(io.opcode==="b0110111".U){
        io.RegWrite:=1.B
        io.AluOp:="b110".U
         io.Operand_A_sel:="b11".U
         io.Operand_B_sel:=1.B
         io.Extend_sel:=2.U
        //io.lui:=1.B u
    }
   
    



}