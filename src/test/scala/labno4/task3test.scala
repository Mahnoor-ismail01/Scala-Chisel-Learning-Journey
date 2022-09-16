package labno4
import chisel3._
import org.scalatest._
import chiseltest._

class alutest1 extends FreeSpec with ChiselScalatestTester{
    "testlabno4" in {
        test(new ALU4()){
            c=>
            c.io.in_A.poke(0.U)
            c.io.alu_Op.poke(2.U)
            c.io.in_B.poke(0.U)
            c.clock.step(1)
            c.io.out.expect(0.U)
            c.io.sum.expect(1.U)
        }
    }
    
}