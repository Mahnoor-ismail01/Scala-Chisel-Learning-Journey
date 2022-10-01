package labno3
import chisel3._
import ALUOP . _
import chisel3.util._
import scala.language.postfixOps

class ALUIO extends Bundle with Config {
val in_A= Input ( UInt ( XLEN . W ) )
val in_B= Input ( UInt ( XLEN . W ) )
val alu_Op= Input ( UInt ( ALUOP_SIG_LEN . W ) )
val out= Output ( UInt ( XLEN . W ) )
val sum= Output ( UInt ( XLEN . W ) )
}
class ALU extends Module with Config {
val io = IO ( new ALUIO )
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
Mux ( io . alu_Op===ALU_AND  , ( io.in_A & io. in_B ) ,
Mux ( io . alu_Op===ALU_OR  , ( io.in_A | io.in_B ) ,
Mux ( io . alu_Op===ALU_XOR  , ( io . in_A ^ io . in_B ) ,
Mux ( io . alu_Op===ALU_COPY_A  , io . in_A ,
Mux ( io . alu_Op===ALU_COPY_B  , io . in_B , 0.U ) ) ) ) ) ) ) ) )
io . out := out
io . sum := sum
}