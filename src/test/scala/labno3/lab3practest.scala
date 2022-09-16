package labno3
import chisel3._
import org.scalatest._
import chiseltest._

class alutest extends FreeSpec with ChiselScalatestTester{
    "testlabno3" in {
        test(new ALU2()){
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