package SingleCycle
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class ControlTest extends FreeSpec with ChiselScalatestTester{
    "SingleCycle Control" in {
        test(new ControlAndType_Decode()){
            c=>
            c.io.opcode.poke(3.U)
            c.clock.step(1)
            c.io.MemWrite.expect(0.B)
            c.io.Branch.expect(0.B)
            c.io.memRead.expect(1.B)
            c.io.RegWrite.expect(1.B)
            c.io.MemtoReg.expect(1.B)
            c.io.AluOp.expect(0.U)
            c.io.Operand_A_sel.expect(0.U)
            c.io.Operand_B_sel.expect(1.B)
            c.io.Extend_sel.expect(0.U)
            c.io.Next_PC_sel.expect(0.U)
        }
    }
}