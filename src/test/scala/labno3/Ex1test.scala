package labno3
import chisel3._
import org.scalatest._
import chiseltest._

class testEncoder4to2 extends FreeSpec with ChiselScalatestTester{
    "testlabno3" in {
        test(new Encoder4to2()){
            c=>
            c.io.in.poke(1.U)
            c.clock.step(1)
            c.io.out.expect(1.U)
        }
    }
}