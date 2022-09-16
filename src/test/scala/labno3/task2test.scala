package labno3
import chisel3._
import org.scalatest._
import chiseltest._

class Branchtest extends FreeSpec with ChiselScalatestTester{
    "testlabno3" in {
        test(new BranchControl()){
            c=>
            c.io.in_A.poke(1.U)
            c.io.in_B.poke(0.U)
            c.io.branch.poke(true.B)
            c.io.funct3.poke(1.U)
            c.clock.step(1)
            c.io.out.expect(true.B)
        }
    }
}