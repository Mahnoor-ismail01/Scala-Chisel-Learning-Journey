package SingleCycle
import chisel3._
import chisel3.util._

class Top extends Module{
    val io=IO(new Bundle{
        val out=Output(SInt(32.W))
    })

val PC_Module=Module(new PC)
val Instr_Mem_Module=Module(new Instruction_Memory)
val Control_Module=Module(new ControlAndType_Decode)
val ALU_Control_Module=Module(new AlU_Control)
val ALU_Module=Module(new ALU3)
val register_module=Module(new Register_file_io)
val jalr_Module=Module(new jalr)
val immediate_Module=Module(new ImmdValGen2)
val DataMemory_Module=Module(new Data_Memory1)

//and mux

val andfunc=ALU_Module.io.branch & Control_Module.io.Branch
//sb mux
val SBMux=Mux(andfunc,immediate_Module.io.immd_SB,PC_Module.io.PC4)

//jalr mux
val jalrMux=MuxLookup(Control_Module.io.Next_PC_sel , false.B , Array (

(0.U)-> PC_Module.io.PC4,
(1.U)-> SBMux,
(2.U)-> immediate_Module.io.immd_UJ,
(3.U)-> jalr_Module.io.jalrout))
//pc
PC_Module.io.start := jalrMux

Instr_Mem_Module.io.addr:=PC_Module.io.PCout.asUInt//instructionmeme 

val Instruction=Instr_Mem_Module.io.inst
//control
Control_Module.io.opcode:=Instruction(6,0) //control

ALU_Control_Module.io.AluOp:=Control_Module.io.AluOp//alu control
ALU_Control_Module.io.func7:=Instruction(31,25)
ALU_Control_Module.io.func3:=Instruction(14,12)
//alu
ALU_Module.io.alu_Op:=ALU_Control_Module.io.AluControl//Alu control complete
//data memory mux
val dataMux= Mux(Control_Module.io.MemtoReg,DataMemory_Module.io.dataOut,ALU_Module.io.out)
//jalr

jalr_Module.io.rs1:=register_module.io.RS1Data
jalr_Module.io.rs2:=dataMux
//register wire with immediate instruction
register_module.io.addRS1:=Instruction(19,15)
register_module.io.addRS2:=Instruction(24,20)
register_module.io.addWrite:=Instruction(11,7)
register_module.io.RegWriteEnable:=Control_Module.io.RegWrite
//immediate
immediate_Module.io.instr:=Instruction
//MUx after regA
val opA=MuxLookup(Control_Module.io.Operand_A_sel , false .B , Array (
 
(0.U)->register_module.io.RS1Data,
(1.U)->PC_Module.io.PC4,
(2.U)->PC_Module.io.PCout,
(3.U)->register_module.io.RS1Data))
//immediate mux
 val immediateMux=MuxLookup(dontTouch(Control_Module.io.Extend_sel) , false .B , Array (

 (0.U)->immediate_Module.io.immd_I,
  (1.U)->immediate_Module.io.immd_S,
  (2.U)->immediate_Module.io.immd_U,
  (3. U ) -> 0.S))
//muc after reg B
val opB=Mux(Control_Module.io.Operand_B_sel,immediateMux.asSInt,register_module.io.RS2Data)
 
 //alu of mux

 ALU_Module.io.in_A:=opA
 ALU_Module.io.in_B:=opB
 //ALU branch and


  



 //datamemory
 
DataMemory_Module.io.memAdd:=ALU_Module.io.out.asUInt
DataMemory_Module.io.DataIn:=register_module.io.RS2Data
DataMemory_Module.io.memRead:=Control_Module.io.memRead
DataMemory_Module.io.wr_en:=Control_Module.io.MemWrite




//Write reg

register_module.io.DataWrite:=dataMux
io.out:=dataMux















}