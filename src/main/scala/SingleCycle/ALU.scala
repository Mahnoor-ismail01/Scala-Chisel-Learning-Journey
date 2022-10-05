package SingleCycle
import chisel3._
import chisel3.util._

import scala.language.postfixOps

object ALUOP1 {
// ALU Operations , may expand / modify in future
val ALU_ADD= 0.U (5.W )
val ALU_SUB= 1.U (5.W )
val ALU_AND= 2.U (5.W )
val ALU_OR= 3.U (5.W )
val ALU_XOR= 4.U (5.W )
val ALU_SLT= 5.U (5.W )
val ALU_SLL= 6.U (5.W )
val ALU_SLTU= 7.U (5.W )
val ALU_SRL= 8.U (5.W )
val ALU_SRA= 9.U (5.W )
val ALU_COPY_A = 16.U (5.W )
val ALU_COPY_B = 17.U (5.W )
val ALU_XXX= 18.U (5.W )
val BEQ= 10.U (5.W )
val BNE= 11.U (5.W )
val BLT= 12.U (5.W )
val BGE= 13.U (5.W )
val BLTU= 14.U (5.W )
val BGEU= 15.U (5.W )
val LUI=21.U(5.W)


}

trait Config2 {
// word length configuration parameter
val XLEN= 32
// ALU operation control signal width
val ALUOP_SIG_LEN = 5
}

import ALUOP1._


class ALUIO3 extends Bundle with Config2{
val in_A= Input ( SInt ( XLEN.W ) )
val in_B= Input ( SInt ( XLEN.W ) )
val alu_Op= Input ( UInt ( ALUOP_SIG_LEN.W ) )
val out= Output ( SInt ( XLEN.W ) )
val sum= Output ( SInt ( XLEN.W ) )
val branch=Output( Bool() )
}
class ALU3 extends Module with Config2 {
val io = IO ( new ALUIO3 )
val sum= io.in_A + Mux ( io.alu_Op (0) , -io.in_B , io.in_B )
val cmp= Mux ( io.in_A ( XLEN -1) === io.in_B ( XLEN -1) , sum ( XLEN -1) ,
Mux ( io.alu_Op (1) , io.in_B ( XLEN-1) , io.in_A ( XLEN-1) ) )

val shamt =io.in_B(4 ,0).asUInt
val shin=Mux ( io.alu_Op (3) , io.in_A.asUInt , Reverse ( io.in_A.asUInt  ))
val shiftr =( Cat ( io.alu_Op (0) && shin( XLEN-1) , shin ).asSInt>>shamt ) (XLEN -1 , 0)
val shiftl =Reverse ( shiftr )
val out = Mux ( io.alu_Op===ALU_ADD || io.alu_Op === ALU_SUB , sum.asSInt ,
Mux ( io.alu_Op===ALU_SLT || io.alu_Op === ALU_SLTU , cmp.asSInt ,
Mux ( io.alu_Op===ALU_SRA || io.alu_Op === ALU_SRL  , shiftr.asSInt ,
Mux ( io.alu_Op===ALU_SLL , shiftl.asSInt ,
Mux ( io.alu_Op===ALU_AND  , ( io.in_A & io.in_B ) ,
Mux ( io.alu_Op===ALU_OR  , ( io.in_A | io.in_B ) ,
Mux ( io.alu_Op===ALU_XOR  , ( io.in_A ^ io.in_B ) ,
Mux ( io.alu_Op===ALU_COPY_A  , io.in_A ,
Mux(io.alu_Op===LUI,io.in_B,
Mux(io.alu_Op===BEQ,(io.in_A===io.in_B).asSInt,
Mux(io.alu_Op===BNE,(io.in_A=/=io.in_B).asSInt,
Mux(io.alu_Op===BLT,(io.in_A < io.in_B).asSInt,
Mux(io.alu_Op===BGE,(io.in_A>=io.in_B).asSInt,
Mux(io.alu_Op===BLTU,(io.in_A.asUInt < io.in_B.asUInt).asSInt,
Mux(io.alu_Op===BGEU,(io.in_A.asUInt >=  io.in_B.asUInt).asSInt,
Mux( io.alu_Op===ALU_COPY_B  , io.in_B , 0.S )))) ))) ))) ) ) ) ) ) )
io.out := out
io.sum := sum

when ((io.alu_Op===BEQ) && (io.out===1.S)){
    io.branch:=1.B
}
.elsewhen((io.alu_Op===BNE)&& (io.out===1.S)){
    io.branch:=1.B

}
.elsewhen((io.alu_Op===BLT)&& (io.out===1.S)){
    io.branch:=1.B

}
.elsewhen((io.alu_Op===BGE)&& (io.out===1.S)){
   io.branch:=1.B

}
.elsewhen((io.alu_Op===BLTU)&& (io.out===1.S)){
    io.branch:=1.B

}
.elsewhen((io.alu_Op===BGEU)&& (io.out===1.S)){
    io.branch:=1.B

}
.otherwise{
   io.branch:=0.B

}
}