package SingleCycle
import chisel3._
import chisel3.util._

import scala.language.postfixOps

object ALUOP1 {
// ALU Operations , may expand / modify in future
val ALU_ADD= 0. U (4. W )
val ALU_SUB= 1. U (4. W )
val ALU_AND= 2. U (4. W )
val ALU_OR= 3. U (4. W )
val ALU_XOR= 4. U (4. W )
val ALU_SLT= 5. U (4. W )
val ALU_SLL= 6. U (4. W )
val ALU_SLTU= 7. U (4. W )
val ALU_SRL= 8. U (4. W )
val ALU_SRA= 9. U (4. W )
val ALU_COPY_A = 16. U (4. W )
val ALU_COPY_B = 17. U (4. W )
val ALU_XXX= 18. U (4. W )
val BEQ= 10. U (4. W )
val BNE= 11. U (4. W )
val BLT= 12. U (4. W )
val BGE= 13. U (4. W )
val BLTU= 14. U (4. W )
val BGEU= 15. U (4. W )

}

trait Config1 {
// word length configuration parameter
val XLEN= 32
// ALU operation control signal width
val ALUOP_SIG_LEN = 4
}

import ALUOP1._


class ALUIO3 extends Bundle with Config {
val in_A= Input ( UInt ( XLEN . W ) )
val in_B= Input ( UInt ( XLEN . W ) )
val alu_Op= Input ( UInt ( ALUOP_SIG_LEN . W ) )
val out= Output ( UInt ( XLEN . W ) )
val sum= Output ( UInt ( XLEN . W ) )
}
class ALU3 extends Module with Config {
val io = IO ( new ALUIO3 )
val sum= io . in_A + Mux ( io . alu_Op (0) , - io . in_B , io . in_B )
val cmp= Mux ( io . in_A ( XLEN -1) === io . in_B ( XLEN -1) , sum ( XLEN -1) ,
Mux ( io . alu_Op (1) , io . in_B ( XLEN -1) , io . in_A ( XLEN -1) ) )

val shamt =io.in_B(4 ,0).asUInt
val shin=Mux ( io . alu_Op (3) , io . in_A , Reverse ( io . in_A ) )
val shiftr =( Cat ( io . alu_Op (0) && shin ( XLEN -1) , shin ) . asSInt >> shamt ) (XLEN -1 , 0)
val shiftl =Reverse ( shiftr )
val out =
Mux ( io . alu_Op===ALU_ADD || io . alu_Op === ALU_SUB , sum ,
Mux ( io . alu_Op===ALU_SLT || io . alu_Op === ALU_SLTU , cmp ,
Mux ( io . alu_Op===ALU_SRA || io . alu_Op === ALU_SRL  , shiftr ,
Mux ( io . alu_Op===ALU_SLL , shiftl ,
Mux ( io . alu_Op===ALU_AND  , ( io . in_A & io . in_B ) ,
Mux ( io . alu_Op===ALU_OR  , ( io . in_A | io . in_B ) ,
Mux ( io . alu_Op===ALU_XOR  , ( io . in_A ^ io . in_B ) ,
Mux ( io . alu_Op===ALU_COPY_A  , io . in_A ,
Mux(io.alu_Op===BEQ,io.in_A===io.in_B,
Mux(io.alu_Op===BNE,io.in_A=/=io.in_B,
MUX(io.alu_Op===BLT,io.in_A < io.in_B,
Mux(io.alu_Op===BGE,io.in_A>=io.in_B,
MUX(io.alu_Op===BLTU,io.in_A.asUInt < io.in_B.asUInt,
MUX(io.alu_Op===BGEU,io.in_A.asUInt>=  io.in_B.asUInt,
Mux ( io . alu_Op===ALU_COPY_B  , io . in_B , 0.U )))) ))) )) ) ) ) ) ) )
io . out := out
io . sum := sum
}