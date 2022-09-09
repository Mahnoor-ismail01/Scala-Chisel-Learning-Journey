package labno2
import chisel3._
import chiseltest._
import org.scalatest._

class mux2into1test extends FreeSpec with ChiselScalatestTester{
    "testlabno2" in {
        test(new Mux_2to1()){
            c=>
            c.io.in_A.poke(12.U)
            c.io.in_B.poke(1.U)
            c.io.select.poke(0.B)
            c.io.out.expect(1.U)
            c.clock.step(100)
        }
    }
}